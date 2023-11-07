package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	public static int scorePlayer = 0, scoreEnemy = 0;
	
	public static void incrementPlayerScore() {
		scorePlayer++;
		Background.changeBkgColor();
	}
	
	public static void incrementEnemyScore() {
		scoreEnemy++;
		Background.changeBkgColor();
	}
	
	public static void render(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);
		g.drawString(Integer.toString(scorePlayer),10,Game.height/2 - 10); 
		g.drawString(Integer.toString(scoreEnemy),10,Game.height/2 + 10); 
	}
}
