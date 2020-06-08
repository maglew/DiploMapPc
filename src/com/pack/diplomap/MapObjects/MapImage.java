package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class MapImage extends MapElement implements Serializable
{
    private static final long serialVersionUID = -8515152004847457796L;
    transient BufferedImage image;

    public MapImage(BufferedImage image,MyPoint loc)
    {
        this.image = image;
        this.location=loc;
    }

    public MapImage(MyPoint loc)
    {
        this.location=loc;
    }

    public MapImage()
    {
        this.location=new MyPoint(0,0);
        image=null;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics g)
    {
if(image!=null)
        g.drawImage(image,  location.x, location.y, image.getWidth(), image.getHeight(), null);

    }

    @Override
    public void move(MyPoint coord) {
        super.move(coord);
    }
}
