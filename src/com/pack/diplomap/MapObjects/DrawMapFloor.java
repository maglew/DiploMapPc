package com.pack.diplomap.MapObjects;

import com.pack.diplomap.gfx.Assets;

import java.awt.*;
import java.io.Serializable;

public class DrawMapFloor implements Serializable
{
    private static final long serialVersionUID = -7515152604847457796L;
    public DrawObjects drawObjects;

    public DrawMapFloor()
    {
        drawObjects = new DrawObjects();
    }

    public void tick()
    {
        drawObjects.tick();
    }

    public void render(Graphics g)
    {
        drawObjects.render(g);
    }

    public DrawObjects getdraw()
    {
        return drawObjects;
    }

}
