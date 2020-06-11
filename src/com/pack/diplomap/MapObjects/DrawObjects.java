package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public  class DrawObjects implements Serializable
{
    private static final long serialVersionUID = -8515152604847457796L;
    public  ArrayList<MapElement> elements = new ArrayList<>();
    public  ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Grid> grids = new ArrayList<>();
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Wall> walls = new ArrayList<>();
    public  MapImage image=new MapImage();
   // public ArrayList<MyPointer> myPointers = new ArrayList<>();
    public MyPointer pointer=new MyPointer();

    public DrawObjects()
    {
        clearadd();
    }


    public  void addobj()
    {

    }

    public  void clearadd()
    {
        elements.clear();
        elements.add(image);
       // elements.addAll(grids);
        elements.addAll(edges);
        elements.addAll(rooms);
        elements.addAll(walls);
        elements.add(pointer);
    }


    public void tick()
    {
        for(MapElement me: elements)
        {
            me.tick();
        }
    }

    public void render(Graphics g)
    {

        for(MapElement me: elements)
        {
            me.render(g);
        }
      //  pointer.render(g);
    }



    public  void delobj(int id)
    {
        if (id != -1&&elements.get(id).deletable)
        {
            elements.remove((elements.get(id)));
        }
    }

    public  int searchObjByCoord(Point touchcoord)
    {
        int i = 0;


        for ( MapElement mo : elements)
        {
            if (mo.touchhit(touchcoord))
            {
                return i;
            }
            i++;
        }

        return -1;
    }

    public  MapElement getElement(int id)
    {
        return elements.get(id);
    }


    public  void moveElement(int id, MyPoint coord)
    {
        elements.get(id).move(coord);
    }


    public  void setElement(MapElement element)
    {
        for (int i = 0; i < elements.size(); i++)
        {
            if (elements.get(i).elemid== element.elemid)
            {
                elements.set(i,element);
            }
        }
    }

    public  void addPointer(MyPoint myPoint)
    {
        pointer=new MyPointer(myPoint);
        clearadd();
    }

    public  void addimage(MapImage im)
    {
        image=im;
        clearadd();
    }


    public  void addNewEdge(MyPoint coord)
    {
        edges.add(new Edge(coord));
        clearadd();
    }


    public void addNewRoom(MyPoint coord)
    {
        edges.add(new Edge(new MyPoint(coord.x - 50, coord.y - 50)));
        edges.add(new Edge(new MyPoint(coord.x + 50, coord.y - 50)));
        edges.add(new Edge(new MyPoint(coord.x + 50, coord.y + 50)));
        edges.add(new Edge(new MyPoint(coord.x - 50, coord.y + 50)));
        rooms.add(new Room(edges.get(edges.size()-4), edges.get(edges.size() - 3), edges.get(edges.size() - 2), edges.get(edges.size() - 1)));
        clearadd();
    }

    public  void addNewWall(int a, int b)
    {
        walls.add(new Wall(edges.get(a-1),edges.get(b-1)));
        clearadd();
    }

}
