package com.pack.diplomap.MapObjects;

import com.pack.diplomap.States.State;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class DrawMap implements Serializable
{


    private static final long serialVersionUID = -6515152604847457796L;
    public  int selectedfloor = 0;
    public ArrayList<DrawMapFloor> floors = new ArrayList<>();


    public DrawMap()
    {
        for (int i = 0; i < 3; i++)
        { floors.add(new DrawMapFloor()); }

    }

    public void tick(MyPoint wordloc, int size)
    {
        floors.get(selectedfloor).tick(wordloc, size);
    }

    public void render(Graphics g)
    {

        floors.get(selectedfloor).render(g);
    }



    public void load()
    {

        DrawMap newmap=new DrawMap();
        try {
            File myfile = new File("C://Users//whins//Desktop" , "DiplomapPc.dat");
            if (!myfile.exists()) {
                State.getCurrentState().log.addtolog("no file");
            }
            //FileInputStream fis = new FileInputStream(myfile);
           // ObjectInputStream is = new ObjectInputStream(fis);

            FileInputStream fis = new FileInputStream(myfile);
            DataInputStream dis=new DataInputStream(fis);
            ObjectInputStream is = new ObjectInputStream(dis);

               newmap=(DrawMap)is.readObject();

            is.close();
            fis.close();

                State.getCurrentState().drawMap=newmap;

        }
        catch (Throwable t)
        {
            State.getCurrentState().log.addtolog(t.toString());
        }


    }



    public void save()
    {

        try {

            File myfile = new File("C://Users//whins//Desktop" , "DiplomapPc.dat");
            
            if (myfile.exists ())
                myfile.delete ();

            FileOutputStream fos = new FileOutputStream(myfile);
            ObjectOutputStream os = new ObjectOutputStream(fos);

            os.writeObject(State.getCurrentState().drawMap);
           // os.writeObject(TestState1.drawmap.floors);

            os.close();
            fos.close();


        } catch (Throwable t) {
            State.getCurrentState().log.addtolog(t.toString());
        }

    }



    public  void add()
    {

        floors.get(0).drawObjects.grids.add(new Grid(10, 10, 50));

        floors.get(0).drawObjects.edges.add(new Edge(new MyPoint(100, 100)));
        floors.get(0).drawObjects.edges.add(new Edge(new MyPoint(200, 100)));
        floors.get(0).drawObjects.edges.add(new Edge(new MyPoint(200, 200)));
        floors.get(0).drawObjects.edges.add(new Edge(new MyPoint(100, 200)));



        floors.get(1).drawObjects.grids.add(new Grid(10, 10, 50));



        floors.get(2).drawObjects.grids.add(new Grid(10, 10, 50));

/*
        floors.get(1).drawObjects.edges.add(new Edge(new MyPoint(300, 100)));
        floors.get(1).drawObjects.edges.add(new Edge(new MyPoint(400, 100)));
        floors.get(1).drawObjects.edges.add(new Edge(new MyPoint(400, 200)));
        floors.get(1).drawObjects.edges.add(new Edge(new MyPoint(300, 200)));

*/
        floors.get(0).drawObjects.rooms.add(new Room(floors.get(0).drawObjects.edges.get(0), floors.get(0).drawObjects.edges.get(1),
        floors.get(0).drawObjects.edges.get(2), floors.get(0).drawObjects.edges.get(3)));




        floors.get(0).drawObjects.rasst();
        floors.get(1).drawObjects.rasst();
        floors.get(2).drawObjects.rasst();
    }

    public  void clean()
    {
        State.getCurrentState().drawMap=new DrawMap();
    }

}
