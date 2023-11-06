package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	public static int x,y;
	public final int width = 5, height = 5;
	
	private int speed, dir;
	
	Ball(){
		this.x = Game.width/2;
		this.y = Game.height/2;
		this.speed = 1;
		this.dir = this.calcDirInicio();
	}
	
	//Direção inicial da bolinha
	public int calcDirInicio() {
		Random random = new Random();
		int num = random.nextInt(50);
		
		if(num <= 25)
			return this.dir = -1;
			
		
		return this.dir = 1;
	}
	
	public void tick(){

		
		//Colisão:
		if(Game.colisoes.boundBall.intersects(Game.colisoes.boundPlayer)) {
			dir *= -1;
			
		}else if(Game.colisoes.boundBall.intersects(Game.colisoes.boundEnemy)) {
			dir *= -1;
		}
		
		//Move a bolinha:
		this.x += speed * dir;
		this.y += speed * dir;
				
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
