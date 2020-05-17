package com.pack.diplomap.Interface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{

    public static boolean entered=false;
    public static boolean left, mid,right , scrlup,scrldown;

    public static Point cursorLoc=new Point(0,0);

    public static Point leftDown=new Point(0,0);
    public static Point righDown=new Point(0,0);

    public static Point leftGrabbed=new Point(0,0);
    public static Point righGrabbed=new Point(0,0);

    public static Point leftUp=new Point(0,0);
    public static Point righUp=new Point(0,0);




    public MouseManager()
    {

    }

    public boolean isLeftPressed()
    {return left;}

    public boolean isRightPressed()
    {return right;}



    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getButton()==1)
        {
            left=true;
            leftDown=new Point(e.getX(),e.getY());
            left=false;
            leftDown=new Point(0,0);

        }
        if(e.getButton()==3)
        {
            right=true;
            righDown=new Point(e.getX(),e.getY());
            right=false;
            righDown=new Point(0,0);
        }

    }



    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            left = true;
        leftDown=new Point(e.getX(),e.getY());
        }
        else if(e.getButton()==MouseEvent.BUTTON3)
        {
            right=true;
            righDown=new Point(e.getX(),e.getY());
        }
        else if(e.getButton()==MouseEvent.BUTTON2)
        mid=true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {   left=false;
            leftDown=new Point(0,0);
            leftGrabbed=new Point(0,0);
            leftUp=new Point(e.getX(),e.getY());

        }
        else if(e.getButton()==MouseEvent.BUTTON3)
        {  right=false;
            righDown=new Point(0,0);
            righGrabbed=new Point(0,0);
            righUp=new Point(e.getX(),e.getY());
        }
        else if(e.getButton()==MouseEvent.BUTTON2)
            mid=false;


    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

        entered=true;
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        entered=false;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(left)
        {
            leftGrabbed.x=e.getX();
            leftGrabbed.y=e.getY();

        }
        else if(right)
        {   righGrabbed.x=e.getX();
            righGrabbed.y=e.getY();
        }


    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        cursorLoc=new Point(e.getX(),e.getY());
    }



    public Point getLeftGrabbed() {
        return leftGrabbed;
    }

    public Point getRighGrabbed() {
        return righGrabbed;
    }

    public Point getLeftTouchCoord() {
        return leftDown;
    }

    public Point getRighTouchCoord() {
        return righDown;
    }

    public Point getCursorLoc() {
        return cursorLoc;
    }


}
