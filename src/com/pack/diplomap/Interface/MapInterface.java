package com.pack.diplomap.Interface;

import com.pack.diplomap.MapObjects.MyPoint;
import com.pack.diplomap.MapObjects.Room;
import com.pack.diplomap.States.State;

import java.awt.*;



public class MapInterface
{
    public static boolean opened = false;
    public static int chosedObjId = -1;
    public static int aimObjId = -1;
    public static int floor =  0;
    public  static String regime = "dev";
    MyPoint pointOfTouch = new MyPoint(0, 0);

    MyPoint razn = new MyPoint(0, 0);
    Rectangle cursorRect=new Rectangle(pointOfTouch.x,pointOfTouch.y,40,40);



    public MapInterface()
    {

    }

    public void tick()
    {
        aimObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));

        if(!MouseManager.left)
        {
            chosedObjId=-1;
            opened = false;
        }

        if (MouseManager.left)
        {
            chosedObjId= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));
            if (chosedObjId != -1)
            {

                if (!opened && State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) instanceof Room)
                {
                    RoomInfoForm roomInfoForm = new RoomInfoForm(chosedObjId);

                    MouseManager.left = false;


                }
            }


        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        if(State.getCurrentState().drawing) {
            g.drawString(regime, 650, 100);
            g.drawString("relmouse:" + MouseManager.getRelmousecoord().x + "." + MouseManager.getRelmousecoord().y, 650, 120);
            g.drawString("temobjid:" + aimObjId, 650, 110);
            g.drawString("chosedobj:" + chosedObjId + "", 650, 130);
            g.drawString("floor:" + floor + "", 650, 130);
        }
    }

}
