package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class TimePassage {
	
	private int daysCount;
	private Timer timer;
	
	public TimePassage(){
		this.daysCount = 0;
		
	}
	
	
	public void tick() {
		this.timer = new Timer();
		
		int delay = (60*1000)/4;
		
		this.timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Main.plant.grow();
				daysCount++;
			}
			
		}, delay);
		
	}
	
	public String getDaysMessage() {
		String time = "Dia: ";
		time += Integer.toString(daysCount);
		return time;
		
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("Arial",Font.BOLD,5*Main.scale));
		g.setColor(Color.white);
		g.drawString(getDaysMessage(),10, 20); 
	}
}
