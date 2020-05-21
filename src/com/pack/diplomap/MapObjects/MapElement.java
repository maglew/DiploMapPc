package com.pack.diplomap.MapObjects;



import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class MapElement implements Serializable
{
        private static final long serialVersionUID = -3515152604847457796L;
        public String text = "";

        public ArrayList<MyPoint> touchzone = new ArrayList<>();
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


    public  boolean touchhit(Point coord)
{
    boolean inpol = false;

    Polygon poly=new Polygon();
    for(int i=0;i<touchzone.size();i++)
    {
        poly.addPoint(touchzone.get(i).x,touchzone.get(i).y);
    }
    inpol=poly.contains(coord.x,coord.y);

    return inpol;
}



    public  void setedgescount(int count)
{

}

}
