package com.pack.diplomap.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage firstFloor, secondFloor, thirdFloor, forthFloor,map;

    public static void init()
    {

        SpriteSheet first = new SpriteSheet(ImageLoader.loadImage("/textures/firstfloor.jpg"));
        SpriteSheet second = new SpriteSheet(ImageLoader.loadImage("/textures/secondfloor.jpg"));
        SpriteSheet third = new SpriteSheet(ImageLoader.loadImage("/textures/thirdfloor.jpg"));
        SpriteSheet fourth = new SpriteSheet(ImageLoader.loadImage("/textures/fourthfloor.jpg"));

          firstFloor = first.getSheet();
          secondFloor = second.getSheet();
          thirdFloor = third.getSheet();
          forthFloor = fourth.getSheet();


    }


}
