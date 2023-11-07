package main;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Guarda todas as cores customizadas.
public class CustomColors {
	
	public static HashMap<String, String> colorList;
	
	//Instancia o hashMap quando a classe é carregada
	static{
		colorList = new HashMap<String, String>();
		
		colorList.put("pink", "#f2c299");
		colorList.put("darkBlue", "#023859");
		colorList.put("lightGreen", "#b7d984");
		colorList.put("darkGrey", "#403D3E");
		colorList.put("brown", "#7E5B35");
		colorList.put("red", "#A4403E");
		colorList.put("grey", "#A6948D");
		colorList.put("purple", "#49378C");
	}
	
	public static String getColor(String colorName) {
		return colorList.get(colorName);
	}
	
	public static String getRandomColor() {
		Random rand = new Random();	
		
		int num = rand.nextInt(colorList.size());
		int i = 0;
		
		String resultado = "";
		
		for(Map.Entry<String,String> color : colorList.entrySet()) {
			if(i == num) {
				resultado =  color.getValue();
				break;
			}
			
			i++;
		}
		
		return resultado;
	}
	
}
