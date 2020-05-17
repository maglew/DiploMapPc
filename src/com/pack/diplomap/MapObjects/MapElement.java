package com.pack.diplomap.MapObjects;



import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class MapElement implements Serializable
{
    private static final long serialVersionUID = -3515152604847457796L;
    public String text = "";


        public ArrayList<MyPoint> touchzone = new ArrayList<>();
   // public ArrayList<byte> bordType = new ArrayList<>();

    public boolean deletable = true;

        public MyPoint location = new MyPoint(0, 0);
      public MyPoint relativeLocation = new MyPoint(0, 0);


    public int width = 10;
    public String elemid;
    public static int numInstances;

    public int size = 0;
    //  public int rotation;
    public boolean movable = true;


    public  void tick(MyPoint wordloc, int size)
{
    this.size = size;




}

    public  void render(Graphics g)
{



}

    public  void move(MyPoint coord)
{



}


/*

    public virtual bool touchhit(Point coord)
{
    bool inpol = false;

    using (var p = new GraphicsPath(touchzone.ToArray(), bordType.ToArray()))
    {
        var newVal = p.IsVisible(coord);
        if (newVal != inpol)
        {
            inpol = newVal;
        }
    }

    return inpol;
}
*/

/*
    public virtual void setedgessize()(int size())
{
    //if (size() == locpoints.size())
    //{ return; }
    //if (size() > locpoints.size())
    //{
    //    for (int i = 0; i < size() - locpoints.size(); i++)
    //    {
    //        locpoints.add(new MyPoint(locpoints[locpoints.size() - 1].x + 15, locpoints[locpoints.size() - 1].y + 15));
    //        relpoints.add(new MyPoint(locpoints[locpoints.size() - 1].x + MapCamera.worldlocation.x, locpoints[locpoints.size() - 1].y + MapCamera.worldlocation.y));
    //        touchzone.add(locpoints.get(i));
    //        bordType.add(1);


    //    }
    //}
    //if (size() < locpoints.size())
    //{
    //    for (int i = locpoints.size() - 1; i > size() - 1; i--)
    //    {
    //        locpoints.RemoveAt(i);
    //        relpoints.RemoveAt(i);
    //        touchzone.RemoveAt(i);
    //        bordType.RemoveAt(i);

    //    }
    //}
}
*/
}
