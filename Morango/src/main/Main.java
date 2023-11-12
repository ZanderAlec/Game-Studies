package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isRunning;
	public Thread thread;
	public JFrame frame;
	
	public static final int width = 160;
	public static final int height = 120;
	public static final int scale = 3;
	
	public BufferedImage layer;
	
	
	public static Plant plant;
	public TimePassage time;
	
	public Main() {
		this.setPreferredSize(new Dimension(width * scale, height * scale));
		this.frameInit();
		
		layer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		this.plant = new Plant(width*scale/2, height*scale - 100);
		this.time = new TimePassage();
	}
	
	public static void main(String args[]) {
		Main game = new Main();
		
		game.start();
		
	}
	
	//screen----------------------------------------
	
	public void frameInit() {
		this.frame = new JFrame("Morango");
		this.frame.setVisible(true);
		this.frame.add(this);
		this.frame.pack();
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	//threads---------------------------------------
	public synchronized void start() {
		this.thread = new Thread(this);
		this.isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		this.isRunning = false;
		
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tick() {
		this.time.tick();
	}
	
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = this.layer.getGraphics();
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, width*scale, height*scale);
		
		//ground
		g.setColor(Color.ORANGE);
		g.fillRect(0, this.height/2+20, width*scale, height*scale);
		
		g = bs.getDrawGraphics();
		g.drawImage(this.layer, 0 ,0, this.width*this.scale, this.height*this.scale, null);
		
		this.time.render(g);
		this.plant.render(g);
		
		
		bs.show();
	}
	
	@Override
	public void run() {
		while(isRunning) {
			this.tick();
			this.render();
			
			try {
				Thread.sleep(1000/60);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.stop();
		
	}
}
