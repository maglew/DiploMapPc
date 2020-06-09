package com.pack.diplomap.Interface;

import com.pack.diplomap.States.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.round;

public class MouseManager implements MouseListener, MouseMotionListener
{

    static public boolean left =false;
    static public boolean right = false;
    static public boolean enter =false;

    static public Point entercoord = new Point(0, 0);
    static public Point mousecoord = new Point(0, 0);
    static public Point rightGrab = new Point(0, 0);
    static public Point leftGrab = new Point(0, 0);
    static public Point righttouch = new Point(0, 0);
    static public Point lefttouch = new Point(0, 0);
    static public Point rightup = new Point(0, 0);
    static public Point leftup = new Point(0, 0);

    static public Point relmousecoord = new Point(0, 0);
    static public Point relrightGrab = new Point(0, 0);
    static public Point relleftGrab = new Point(0, 0);
    static public Point relrighttouch = new Point(0, 0);
    static public Point rellefttouch = new Point(0, 0);
    static public Point relrightup = new Point(0, 0);
    static public Point relleftup = new Point(0, 0);


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
     //   if(e.getButton()==1)
     //   {
        //    left=true;
        //    lefttouch=new Point(e.getX(),e.getY());
          //  left=false;
         //   lefttouch=new Point(0,0);

     //   }
     //   if(e.getButton()==3)
     //   {
         //   right=true;
         //   righttouch=new Point(e.getX(),e.getY());
          //  right=false;
         //   righttouch=new Point(0,0);
       // }

    }



    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            left = true;
            lefttouch = new Point(e.getX(), e.getY());
            rellefttouch =new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));

        }
        else if(e.getButton()==MouseEvent.BUTTON3)
        {
            right = true;
            righttouch = new Point(e.getX(), e.getY());
            relrighttouch =new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));

        }
        //else if(e.getButton()==MouseEvent.BUTTON2)
        //mid=true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {    left = false;
            lefttouch = new Point(0, 0);
            leftup = new Point(e.getX(), e.getY());
            rellefttouch= new Point(0, 0);
            relleftup =new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));
        }
         if(e.getButton()==MouseEvent.BUTTON3)
        {  right = false;
            righttouch = new Point(0, 0);
            rightup=new Point(e.getX(),e.getY());
            relrighttouch= new Point(0, 0);
            relrightup =new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));
        }
       // else if(e.getButton()==MouseEvent.BUTTON2)
        //    mid=false;
        if (!left)
        {
            leftGrab = new Point(0, 0);
            relleftGrab=new Point(0, 0);
        }
        if (!right)
        {

            rightGrab = new Point(0, 0);
            relleftGrab=new Point(0, 0);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

        enter=true;
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        enter=false;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mousecoord=new Point(e.getX(),e.getY());
        relmousecoord=new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));
        if(left)
        {
            leftGrab = mousecoord;
            relleftGrab=relmousecoord;
        }
        if (right)
        {
            rightGrab = mousecoord;
            relrightGrab=relmousecoord;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mousecoord=new Point(e.getX(),e.getY());
        relmousecoord=new Point(round((e.getX()- State.getCurrentState().mapCamera.getWorldloc().x)/(State.getCurrentState().mapCamera.getSize())), round((e.getY()-State.getCurrentState().mapCamera.getWorldloc().y)/(State.getCurrentState().mapCamera.getSize())));

    }


    public static boolean isLeft() {
        return left;
    }

    public static boolean isRight() {
        return right;
    }

    public static boolean isEnter() {
        return enter;
    }

    public static Point getEntercoord() {
        return entercoord;
    }

    public static Point getMousecoord() {
        return mousecoord;
    }

    public static Point getRightGrab() {
        return rightGrab;
    }

    public static Point getLeftGrab() {
        return leftGrab;
    }

    public static Point getRighttouch() {
        return righttouch;
    }

    public static Point getLefttouch() {
        return lefttouch;
    }

    public static Point getRightup() {
        return rightup;
    }

    public static Point getLeftup() {
        return leftup;
    }


    public static Point getRelmousecoord() {
        return relmousecoord;
    }

    public static Point getRelrightGrab() {
        return relrightGrab;
    }

    public static Point getRelleftGrab() {
        return relleftGrab;
    }

    public static Point getRelrighttouch() {
        return relrighttouch;
    }

    public static Point getRellefttouch() {
        return rellefttouch;
    }

    public static Point getRelrightup() {
        return relrightup;
    }

    public static Point getRelleftup() {
        return relleftup;
    }
}
