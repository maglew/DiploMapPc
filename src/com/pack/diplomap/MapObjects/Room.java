package com.pack.diplomap.MapObjects;



import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.States.State;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Room extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1315152604847457796L;

    public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<MyPoint> dest = new ArrayList<>();

    MyPoint razn = new MyPoint(0, 0);

    public Room(Edge A, Edge B, Edge C, Edge D)
    {
        location = new MyPoint((A.location.x+ C.location.x)/2, (A.location.y + C.location.y) / 2);
        relativeLocation = location;

        this.movable = true;


        this.edges.add(A);
        this.edges.add(B);
        this.edges.add(C);
        this.edges.add(D);

        walls.add(new Wall(A, B));
        walls.add(new Wall(B, C));
        walls.add(new Wall(C, D));
        walls.add(new Wall(D, A));

        touchzone.add(edges.get(0).relativeLocation);
        touchzone.add(edges.get(1).relativeLocation);
        touchzone.add(edges.get(2).relativeLocation);
        touchzone.add(edges.get(3).relativeLocation);


        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
    }

    public Room()
    {

        location = new MyPoint(0, 0);
        relativeLocation = location;

        this.movable = true;
        //  this.id = Guid.NewGuid();

        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));

        walls.add(new Wall(new Edge(new MyPoint(0,0)),new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));

        touchzone.add(edges.get(0).relativeLocation);
        touchzone.add(edges.get(1).relativeLocation);
        touchzone.add(edges.get(2).relativeLocation);
        touchzone.add(edges.get(3).relativeLocation);

        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
    }

@Override
    public  void tick(MyPoint wordloc, int size)
{
   relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y );


    for (int i = 0; i < dest.size(); i++)
    {
        dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
    }

    for (int j = 0; j < edges.size() ; j++)
    {
        edges.get(j).tick(wordloc,size);

    }


    for (int j = 0; j < walls.size() ; j++)
    {
        walls.get(j).tick(wordloc, size);

    }

    for (int j = 0; j < touchzone.size() ; j++)
    {
        touchzone.get(j).set(edges.get(j).relativeLocation.x,edges.get(j).relativeLocation.y);
    }


    razn=new MyPoint(relativeLocation.x-location.x,relativeLocation.y-location.y);
}

@Override
    public  void render(Graphics g)
{

    g.setColor(Color.WHITE);

    g.drawRect(relativeLocation.x-5, relativeLocation.y - 5, 10, 10);
    for (int j = 0; j < edges.size() ; j++)
    {
        edges.get(j).render(g);

    }

/*
    for (int j = 0; j < walls.size() ; j++)
    {
        walls.get(j).render(g);

    }
    */
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

    for (int j = 0; j < edges.size(); j++)
    {
        edges.get(j).move(new MyPoint(coord.x-dest.get(j).x, coord.y-dest.get(j).y ));
    }
}



    @Override
    public boolean touchhit(Point coord) {
        return super.touchhit(coord);
    }


    public  void setedgessize(int size)
{
    if (size == edges.size())
    {

    }
    if (size > edges.size())
    {
        for (int i = 0; i < size - edges.size(); i++)
        {
            State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.add(new Edge(new MyPoint( edges.get(edges.size() - 1).location.x - 15, edges.get( edges.size() - 1).location.y - 15)));

            State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.edges.add(new Edge(new MyPoint( edges.get(edges.size()-1).location.x-10, edges.get( edges.size() - 1).location.y - 10)));
            State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.rasst();
            edges.add(State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.edges.get( State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.edges.size()-1));
            walls.remove(walls.size()-1);
            walls.add(new Wall(edges.get( edges.size()-2), edges.get( edges.size() - 1)));
            walls.add(new Wall(edges.get( edges.size() - 1), edges.get( 0)));

            dest.add(new MyPoint(0,0));
            touchzone.add(edges.get( edges.size()-1).relativeLocation);
        }
    }
    if (size < edges.size())
    {
        for (int i = edges.size() - 1; i > size - 1; i--)
        {
            edges.remove(i);
            dest.remove(i);
            touchzone.remove(i);
        }
    }
}
}
