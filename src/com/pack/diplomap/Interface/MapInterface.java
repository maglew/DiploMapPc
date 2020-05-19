package com.pack.diplomap.Interface;

import com.pack.diplomap.Handler;
import com.pack.diplomap.MapObjects.*;
import com.pack.diplomap.MapObjects.MyPoint;
import com.pack.diplomap.States.State;

import java.awt.*;

public class MapInterface
{
    public  static String regime = "move";
    public static int chosedObjId = -1;
    public static String typeObj = "Edge";

    public static  int schot=0;
    public static int coun = 0;
    public static boolean opened = false;
    public static boolean dragged = false;

    MyPoint touch = new MyPoint(0, 0);
    MyPoint razn = new MyPoint(0, 0);

    int A=-1;
    int B=-1;

    public MapInterface()
    {
    }

    public void tick()
    {
        switch (regime)
        {
            case "delete":

                if (MouseManager.left)
                {   typeObj = "";

                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.delobj(State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.leftDown.x, (int)MouseManager.leftDown.y)));
                    chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.leftDown.x, (int)MouseManager.leftDown.y));
                    typeObj = "";
                }
                break;
            case "create":
                //razn = new MyPoint(0, 0);

                if (typeObj == "Edge" && MouseManager.left && schot == 0)
                {
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.addNewEdge(new MyPoint((MouseManager.leftDown.x - MapCamera.relativeworldlocation.x), (MouseManager.leftDown.y - MapCamera.relativeworldlocation.y)));
                    schot++;
                }
                if (typeObj == "Room" && MouseManager.left && schot == 0)
                {
                    State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.addNewRoom(new Point((int)(MouseManager.leftDown.x - MapCamera.relativeworldlocation.x), (int)(MouseManager.leftDown.y - MapCamera.relativeworldlocation.y)));
                    schot++;
                }
                if (typeObj == "Wall" && MouseManager.left && schot == 0)
                {

                    chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.leftDown.x, (int)MouseManager.leftDown.y));
                    if (chosedObjId!=-1&& State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId).equals(Edge.class) )
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
                    chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.leftDown.x, (int)MouseManager.leftDown.y));
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
                        chosedObjId = State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.searchObjByCoord(new Point((int)MouseManager.leftDown.x, (int)MouseManager.leftDown.y));
                        dragged = true;
                        razn = new MyPoint(0, 0);
                        if (chosedObjId != -1)
                        {
                            razn.x = MouseManager.leftDown.x - State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId).relativeLocation.x;
                            razn.y = MouseManager.leftDown.y - State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.getElement(chosedObjId).relativeLocation.y;
                        }
                    }

                    if (chosedObjId != -1 && MouseManager.left)
                    {
                        State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.moveElement(chosedObjId, new MyPoint((int)(MouseManager.leftGrabbed.x - razn.x), (int)(MouseManager.leftGrabbed.y - razn.y)));
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
        g.drawString(chosedObjId+"",650,110);
        g.drawString(typeObj+"",650,90);

    }

}
