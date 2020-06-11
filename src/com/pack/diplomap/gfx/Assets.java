package com.pack.diplomap.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage firstFloor, secondFloor, thirdFloor, forthFloor,map;

    public static void init()
    {
        /*
        SpriteSheet first = new SpriteSheet(ImageLoader.loadImage("/textures/1floor.png"));
        SpriteSheet second = new SpriteSheet(ImageLoader.loadImage("/textures/2floor.png"));
        SpriteSheet third = new SpriteSheet(ImageLoader.loadImage("/textures/3floor.png"));
        SpriteSheet fourth = new SpriteSheet(ImageLoader.loadImage("/textures/4floor.png"));
        SpriteSheet mapsheet = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));
*/
        SpriteSheet first = new SpriteSheet(ImageLoader.loadImage("/textures/firstfloor.jpg"));
        SpriteSheet second = new SpriteSheet(ImageLoader.loadImage("/textures/secondfloor.jpg"));
        SpriteSheet third = new SpriteSheet(ImageLoader.loadImage("/textures/thirdfloor.jpg"));
        SpriteSheet fourth = new SpriteSheet(ImageLoader.loadImage("/textures/fourthfloor.jpg"));
        //SpriteSheet mapsheet = new SpriteSheet(ImageLoader.loadImage("/textures/map.jpg"));

       //   map=mapsheet.getSheet();
          firstFloor = first.getSheet();
          secondFloor = second.getSheet();
          thirdFloor = third.getSheet();
          forthFloor = fourth.getSheet();

       // firstFloor = first.crop(0, 0, first.getWidth(),first.getHeight());
      //  secondFloor = second.crop(0, 0, first.getWidth(), first.getHeight());
      //  thirdFloor = third.crop(0 , 0, first.getWidth(), first.getHeight());
      //  forthFloor = fourth.crop(0 , 0, first.getWidth(), first.getHeight());
     //   map = mapsheet.crop(0 , 0, first.getWidth(), first.getHeight());
    }


}
