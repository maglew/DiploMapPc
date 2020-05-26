package com.pack.diplomap.MapObjects;


import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Grid extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1515152604847457796L;
    int diagquads;

    int length;
    int templength = 0;

    public Grid(int diagquads,int width)
    {
        this.deletable = false;
        this.width = width;
        this.diagquads = diagquads;
        location=new MyPoint(0, 0);
        elemid = ++MapElement.numInstances + "G";


    }

    public Grid()
    {

        this.deletable = false;
        this.width = 100;
        this.diagquads = 10;
        this.length = 50;
        location=new MyPoint(0, 0);

        elemid = ++MapElement.numInstances + "G";

    }

    @Override
    public  void tick()
    {

    }

    @Override
    public  void render(Graphics g)
    {

        g.setColor(Color.white);

        for(int i=0;i<=diagquads;i++)
        {
            for(int j=0;j<=diagquads;j++)
            {
                g.drawRect(location.x+width*j,location.y+width *i,width,width);
            }
        }


    }

/*
    @Override
    public  bool touchhit(Point coord)
{
    return false;
}
*/

}
