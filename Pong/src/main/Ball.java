package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public static int x,y;
	private int width, height;
	
	Ball(){
		this.width = 5;
		this.height = 5;
		this.x = Game.width/2;
		this.y = Game.height/2;
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
