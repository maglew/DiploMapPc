package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapImage extends MapElement
{
    BufferedImage image;

    public MapImage(BufferedImage image,MyPoint loc)
    {

        this.image = image;
        this.location=loc;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,  location.x, location.y, image.getWidth(), image.getHeight(), null);

    }

    @Override
    public void move(MyPoint coord) {
        super.move(coord);
    }
}
