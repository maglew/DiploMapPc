package com.pack.diplomap.MapObjects;

import java.awt.*;
import java.io.Serializable;

public class MyPoint implements Serializable
{
    private static final long serialVersionUID = -1215152604847457796L;
   public int x;
    public int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(Point coord) {
        this.x = coord.x;
        this.y = coord.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public void set(Point coord)
    {
        this.x=coord.x;
        this.y=coord.y;
    }
}
