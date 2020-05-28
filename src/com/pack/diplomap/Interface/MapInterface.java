package com.pack.diplomap.Interface;

import com.pack.diplomap.Handler;
import com.pack.diplomap.MapObjects.*;
import com.pack.diplomap.MapObjects.MyPoint;
import com.pack.diplomap.States.State;

import java.awt.*;

import static java.lang.Math.round;

public class MapInterface
{
    public  static String regime = "move";
    public static int chosedObjId = -1;
    public static int tempchosedObjId = -1;
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

    public MapInterface()
    {
    }

    public void tick()
    {
          chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((MouseManager.getRelmousecoord().x), MouseManager.getRelmousecoord().y));

        switch (regime)
        {
            case "delete":
                typeObj = "";
                if (MouseManager.left)
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
                    if (chosedObjId!=-1&& State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) instanceof Edge )
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
            case "change":
/*
                typeObj = "";
                if (MouseManager.left)
                {
                    chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.lefttouch.x, (int)MouseManager.lefttouch.y));
                    if (chosedObjId != -1)
                    {

                        if (!opened && State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) is Edge)
                        {
                            objRedForm = new EdgeChangeForm(chosedObjId);
                            objRedForm.ShowDialog();
                            MouseManager.left = false;

                            break;
                        }

                        if (!opened && State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) is MapZone)
                        {
                            ZoneChangeForm roomChangeForm = new ZoneChangeForm(chosedObjId);
                            roomChangeForm.ShowDialog();
                            MouseManager.left = false;

                            break;
                        }
                        if (!opened && State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId) is Room)
                        {
                            RoomChangeForm roomChangeForm = new RoomChangeForm(chosedObjId);
                            roomChangeForm.ShowDialog();
                            MouseManager.left = false;

                            break;
                        }
                    }


                }
                if (MouseManager.left==false)
                {
                    // MouseManager.leftGrab = new Point(0, 0);
                    // MouseManager.left = false;
                    chosedObjId = -1;
                    //   MouseManager.lefttouch = new Point(0, 0);
                    opened = false;
                }
*/
                break;
            case "move":

                typeObj = "";

                if (MouseManager.left)
                {
                    if (!dragged)
                    {
                        dragged = true;

                    }

                    if (chosedObjId != -1 && MouseManager.left&&MouseManager.relleftGrab.x!=0&&MouseManager.relleftGrab.y!=0)
                    {
                        State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.moveElement(chosedObjId, new MyPoint((MouseManager.relleftGrab.x), (MouseManager.relleftGrab.y)));
                    }
                }
                if (!MouseManager.left && dragged)
                {
                    chosedObjId = -1;
                    dragged = false; }
                break;

        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.drawString(regime,650,100);
        g.drawString(typeObj+"",650,90);
        g.drawString("relmouse:"+MouseManager.getRelmousecoord().x+"."+MouseManager.getRelmousecoord().y,650,120);
        g.drawString("temobjid:"+tempchosedObjId,650,110);
        g.drawString("chosedobj:"+chosedObjId+"",650,130);
    }

}
