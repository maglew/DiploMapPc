package com.pack.diplomap.MapObjects;



import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Room extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1315152604847457796L;
    public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();
        public ArrayList<MyPoint> dest = new ArrayList<>();


    public Room(Edge A, Edge B, Edge C, Edge D)
    {
        location = new MyPoint((A.location.x+ C.location.x)/2, (A.location.y + C.location.y) / 2);
        relativeLocation = location;

        this.movable = true;
      //  this.id = Guid.NewGuid();

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
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);*/

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
        touchzone.add(edges.get(0).relativeLocation);
        touchzone.add(edges.get(0).relativeLocation);
        touchzone.add(edges.get(0).relativeLocation);
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);*/

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


    relativeLocation = new MyPoint(wordloc.x + location.x, wordloc.y + location.y);

    for (int i = 0; i < dest.size(); i++)
    {
        dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
    }

    for (int j = 0; j < edges.size() ; j++)
    {
        //edges.get(j).location= new MyPoint(center.x + dest.get(j).x, center.y + dest.get(j).y);
        //edges.get(j).relativeLocation = new MyPoint(wordloc.x + edges.get(j).location.x,  wordloc.y + edges.get(j).location.y);
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

}

@Override
    public  void render(Graphics g)
{
    /*
    Pen pen = new Pen(Color.Red, 1);
    g.DrawRectangle(pen,new Rectangle(relativeLocation.x-5, relativeLocation.y - 5, 10, 10));
    for (int j = 0; j < edges.size() ; j++)
    {
        edges.get(j).render(g);

    }
    for (int j = 0; j < walls.size() ; j++)
    {
        walls.get(j).render(g);

    }
*/

}

/*
    public override void move(Point coord)
{
    relativeLocation = coord;
    location = new MyPoint(relativeLocation.x - MapCamera.getWorldLoc().x, relativeLocation.y - MapCamera.getWorldLoc().y);

    for (int j = 0; j < edges.size(); j++)
    {
        edges.get(j).move(new MyPoint(coord.x-dest.get(j).x, coord.y - dest.get(j).y));
    }
}

*/
/*
    public  bool touchhit(Point coord)
{
    return base.touchhit(coord);
}
*/
/*
    public  void setedgessize()(int size())
{
    if (size() == edges.size())
    { return; }
    if (size() > edges.size())
    {
        for (int i = 0; i < size() - edges.size(); i++)
        {
            MapPanel.map.floors[DrawMap.selectedfloor].drawObjects.elements.add(new com.com.pack.diplommapandr.Edge(new MyPoint(edges[edges.size() - 1].location.x - 15, edges[edges.size() - 1].location.y - 15)));

            MapPanel.map.floors[DrawMap.selectedfloor].drawObjects.edges.add(new com.com.pack.diplommapandr.Edge(new MyPoint(edges[edges.size()-1].location.x-10, edges[edges.size() - 1].location.y - 10)));
            MapPanel.map.floors[DrawMap.selectedfloor].drawObjects.rasst();
            edges.add(MapPanel.map.floors[DrawMap.selectedfloor].drawObjects.edges[MapPanel.map.floors[DrawMap.selectedfloor].drawObjects.edges.size()-1]);
            walls.RemoveAt(walls.size()-1);
            walls.add(new Wall(edges[edges.size()-2], edges[edges.size() - 1]));
            walls.add(new Wall(edges[edges.size() - 1], edges[0]));

            dest.add(new MyPoint(0,0));
            touchzone.add(edges[edges.size()-1].relativeLocation);
            bordType.add(1);


        }
    }
    if (size() < edges.size())
    {
        for (int i = edges.size() - 1; i > size() - 1; i--)
        {
            edges.RemoveAt(i);
            dest.RemoveAt(i);
            touchzone.RemoveAt(i);
            bordType.RemoveAt(i);

        }
    }
}*/
}
