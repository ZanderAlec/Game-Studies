package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public static double x,y;
	public final int width = 5, height = 5;
	
	private double speed;
	public double dx, dy;
	
	Ball(){
		this.reseteBall();
		this.calcAngle();
	}
	
	
	//Direção e angulo da bolinha
	public void calcAngle() {
		int angle = new Random().nextInt(120 - 45) + 45 + 1;
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy =  Math.sin(Math.toRadians(angle));
	}
	
	
	private void reseteBall() {
		this.speed = 1.4;
		
		this.x = Game.width/2;
		this.y = Game.height/2;
		
		this.calcAngle();
	}
	
	private void incrementSpeed() {
		this.speed += 0.2;
	}
	
	//Lógica
	public void tick(){
		
		
		//Colisão parede:
		if(this.x + (this.dx*this.speed) < 0 || this.x + this.width + (this.dx * this.speed) >= Game.width) {
			dx*= -1;
		}
		
		
		//Score
		if(y > Game.height || y  < 0) {
			reseteBall();
			return;
		}
		
		//Jogadores jogadores
		if(Game.colisoes.boundBall.intersects(Game.colisoes.boundPlayer)) {
			this.calcAngle();
			
			if(this.dy < 0)
				this.dy *= -1;
			
			this.incrementSpeed();
			
		}else if(Game.colisoes.boundBall.intersects(Game.colisoes.boundEnemy)) {
			this.calcAngle();
			
			if(this.dy > 0)
				this.dy *= -1;
			
			this.incrementSpeed();

		}
		
		System.out.println("dx: "+this.dx+"\ndy: "+this.dy);
		
	
		//Move a bolinha:
		this.x += this.speed * this.dx;
		this.y += this.speed * this.dy;
				
	}
	
	
	//Gráficos
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
	}
}
