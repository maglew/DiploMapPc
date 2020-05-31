package com.pack.diplomap.MapObjects;




import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.States.State;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.round;

public class Edge extends MapElement implements Serializable
{
    private static final long serialVersionUID = -2515152604847457796L;


    public Edge(MyPoint coord)
    {
        this.movable = true;
        location = coord;

        this.touchzone.add(0,new MyPoint(location.x   - 10,location.y   - 10));
        this.touchzone.add(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.add(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.add(3,new MyPoint(location.x   - 10,location.y   +10));
        elemid = ++MapElement.numInstances + "E";
    }

    public Edge()
    {
        this.movable = true;

        location = new MyPoint(0,0);

        this.touchzone.add(0,new MyPoint(location.x   - 10,location.y   - 10));
        this.touchzone.add(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.add(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.add(3,new MyPoint(location.x   - 10,location.y   +10));
        elemid = ++MapElement.numInstances + "E";
    }

    @Override
    public  void tick()
    {
        this.touchzone.set(0,new MyPoint(location.x   - 10 ,location.y   - 10));
        this.touchzone.set(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.set(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.set(3,new MyPoint(location.x   - 10,location.y   +10));

    }

    @Override
    public  void render(Graphics g)
    {
        g.setColor(Color.yellow);
        g.drawRect( location.x - width / 4, location.y - width / 4, width / 2, width / 2);

        g.setColor(Color.red);
        Polygon poly=new Polygon();
        for(int i=0;i<touchzone.size();i++)
        {
            poly.addPoint(touchzone.get(i).x,touchzone.get(i).y);
        }
        g.drawPolygon(poly);
/*
    g.setColor(Color.blue);
    Polygon polytouch=new Polygon();
    for(int i=0;i<touchzone.size();i++)
    {
        polytouch.addPoint(touchzone.get(i).x,touchzone.get(i).y);
    }
    g.drawPolygon(polytouch);
*/
    }

    @Override
    public  void move(MyPoint coord)
    {
        location = new MyPoint(coord.x, coord.y);
    }



    @Override
    public boolean touchhit(Point coord)
    {
        return super.touchhit(coord);
    }
}