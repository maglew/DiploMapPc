package com.pack.diplomap.Interface;


import com.pack.diplomap.Handler;
import com.pack.diplomap.States.State;

import java.awt.*;

public  class MapCamera
{
    Handler handler;
    public static float size = 0.5f;
    public  Point  relativeworldlocation = new Point(0, 0);
    public static double rotate=0;
    static Rectangle screenRect;
    static Point  razn = new Point(0, 0);
    boolean moved=false;
    public static int canvasW=0 ;
    public static int canvasH=0;
    public  Point  worldlocation = new Point(0, 0);

    public static Point  cursor = new Point(0, 0);

    public  MapCamera(Handler handler)
    {
        this.handler=handler;

    }

    public  void tick()
    {
        canvasW= State.getCurrentState().canvas.getWidth() ;
        canvasH=State.getCurrentState().canvas.getHeight();
      //  screenRect=new Rectangle(50,50,canvasW-100,canvasH-100);

        cursor= MouseManager.getMousecoord();
        if(MouseManager.right &&moved==false)
        {
            razn.x = (int) MouseManager.righttouch.x- relativeworldlocation.x;
            razn.y = (int) MouseManager.righttouch.y - relativeworldlocation.y;
        }

        if(MouseManager.rightGrab.x!=0&& MouseManager.rightGrab.y!=0)
        {
            relativeworldlocation=new Point((int) MouseManager.rightGrab .x-razn.x,(int) MouseManager.rightGrab.y-razn.y);
            moved=true;
        }
        else
        {
            moved=false;
            razn = new Point(0, 0);
        }

    }

    public  void render(Graphics g)
    {
        g.setColor(Color.yellow);

        g.drawString("size: "+size,750,20);
        g.drawString("worldloc: "+relativeworldlocation.x+"."+relativeworldlocation.y,750,50);
        g.drawString("mousecoord: "+ MouseManager.mousecoord.x+"."+MouseManager.mousecoord.y,750,65);

        if(State.getCurrentState().drawing) {
            g.drawString("right: " + MouseManager.right, 750, 80);
            g.drawString("left: " + MouseManager.left, 750, 95);
            g.drawString("lefttouch: " + MouseManager.lefttouch.x + "." + MouseManager.lefttouch.y, 750, 110);
            g.drawString("righttouch: " + MouseManager.righttouch.x + "." + MouseManager.righttouch.y, 750, 125);
            g.drawString("leftgrab: " + MouseManager.leftGrab.x + "." + MouseManager.leftGrab.y, 750, 140);
            g.drawString("rightgrab: " + MouseManager.rightGrab.x + "." + MouseManager.rightGrab.y, 750, 155);
            g.drawString("rightup: " + MouseManager.rightup.x + "." + MouseManager.rightup.y, 750, 170);
            g.drawString("leftup: " + MouseManager.leftup.x + "." + MouseManager.leftup.y, 750, 185);
            g.drawString("entered: " + MouseManager.enter, 750, 200);
            g.setColor(Color.green);
            g.drawString("relmousecoord: " + MouseManager.relmousecoord.x + "." + MouseManager.relmousecoord.y, 750, 215);
            g.drawString("lefttouch: " + MouseManager.rellefttouch.x + "." + MouseManager.rellefttouch.y, 750, 225);
            g.drawString("righttouch: " + MouseManager.relrighttouch.x + "." + MouseManager.relrighttouch.y, 750, 240);
            g.drawString("leftgrab: " + MouseManager.relleftGrab.x + "." + MouseManager.relleftGrab.y, 750, 255);
            g.drawString("rightgrab: " + MouseManager.relrightGrab.x + "." + MouseManager.relrightGrab.y, 750, 270);
            g.drawString("rightup: " + MouseManager.relrightup.x + "." + MouseManager.relrightup.y, 750, 285);
            g.drawString("leftup: " + MouseManager.relleftup.x + "." + MouseManager.relleftup.y, 750, 300);

        }
        g.drawRect(cursor.x - 2, cursor.y - 2, 4, 4);
    }



    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getWorldloc() {
        return relativeworldlocation;
    }

    public  double getRotate() {
        return rotate;
    }

    public  void setRotate(double rotate) {
        MapCamera.rotate = rotate;
    }
}
