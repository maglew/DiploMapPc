package com.pack.diplomap.Interface;

import com.pack.diplomap.MapObjects.Edge;
import com.pack.diplomap.MapObjects.MyPoint;
import com.pack.diplomap.MapObjects.Room;
import com.pack.diplomap.States.State;

import java.awt.*;

public class RedactorInterface
{
    public  static String regime = "move";
    public static int chosedObjId = -1;
    public static int aimObjId = -1;

    public static String typeObj = "Edge";

    public static  int schot=0;
    public static int coun = 0;
    public static boolean opened = false;
    public static boolean dragged = false;

    MyPoint pointOfTouch = new MyPoint(0, 0);

    MyPoint razn = new MyPoint(0, 0);
    Rectangle cursorRect=new Rectangle(pointOfTouch.x,pointOfTouch.y,40,40);

    int A=-1;
    int B=-1;

    public RedactorInterface()
    {

    }

    public void tick()
    {
        aimObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));
     /*   if(MouseManager.left)
        {
            chosedObjId= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));
        }*/
        if(!MouseManager.left)
        {
            chosedObjId=-1;
        }
        switch (regime)
        {
            case "delete":
                if(MouseManager.left)
                    chosedObjId= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));

                typeObj = "";
                if (chosedObjId!=-1)
                {
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.delobj(chosedObjId);
                }
                break;
            case "create":

                if (typeObj == "Edge" && MouseManager.left && schot == 0)
                {
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.addNewEdge(new MyPoint((MouseManager.rellefttouch.x ), (MouseManager.rellefttouch.y )));
                    schot++;
                }
                if (typeObj == "Room" && MouseManager.left && schot == 0)
                {
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.addNewRoom(new MyPoint((MouseManager.rellefttouch.x ), (MouseManager.rellefttouch.y )));
                    schot++;
                }
                if (typeObj == "Wall" && MouseManager.left && schot == 0)
                {
                    if (chosedObjId!=-1&& State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) instanceof Edge)
                    {
                        if (A == -1)
                        { A = chosedObjId;
                            chosedObjId = -1;
                        }
                        else
                        { B = chosedObjId; }
                        if (B != -1 && A != -1&&B!=A)
                        {
                            State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.addNewWall(A,B);
                            schot++;
                            chosedObjId = -1;

                        }
                    }

                }

                if (schot > 0&&!MouseManager.left)
                {
                    A = -1;
                    B = -1;
                    schot = 0;
                    break;
                }


                break;
            case "redact":

                typeObj = "";
                if (MouseManager.left)
                {
                    chosedObjId= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));
                    if (chosedObjId != -1)
                    {

                        if (!opened && State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) instanceof Room)
                        {
                            RoomChangeForm roomChangeForm = new RoomChangeForm(chosedObjId);

                            MouseManager.left = false;

                            break;
                        }
                    }


                }
                if (!MouseManager.left)
                {

                    chosedObjId = -1;

                    opened = false;
                }

                break;
            case "move":
                typeObj = "";
                if (!dragged)
                {
                    chosedObjId= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(MouseManager.getRellefttouch());
                    dragged = true;
                    razn=new MyPoint(0,0);
                    if (chosedObjId != -1)
                    {
                        razn.x = MouseManager.getRellefttouch().x-State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId).location.x;
                        razn.y = MouseManager.getRellefttouch().y-State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId).location.y;
                    }
                }

                if (chosedObjId != -1 && MouseManager.left)
                {
                    //  State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.moveElement(chosedObjId, new MyPoint((MouseManager.relleftGrab.x), (MouseManager.relleftGrab.y)));
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.moveElement(chosedObjId, new MyPoint((MouseManager.getRelmousecoord().x-razn.x), (MouseManager.getRelmousecoord().y-razn.y)));

                }

                if (!MouseManager.left && dragged)
                {
                    dragged = false;
                }

                break;

        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);

        if(State.getCurrentState().drawing) {
            g.drawString(regime, 650, 100);
            g.drawString(typeObj + "", 650, 90);
            g.drawString("relmouse:" + MouseManager.getRelmousecoord().x + "." + MouseManager.getRelmousecoord().y, 650, 120);
            g.drawString("temobjid:" + aimObjId, 650, 110);
            g.drawString("chosedobj:" + chosedObjId + "", 650, 130);

            g.drawString("last room" + (((State.getCurrentState().drawMap.selectedfloor+1)*100)+(State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.rooms.size())-1) + "", 650, 150);
        }
    }
}
