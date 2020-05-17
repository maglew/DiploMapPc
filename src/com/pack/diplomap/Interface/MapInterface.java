package com.pack.diplomap.Interface;

import com.pack.diplomap.Handler;
import com.pack.diplomap.MapObjects.DevText;

import java.awt.*;

public class MapInterface
{


    int i;
    int t=0;
    int a=-1;
    int b=-1;
  public  String regime="delete";
    String operobj="all";
    String chosedobj="null";


    public MapInterface()
    {

    }


    public void tick()
    {

        regimemanager(regime,operobj);
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);

        g.drawString(regime,650,100);
        g.drawString(operobj,650,110);
        g.drawString(chosedobj,650,120);

    }

    public void regimemanager(String regime,String operobj)
    {
        /*
        switch (regime){
            case ("redact"):

                if(Objects.searchObjByCoord(lefttouch)!=-1)
                {
                  //  d = new JDialog(handler.getDisplay().getFrame(), "dialog Box");
                }
                break;
            case ("delete"):
                Objects.delobj(Objects.searchObjByCoord(lefttouch));
                chosedobj=""+Objects.searchObjByCoord(lefttouch);
                break;
            case ("create"):
                if(Objects.searchObjByCoord(lefttouch)==-1&&handler.getMouseManager().isLeftPressed())
                {
                    if(operobj.equals("point"))
                    {Objects.addNewEdge(new Point(lefttouch.x-worldloc.x, lefttouch.y-worldloc.y));}

                    if(operobj.equals("wall"))
                    {

                        if(Objects.searchObjByCoord(lefttouch)!=-1)
                        {
                            t++;
                            if(t==1)
                            { a=Objects.searchObjByCoord(lefttouch);}

                            if(t==2&&a!=Objects.searchObjByCoord(lefttouch))
                            { b=Objects.searchObjByCoord(lefttouch);}
                            if(t>2)
                                t=0;
                            if(a!=b&&t==2)
                            {  Objects.addNewWall( a, b);
                                t=0;
                            }

                        }


                    }
                }

                break;
        }
        */
    }

}
