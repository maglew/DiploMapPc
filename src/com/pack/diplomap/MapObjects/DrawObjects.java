package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public  class DrawObjects implements Serializable
{
    private static final long serialVersionUID = -8515152604847457796L;
    public  ArrayList<MapElement> elements = new ArrayList<>();
    public  ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Grid> grids = new ArrayList<>();
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Wall> walls = new ArrayList<>();

    public DrawObjects()
    {
        rasst();
    }


    public  void addobj()
    {

    }


    public  void rasst()
    {

        elements.clear();

        elements.addAll(grids);
        elements.addAll(edges);
        //  elements.addRange(zones);
        elements.addAll(rooms);
        elements.addAll(walls);

    }


    public void tick(MyPoint worldloc, int size)
    {
        for(MapElement me: elements)
        {
            me.tick(worldloc,size);
        }
    }

    public void render(Graphics g)
    {
        for(MapElement me: elements)
        {
            me.render(g);
        }
    }



    public  void delobj(int id)
    {
        if (id != -1)
        { elements.remove((elements.get(id))); }

    }

        public  int searchObjByCoord(Point touchcoord)
        {
            int i = 0;


            for ( MapElement mo : elements)
            {
                if (mo.touchhit(touchcoord) && mo.deletable)
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
                elements.set(i,element) ;
            }
        }
    }



    public  void addNewEdge(MyPoint coord)
    {
        // elements.add(new com.com.pack.diplommapandr.Edge(coord));
        edges.add(new Edge(coord));
        rasst();
    }


    public void addNewRoom(Point coord)
    {

        edges.add(new Edge(new MyPoint(coord.x - 50, coord.y - 50)));
        edges.add(new Edge(new MyPoint(coord.x + 50, coord.y - 50)));
        edges.add(new Edge(new MyPoint(coord.x + 50, coord.y + 50)));
        edges.add(new Edge(new MyPoint(coord.x - 50, coord.y + 50)));

        rooms.add(new Room(edges.get(edges.size()-4), edges.get(edges.size() - 3), edges.get(edges.size() - 2), edges.get(edges.size() - 1)));

        rasst();
    }

    public  void addNewWall(int a, int b)
    {
        walls.add(new Wall(edges.get(a-1),edges.get(b-1)));
        rasst();
    }

}
