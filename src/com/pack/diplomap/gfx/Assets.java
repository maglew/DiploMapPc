package com.pack.diplomap.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage firstFloor, secondFloor, thirdFloor, forthFloor;
    public static BufferedImage firstlegend, secondlegend, thirdlegend, forthlegend;

    public static void init()
    {

        SpriteSheet first = new SpriteSheet(ImageLoader.loadImage("/textures/firstfloor.jpg"));
        SpriteSheet second = new SpriteSheet(ImageLoader.loadImage("/textures/secondfloor.jpg"));
        SpriteSheet third = new SpriteSheet(ImageLoader.loadImage("/textures/thirdfloor.jpg"));
        SpriteSheet fourth = new SpriteSheet(ImageLoader.loadImage("/textures/fourthfloor.jpg"));

        SpriteSheet firstleg = new SpriteSheet(ImageLoader.loadImage("/textures/leg 1-min.jpg"));
        SpriteSheet secondleg = new SpriteSheet(ImageLoader.loadImage("/textures/leg 2-min.jpg"));
        SpriteSheet thirdleg = new SpriteSheet(ImageLoader.loadImage("/textures/leg 3-min.jpg"));
        SpriteSheet fourthleg = new SpriteSheet(ImageLoader.loadImage("/textures/leg 4-min.jpg"));

          firstFloor = first.getSheet();
          secondFloor = second.getSheet();
          thirdFloor = third.getSheet();
          forthFloor = fourth.getSheet();

        firstlegend = firstleg.getSheet();
        secondlegend = secondleg.getSheet();
        thirdlegend = thirdleg.getSheet();
        forthlegend = fourthleg.getSheet();
    }


}
