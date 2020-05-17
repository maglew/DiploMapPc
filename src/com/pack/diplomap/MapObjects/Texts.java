package com.pack.diplomap.MapObjects;

import java.awt.*;

public class Texts
{
    int width=20;
    String name="";
    MyPoint coord=new MyPoint(0,0) ;

    int id=0;

    public Texts(String name, MyPoint coord,int id)
    {
        this.name=name;
        this.coord=coord;
        this.id=id;
    }

    public void tick( MyPoint coord)
    {

        this.coord=coord;
        // grabbed=new MyPoint(0,0);
        //     this.coord.x=handler.getMouseManager().getMouseX();
//      this.coord.y=handler.getMouseManager().getMouseY();

//this.grabbed=handler.getMouseManager().getMoved();

    }

    public void render(Graphics g)
    {
     //   g.setColor(Color.red);
      //  g.drawString(this.name+" X.Y: "+coord.x+" . "+coord.y, 750, this.id*width+width);
    }

}
