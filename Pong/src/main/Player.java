package main;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	public int posicaoX, posicaoY;
	public final int width = 40, height = 5;
	
	//Movimentação
	private boolean left, right;
	
	
	public Player(int x, int y) {
		this.posicaoX = x;
		this.posicaoY = y;
		
		this.left = false;
		this.right = false;
	}
	
	public void tick() {
		if(right) {
			this.posicaoX++;
			
		}else if(left) {
			this.posicaoX--;
		}
			
		//Colisão:
		if(this.posicaoX > Game.width - this.width)
			this.posicaoX = Game.width - this.width;
		
		if(this.posicaoX < 0)
			this.posicaoX = 0;
	}
	
	public void setLeft(boolean value) {
		this.left = value;
	}
	
	public void setRight(boolean value) {
		this.right = value;
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(posicaoX, posicaoY, width, height);
	}
	
	
}
