package com.pack.diplomap.Interface;


import com.pack.diplomap.Handler;

import java.awt.*;

public  class MapCamera
{
Handler handler;
    public static int size = 1;
    static Rectangle screenRect;
    static Point  razn = new Point(0, 0);
    boolean moved=false;
    public static Point  worldlocation = new Point(0, 0);
    public static Point  relativeworldlocation = new Point(0, 0);

    public  MapCamera(Handler handler)
    {
        this.handler=handler;
        this.screenRect=new Rectangle(100,100,700,700);
    }

    public  void tick()
    {
        if(MouseManager.right &&moved==false)
        {
            razn.x = (int)MouseManager.righDown.x- relativeworldlocation.x;
            razn.y = (int)MouseManager.righDown.y - relativeworldlocation.y;
        }

        if(MouseManager.righGrabbed.x!=0&&MouseManager.righGrabbed.y!=0)
        {
            relativeworldlocation=new Point((int)MouseManager.righGrabbed .x-razn.x,(int)MouseManager.righGrabbed.y-razn.y);
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
       g.setColor(Color.YELLOW);
       // g.drawRect(screenRect.x,screenRect.y,screenRect.width,screenRect.height);
        g.drawString("worldloc: "+relativeworldlocation.toString(),750,50);
        g.drawString("cursor: "+MouseManager.cursorLoc.toString(),750,65);

        g.drawString("right: "+MouseManager.right,750,80);
        g.drawString("left: "+MouseManager.left,750,95);
        g.drawString("lefttouch: "+MouseManager.leftDown.toString(),750,110);
        g.drawString("righttouch: "+MouseManager.righDown.toString(),750,125);
        g.drawString("leftgrab: "+MouseManager.leftGrabbed.toString(),750,140);
        g.drawString("rightgrab: "+MouseManager.righGrabbed.toString(),750,155);
        g.drawString("rightup: "+MouseManager.righUp.toString(),750,170);
        g.drawString("leftup: "+MouseManager.leftUp.toString(),750,185);
        g.drawString("entered: "+MouseManager.entered,750,200);

    }







    public int getZoom() {
        return size;
    }

    public void setZoom(int zoom) {
        this.size = zoom;
    }

    public Point getWorldloc() {
        return relativeworldlocation;
    }
}
