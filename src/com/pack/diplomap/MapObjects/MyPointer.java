package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class MyPointer extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1515169504847457796L;
/*
    public Grid()
    {
        this.deletable = false;
        this.width = 100;
        this.diagquads = 10;
        this.length = 50;
        location=new MyPoint(0, 0);
        elemid = ++MapElement.numInstances + "G";
    }
    */
    public MyPointer(MyPoint coord)
    {
        this.deletable = false;
        location = coord;
        this.touchzone.add(0,new MyPoint(location.x   ,location.y  ));
        this.touchzone.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.touchzone.add(2,new MyPoint(location.x   + 50,location.y   - 50));
        elemid = ++MapElement.numInstances + "P";
    }

    public MyPointer()
    {
        this.movable = true;
        this.deletable = false;
        location = new MyPoint(0,0);
        this.touchzone.add(0,new MyPoint(location.x   ,location.y  ));
        this.touchzone.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.touchzone.add(2,new MyPoint(location.x   + 50,location.y   - 50));
        elemid = ++MapElement.numInstances + "P";

    }

    @Override
    public  void tick()
    {

    }

    @Override
    public  void render(Graphics g)
    {

        g.setColor(Color.red);
        Polygon poly=new Polygon();
        for(int i=0;i<touchzone.size();i++)
        {
            poly.addPoint(touchzone.get(i).x,touchzone.get(i).y);
        }
     //   g.drawPolygon(poly);
        g.fillPolygon(poly);

    }

    @Override
    public boolean touchhit(Point coord)
    {
        return false;
    }




}
