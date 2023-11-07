package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Player player1;
	public static Player enemy;
	public static Ball ball;
	public static Colisoes colisoes;
	
	
	final public static int width = 160;
	final public static int height = 120;
	final private int scale = 3;
	
	Thread thread;
	private boolean isRunning;
	
	//Cria uma camada para carregar os gráficos
	BufferedImage layer;
	
	public Game() {
		
		this.setPreferredSize(new Dimension(width*scale, height*scale));
		this.jframe();
		
		layer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		this.addKeyListener(this);
		
		this.player1 = new Player(0,0);
		this.enemy = new Player(width/2 - 10, height - 5);
		this.ball = new Ball();
		this.colisoes = new Colisoes();
	
	}		
	
	public static void main(String args[]) {
		
		Game game = new Game();
		game.start();
		
	}
		
	//moldura da janela
	public void jframe() {
		JFrame jframe = new JFrame("Pong");
		jframe.setVisible(true);
		jframe.add(this);
		jframe.pack();
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Lógica----------------------------------
	private void tick() {
		
		this.player1.tick();
		this.enemy.tick();
		this.ball.tick();
		this.colisoes.tick();
	}
	
	//Gráficos------------------------------------
	private void render() {
		//Pre-carregamentos de imagem p/ melhorar a optimização da renderização.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = layer.getGraphics();
	
		Background.render(g);
		this.player1.render(g);
		this.enemy.render(g);
		this.ball.render(g);
		Score.render(g);
		
	
		
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0 ,0, width*this.scale, height*this.scale, null);
		
		bs.show();
		
	}
	
	//thread-------------------------------------
	public  synchronized void start() {
		this.thread = new Thread(this);
		this.isRunning = true;
		
		this.thread.start();
	}
	
	public  synchronized void stop() {
		this.isRunning = false;
		
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	//movimentação-------------------------------------
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
			this.player1.setRight(true);
			
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) 
			this.player1.setLeft(true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
			this.player1.setRight(false);
			
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) 
			this.player1.setLeft(false);
	}
}
