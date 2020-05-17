package com.pack.diplomap.MapObjects;


import java.awt.*;
import java.io.Serializable;

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
        dest = new MyPoint(Math.abs(B.relativeLocation.x - A.relativeLocation.x), Math.abs(B.relativeLocation.y - A.relativeLocation.y));

        touchzone.add(new MyPoint(A.relativeLocation.x + 3, A.relativeLocation.y - 3));
        touchzone.add(new MyPoint(B.relativeLocation.x + 3, B.relativeLocation.y - 3));
        touchzone.add(new MyPoint(B.relativeLocation.x - 3, B.relativeLocation.y + 3));
        touchzone.add(new MyPoint(A.relativeLocation.x - 3, A.relativeLocation.y + 3));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
*/
elemid =++MapElement.numInstances+"W";
    }

    public Wall()
    {
        movable = true;
        this.A = new Edge(new MyPoint(0,0));
        this.B = new Edge(new MyPoint(0,0));
        id++;
        dest = new MyPoint(Math.abs(B.relativeLocation.x - A.relativeLocation.x), Math.abs(B.relativeLocation.y - A.relativeLocation.y));

        touchzone.add(new MyPoint(A.relativeLocation.x + 3, A.relativeLocation.y - 3));
        touchzone.add(new MyPoint(B.relativeLocation.x + 3, B.relativeLocation.y - 3));
        touchzone.add(new MyPoint(B.relativeLocation.x - 3, B.relativeLocation.y + 3));
        touchzone.add(new MyPoint(A.relativeLocation.x - 3, A.relativeLocation.y + 3));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
*/
        elemid =++MapElement.numInstances+"W";
    }

@Override
    public  void tick(MyPoint relativeLocation, int size)
{

    dest = new MyPoint(Math.abs(B.relativeLocation.x - A.relativeLocation.x), Math.abs(B.relativeLocation.y - A.relativeLocation.y));
    A.tick(relativeLocation, size);
    B.tick(relativeLocation, size);
    touchzone.get(0).set(A.relativeLocation.x + 3, A.relativeLocation.y - 3);
    touchzone.get(1).set(A.relativeLocation.x + 3, A.relativeLocation.y - 3);
    touchzone.get(2).set(A.relativeLocation.x - 3, A.relativeLocation.y + 3);
    touchzone.get(3).set(A.relativeLocation.x -3, A.relativeLocation.y + 3);

}

@Override
    public  void render(Graphics g)
{
    /*
    Paint p=new Paint();
    p.setColor(Color.GREEN);
    p.setStrokeWidth(3);
    canvas.drawLine(A.relativeLocation.x,A.relativeLocation.y,B.relativeLocation.x,B.relativeLocation.y,p);
    //g.DrawPolygon(pen2, touchzone.ToArray());

     */
}



    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
