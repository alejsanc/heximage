package com.cuadernoinformatica.heximage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

public class HexImage {
	
	protected static char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F'};
	
	public void read(String file, float xStart, float yStart, int characterWidth, int characterHeight,
			float xIncrement, float yIncrement, int lineCharacters, int bitPixels, boolean debug,
			String debugDirectory) throws IOException {
		
		float x = xStart;
		float y = yStart;
		
		BufferedImage image = ImageIO.read(new File(file));
		
		boolean moreLines = true;
		
		do {
			
			for (int c = 0; c < lineCharacters; c++) {
	
				BufferedImage characterImage = image.getSubimage((int) x, (int) y, characterWidth,
						characterHeight);
				
				int pixels[] = new int[4];
				int bits[] = new int[4];
				
				for (int cy = 0; cy < characterHeight; cy++) {
					for (int cx = 0; cx < characterWidth; cx++) {
						int rgb = characterImage.getRGB(cx, cy);
						
						if (rgb < -1000000) {
							
							if (cx < characterWidth / 2) {
								if (cy < characterHeight / 2) {
									pixels[0]++;
								} else {
									pixels[2]++;
								}
							} else {
								if (cy < characterHeight / 2) {
									pixels[1]++;
								} else {
									pixels[3]++;
								}
							}
						}
					}
				}
				
				if (pixels[0] == 0 && pixels[1] == 0 && pixels[2] == 0 && pixels[3] == 0) {
					moreLines = false;
					break;
				}
				
				for (int b = 0; b < 4 ; b++) {
					bits[b] = pixels[b] > bitPixels ? 1 : 0;
				}
				
				int character = bits[0] << 3 | bits[1] << 2 | bits[2] << 1 | bits[3];
				
				System.out.print(characters[character]);
							
				if (debug) {
					ImageIO.write(characterImage, "jpg", new File(debugDirectory 
							+ "y" + (int) y + "-x" + (int) x + ".jpg"));
				}
				
				x += xIncrement;
			}
			
			x = xStart;
			y += yIncrement;
			
			System.out.println();
			
		} while (moreLines);
	}

	public static void main(String[] args) throws Exception {
		
		String file = args[0];
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(args[1]));
		
		float xStart = Float.parseFloat(properties.getProperty("xStart"));
		float yStart = Float.parseFloat(properties.getProperty("yStart"));

		int characterWidth = Integer.parseInt(properties.getProperty("characterWidth"));
		int characterHeight = Integer.parseInt(properties.getProperty("characterHeight"));
		
		float xIncrement = Float.parseFloat(properties.getProperty("xIncrement"));
		float yIncrement = Float.parseFloat(properties.getProperty("yIncrement"));
		
		int lineCharacters = Integer.parseInt(properties.getProperty("lineCharacters"));
		int bitPixels = Integer.parseInt(properties.getProperty("bitPixels"));
		
		boolean debug = Boolean.parseBoolean(properties.getProperty("debug"));
		String debugDirectory = properties.getProperty("debugDirectory");
		
		HexImage image = new HexImage();
		image.read(file, xStart, yStart, characterWidth, characterHeight, xIncrement, yIncrement,
				lineCharacters, bitPixels, debug, debugDirectory);
	}
}