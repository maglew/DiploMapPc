package com.pack.diplomap.Interface;


import com.pack.diplomap.Handler;

import java.awt.*;

public  class MapCamera
{
Handler handler;
    public static int size = 15;
    static Rectangle screenRect;
    static Point  razn = new Point(0, 0);
    boolean moved=false;
    public static Point  worldlocation = new Point(0, 0);
    public static Point  relativeworldlocation = new Point(0, 0);
    public static Point  cursor = new Point(0, 0);

    public  MapCamera(Handler handler)
    {
        this.handler=handler;
        this.screenRect=new Rectangle(100,100,700,700);
    }

    public  void tick()
    {
        cursor=MouseManager.getMousecoord();
        if(MouseManager.right &&moved==false)
        {
            razn.x = (int)MouseManager.righttouch.x- relativeworldlocation.x;
            razn.y = (int)MouseManager.righttouch.y - relativeworldlocation.y;
        }

        if(MouseManager.rightGrab.x!=0&&MouseManager.rightGrab.y!=0)
        {
            relativeworldlocation=new Point((int)MouseManager.rightGrab .x-razn.x,(int)MouseManager.rightGrab.y-razn.y);
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

        g.drawString("worldloc: "+relativeworldlocation.toString(),750,50);
        g.drawString("cursor: "+MouseManager.mousecoord.toString(),750,65);

        g.drawString("right: "+MouseManager.right,750,80);
        g.drawString("left: "+MouseManager.left,750,95);
        g.drawString("lefttouch: "+MouseManager.lefttouch.toString(),750,110);
        g.drawString("righttouch: "+MouseManager.righttouch.toString(),750,125);
        g.drawString("leftgrab: "+MouseManager.leftGrab.toString(),750,140);
        g.drawString("rightgrab: "+MouseManager.rightGrab.toString(),750,155);
        g.drawString("rightup: "+MouseManager.rightup.toString(),750,170);
        g.drawString("leftup: "+MouseManager.leftup.toString(),750,185);
        g.drawString("entered: "+MouseManager.enter,750,200);

        g.drawRect(cursor.x-2,cursor.y-2,4,4);
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getWorldloc() {
        return relativeworldlocation;
    }
}
