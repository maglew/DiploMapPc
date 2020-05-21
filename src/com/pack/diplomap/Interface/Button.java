package com.pack.diplomap.Interface;

import com.pack.diplomap.Handler;

import java.awt.*;

public class Button
{
    String text;
    float length;
    boolean ispressed;
    boolean iscursed;
    Rectangle borders;

    public Button(String text, Rectangle borders) {
        this.text = text;
        this.borders = borders;
        this.ispressed=false;
        this.ispressed=false;
    }


    public void tick(Handler handler)
    {
   /*     this.ispressed=false;
        this.iscursed=false;
        if(handler.getMouseManager().left&&handler.getMouseManager().getCursorLoc().x>=borders.x&&handler.getMouseManager().getCursorLoc().x<=borders.x+borders.width
                &&handler.getMouseManager().getCursorLoc().y>=borders.y&&handler.getMouseManager().getCursorLoc().y<=borders.y+borders.height)
        {this.ispressed=true;}
        if(handler.getMouseManager().getCursorLoc().x>=borders.x&&handler.getMouseManager().getCursorLoc().x<=borders.x+borders.width
                &&handler.getMouseManager().getCursorLoc().y>=borders.y&&handler.getMouseManager().getCursorLoc().y<=borders.y+borders.height)
        {this.iscursed=true;}
*/
    }

    public void render(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        Font buttonfnt=new Font("arial",Font.BOLD,15);
        g.setColor(Color.gray);
        g2d.fill(borders);
        if(iscursed)
        {
            g.setColor(Color.lightGray);
            g2d.fill(borders);
        }
        if(isIspressed())
        {
            g.setColor(Color.red);
            g2d.fill(borders);
        }
        g.setColor(Color.white);
        g2d.draw(borders);
        g.setColor(Color.yellow);
        g.setFont(buttonfnt);
        g.drawString(text,borders.x+borders.width/2-text.length(),borders.y+borders.height/2);

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        text = text;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isIspressed() {
        return ispressed;
    }

    public void setIspressed(boolean ispressed) {
        this.ispressed = ispressed;
    }

    public Rectangle getBorders() {
        return borders;
    }

    public void setBorders(Rectangle borders) {
        this.borders = borders;
    }
}
