package main;

import java.awt.Color;
import java.awt.Graphics;

public class Plant {
	
	private int width, height;
	private int x, y;
	
	//Status
	private int perGrow;
	public boolean  watered;
	public boolean fertilized;
	
	public Plant(int x, int y){
		this.perGrow = 0;
		this.watered = true;
		this.fertilized = true;
		this.width = 8;
		this.height = 8;
		this.x = x;
		this.y = y;
	}
	
	//grow percentage
	public void grow() {
		
		if(this.perGrow >= 100)
			return;
		
		if(this.watered) {
			
			this.perGrow += 10;
			this.height -= 10;
			
			if(this.fertilized) {
				this.perGrow += 5;
				this.height -= 4;
			}
			
		}
		
		System.out.println("Grow percentage: "+this.perGrow);
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
