package com.pack.diplomap.MapObjects;

import com.pack.diplomap.States.State;
import com.pack.diplomap.gfx.Assets;

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
        for (int i = 0; i < 4; i++)
        { floors.add(new DrawMapFloor()); }
    }
    public void tick()
    {
        floors.get(selectedfloor).tick();
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
            if (!myfile.exists())
            {
                State.getCurrentState().log.addtolog("no file");
            }
            FileInputStream fis = new FileInputStream(myfile);
            DataInputStream dis=new DataInputStream(fis);
            ObjectInputStream is = new ObjectInputStream(dis);
            newmap=(DrawMap)is.readObject();
            is.close();
            fis.close();
            newmap.addfloors();
            selectedfloor=0;
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
            os.close();
            fos.close();
        } catch (Throwable t)
        {
            State.getCurrentState().log.addtolog(t.toString());
        }

    }

    public  void addfloors()
    {

        floors.get(0).drawObjects.image= new MapImage(Assets.firstFloor,new MyPoint(0,0) );
        floors.get(1).drawObjects.image= new MapImage(Assets.secondFloor,new MyPoint(0,0) );
        floors.get(2).drawObjects.image= new MapImage(Assets.thirdFloor,new MyPoint(0,0) );
        floors.get(3).drawObjects.image= new MapImage(Assets.forthFloor,new MyPoint(0,0) );

        floors.get(0).drawObjects.clearadd();
        floors.get(1).drawObjects.clearadd();
        floors.get(2).drawObjects.clearadd();
        floors.get(3).drawObjects.clearadd();
    }

    public  void clean()
    {
        State.getCurrentState().drawMap=new DrawMap();
    }

}

