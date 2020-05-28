package com.pack.diplomap.MapObjects;


import com.pack.diplomap.States.State;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.round;

public class Wall extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1415152604847457796L;
    Edge A;
    Edge B;
    int id;
    MyPoint dest;

    public Wall(Edge A, Edge B)
    {
        movable = true;
        this.A = A;
        this.B = B;
        id++;
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));

        touchzone.add(new MyPoint(A.location.x + 3, A.location.y - 3));
        touchzone.add(new MyPoint(B.location.x + 3, B.location.y - 3));
        touchzone.add(new MyPoint(B.location.x - 3, B.location.y + 3));
        touchzone.add(new MyPoint(A.location.x - 3, A.location.y + 3));
        relativetouchzone=touchzone;

        elemid =++MapElement.numInstances+"W";
    }

    public Wall()
    {
        movable = true;
        this.A = new Edge(new MyPoint(0,0));
        this.B = new Edge(new MyPoint(0,0));
        id++;
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));
        touchzone.add(new MyPoint(A.location.x + 3, A.location.y - 3));
        touchzone.add(new MyPoint(B.location.x + 3, B.location.y - 3));
        touchzone.add(new MyPoint(B.location.x - 3, B.location.y + 3));
        touchzone.add(new MyPoint(A.location.x - 3, A.location.y + 3));
        relativetouchzone=touchzone;
        elemid =++MapElement.numInstances+"W";
    }

    @Override
    public  void tick()
    {
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));
        A.tick();
        B.tick();
        relativetouchzone.set(0,new MyPoint( A.location.x + 3, A.location.y - 3));
        relativetouchzone.set(1,new MyPoint( B.location.x + 3, B.location.y - 3));
        relativetouchzone.set(2,new MyPoint( B.location.x - 3, B.location.y + 3));
        relativetouchzone.set(3,new MyPoint( A.location.x - 3, A.location.y + 3));

        for(int i=0;i<relativetouchzone.size();i++)
        {
            touchzone.set(i,new MyPoint((relativetouchzone.get(i).x)*round(State.getCurrentState().mapCamera.getSize()),(relativetouchzone.get(i).y)*round(State.getCurrentState().mapCamera.getSize())) );
        }

    }

    @Override
    public  void render(Graphics g)
    {
        g.setColor(Color.GREEN);


        g.drawLine(A.location.x,A.location.y,B.location.x,B.location.y);


        g.setColor(Color.blue);
        Polygon poly=new Polygon();
        for(int i=0;i<relativetouchzone.size();i++)
        {
            poly.addPoint(relativetouchzone.get(i).x/round(State.getCurrentState().mapCamera.getSize()),relativetouchzone.get(i).y/round(State.getCurrentState().mapCamera.getSize()));

        }

        g.drawPolygon(poly);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    @Override
    public boolean touchhit(Point coord)
    {
        return super.touchhit(coord);
    }
}

