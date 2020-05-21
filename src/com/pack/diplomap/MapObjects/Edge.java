package com.pack.diplomap.MapObjects;




import com.pack.diplomap.Interface.MapCamera;

import java.awt.*;
import java.io.Serializable;

public class Edge extends MapElement implements Serializable
{
    private static final long serialVersionUID = -2515152604847457796L;

    MyPoint temp = new MyPoint(0, 0);
    MyPoint razn = new MyPoint(0, 0);

    public Edge(MyPoint coord)
    {
        this.movable = true;
        location = coord;
        relativeLocation = location;

        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2-5, relativeLocation.y - width / 2-5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 - 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 + 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 - 5, relativeLocation.y - width / 2 + 5));

        elemid = ++MapElement.numInstances + "E";
    }

    public Edge()
    {

        this.movable = true;

        location = new MyPoint(0,0);
        relativeLocation = location;

        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2-5, relativeLocation.y - width / 2-5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 - 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 + 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 - 5, relativeLocation.y - width / 2 + 5));

        elemid = ++MapElement.numInstances + "E";
    }

@Override
    public  void tick(MyPoint wordloc, int size)
{
    /*
    if (temp.x != wordloc.x || temp.y != wordloc.y)
    {
        relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y );
        temp = wordloc;
    }
    else
    {
        //      relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y);
    }
    */


    relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y );
  //  relativeLocation.x = relativeLocation.x * size;
   // relativeLocation.y = relativeLocation.y * size;
    this.touchzone.get(0).set(relativeLocation.x   - 10,relativeLocation.y   - 10);
    this.touchzone.get(1).set(relativeLocation.x   + 10,relativeLocation.y   - 10);
    this.touchzone.get(2).set(relativeLocation.x   + 10,relativeLocation.y   + 10);
    this.touchzone.get(3).set(relativeLocation.x   - 10,relativeLocation.y   + 10);

razn=new MyPoint(relativeLocation.x-location.x,relativeLocation.y-location.y);
}

@Override
    public  void render(Graphics g)
{

    g.setColor(Color.yellow);



    g.drawRect( relativeLocation.x - width / 4, relativeLocation.y - width / 4, width / 2, width / 2);

    g.setColor(Color.blue);
    g.drawRect( location.x - width / 5, location.y - width / 5, width -6, width -6);

    g.setColor(Color.red);
    Polygon poly=new Polygon();
    for(int i=0;i<touchzone.size();i++)
    {
        poly.addPoint(touchzone.get(i).x,touchzone.get(i).y);
    }

    g.drawPolygon(poly);


}

@Override
    public  void move(MyPoint coord)
{

    location = new MyPoint(coord.x-razn.x, coord.y-razn.y);
}



    @Override
    public boolean touchhit(Point coord) {
        return super.touchhit(coord);
    }
}
