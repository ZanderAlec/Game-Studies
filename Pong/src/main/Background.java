package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Background {
	
	public static String bkgColor;
	
	public static void changeBkgColor() {
		
		String newColor = CustomColors.getRandomColor();
				
		while(bkgColor == newColor) {
			newColor = CustomColors.getRandomColor();
		}
		
		bkgColor = newColor;
		
		System.out.println(bkgColor);
	}
	
	
	public static void render(Graphics g) {
		if(bkgColor == null) {
			g.setColor(Color.decode(CustomColors.getColor("darkGrey")));
			
		}else {
			g.setColor(Color.decode(bkgColor));
		}
		
		g.fillRect(0, 0, Game.width, Game.height);
		
		g.setColor(Color.white);
		g.drawLine(0, Game.height/2 - 5, Game.width, Game.height/2 - 5);
	}
}
