package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class MyPointer
{
    public MyPoint location ;
    public ArrayList<MyPoint> points = new ArrayList<>();

    public MyPointer(MyPoint coord)
    {

        location = coord;
        this.points.add(0,new MyPoint(location.x   ,location.y  ));
        this.points.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.points.add(2,new MyPoint(location.x   + 50,location.y   - 50));

    }

    public MyPointer()
    {

        location = new MyPoint(0,0);
        this.points.add(0,new MyPoint(location.x   ,location.y  ));
        this.points.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.points.add(2,new MyPoint(location.x   + 50,location.y   - 50));


    }


    public  void tick()
    {

    }

    public  void render(Graphics g)
    {
        g.setColor(Color.red);
        Polygon poly=new Polygon();
        for(int i=0;i<points.size();i++)
        {
            poly.addPoint(points.get(i).x,points.get(i).y);
        }
        g.fillPolygon(poly);
    }






}
