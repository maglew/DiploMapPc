package com.pack.diplomap.MapObjects;




import java.awt.*;
import java.io.Serializable;

public class Edge extends MapElement implements Serializable
{
    private static final long serialVersionUID = -2515152604847457796L;

    MyPoint temp = new MyPoint(0, 0);

    byte[] types = { 0, 1, 1, 1 };
    public Edge(MyPoint coord)
    {
        //  bordType.addRange(types);
        this.movable = true;
       // this.id = Guid.NewGuid();
        location = coord;
        relativeLocation = location;
        //locpoints.add(coord);
        //relpoints.add(locpoints[0]);
        //this.location = coord;
        //this.relativeLocation = location;

        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2-5, relativeLocation.y - width / 2-5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 - 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 + 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 - 5, relativeLocation.y - width / 2 + 5));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
        */
        elemid = ++MapElement.numInstances + "E";
    }

    public Edge()
    {
        //  bordType.addRange(types);
        this.movable = true;
        // this.id = Guid.NewGuid();
        location = new MyPoint(0,0);
        relativeLocation = location;
        //locpoints.add(coord);
        //relpoints.add(locpoints[0]);
        //this.location = coord;
        //this.relativeLocation = location;

        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2-5, relativeLocation.y - width / 2-5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 - 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 + 5));
        this.touchzone.add(new MyPoint(relativeLocation.x - width / 2 - 5, relativeLocation.y - width / 2 + 5));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
        */
        elemid = ++MapElement.numInstances + "E";
    }

@Override
    public  void tick(MyPoint wordloc, int size)
{
    if (temp.x != wordloc.x || temp.y != wordloc.y)
    {
        relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y );
        temp = wordloc;
    }
    else
    {
        //      relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y);
    }
    //relativeLocation.x = relativeLocation.x * size;
    //relativeLocation.y = relativeLocation.y * size;

    this.touchzone.get(0).set(relativeLocation.x   - 10,relativeLocation.y   - 10);
    this.touchzone.get(1).set(relativeLocation.x   + 10,relativeLocation.y   - 10);
    this.touchzone.get(2).set(relativeLocation.x   + 10,relativeLocation.y   + 10);
    this.touchzone.get(3).set(relativeLocation.x   - 10,relativeLocation.y   + 10);


}

@Override
    public  void render(Graphics g)
{

    g.setColor(Color.red);



    g.drawRect( relativeLocation.x - width / 4, relativeLocation.y - width / 4, width / 2, width / 2);

 //  float[]a;
    //touchzone.toArray();
  //  g.drawPoints ( touchzone.toArray(a[]),p);

}
/*
@Override
    public  void move(Point coord)
{
    this.relativeLocation = coord;
    this.location = new MyPoint(relativeLocation.x- MapCamera.getWorldLoc().x, relativeLocation.y - MapCamera.getWorldLoc().y);

}
*/

/*
    public override bool touchhit(Point coord)
{

    return base.touchhit(coord);
}
*/
}
