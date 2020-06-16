package com.pack.diplomap.MapObjects;
import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.States.State;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import static java.lang.Math.round;

public class Room extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1315152604847457796L;
    public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<MyPoint> dest = new ArrayList<>();

    public static int Statnumber=0;
    public  int number=0;
   public RoomInfo roomInfo;

    public Room(Edge A, Edge B, Edge C, Edge D)
    {
        location = new MyPoint((A.location.x+ C.location.x)/2, (A.location.y + C.location.y) / 2);
        this.movable = true;

        this.edges.add(A);
        this.edges.add(B);
        this.edges.add(C);
        this.edges.add(D);

        walls.add(new Wall(A, B));
        walls.add(new Wall(B, C));
        walls.add(new Wall(C, D));
        walls.add(new Wall(D, A));

        touchzone.add(edges.get(0).location);
        touchzone.add(edges.get(1).location);
        touchzone.add(edges.get(2).location);
        touchzone.add(edges.get(3).location);

        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
        Room.Statnumber++;
        number+=Room.Statnumber;
        roomInfo=new RoomInfo((State.getCurrentState().drawMap.selectedfloor+1)*100+State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.rooms.size());
    }

    public Room()
    {
        location = new MyPoint(0, 0);
        location = location;

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

        touchzone.add(edges.get(0).location);
        touchzone.add(edges.get(1).location);
        touchzone.add(edges.get(2).location);
        touchzone.add(edges.get(3).location);
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
        roomInfo=new RoomInfo();
    }

    @Override
    public  void tick()
    {
        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        for (int j = 0; j < edges.size() ; j++)
        {
            edges.get(j).tick();
        }
        for (int j = 0; j < walls.size() ; j++)
        {
            walls.get(j).tick();
        }
        for (int j = 0; j < touchzone.size() ; j++)
        {
            touchzone.set(j,new MyPoint( edges.get(j).location.x,edges.get(j).location.y));
        }
    }

    @Override
    public  void render(Graphics g)
    {
        if(State.getCurrentState().drawing) {


            g.setColor(Color.WHITE);

            g.drawRect(location.x - 5, location.y - 5, 10, 10);
            for (int j = 0; j < edges.size(); j++) {
                edges.get(j).render(g);
            }
            for (int j = 0; j < walls.size(); j++) {
                walls.get(j).render(g);
            }
            //   g.setColor(Color.red);
            g.setColor(new Color(255, 0, 0, 128));
            Polygon poly = new Polygon();
            for (int i = 0; i < touchzone.size(); i++) {
                poly.addPoint(touchzone.get(i).x, touchzone.get(i).y);
            }
            g.fillPolygon(poly);
            g.setColor(Color.blue);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
            g.drawString(roomInfo.getNumber()+"",location.x+5,location.y);

            //  g.drawPolygon(poly);
        }
    }

    @Override
    public  void move(MyPoint coord)
    {
        location = new MyPoint(coord.x, coord.y);
        for (int j = 0; j < edges.size(); j++)
        {
            edges.get(j).move(new MyPoint(coord.x-dest.get(j).x, coord.y-dest.get(j).y ));
        }
    }

    @Override
    public boolean touchhit(Point coord)
    {
        return super.touchhit(coord);
    }


    @Override
    public  void setedgescount(int size)
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
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.clearadd();
                edges.add(State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.edges.get( State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.edges.size()-1));
                walls.remove(walls.size()-1);
                walls.add(new Wall(edges.get( edges.size()-2), edges.get( edges.size() - 1)));
                walls.add(new Wall(edges.get( edges.size() - 1), edges.get( 0)));
                dest.add(new MyPoint(0,0));
                touchzone.add(edges.get( edges.size()-1).location);
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

    @Override
    public void setroom(RoomInfo roomInfo)
    {
        this.roomInfo=roomInfo;
    }

    @Override
    public RoomInfo getRoomInfo()
    {
        return this.roomInfo;
    }
}