package com.pack.diplomap.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}

	public BufferedImage getSheet() {
		return sheet;
	}

	public int getHeight()
	{
	return	sheet.getHeight();
	}
	public int getWidth()
	{
		return	sheet.getWidth();
	}
}
