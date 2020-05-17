package com.pack.diplomap.States;



import com.pack.diplomap.Handler;
import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.Interface.MapInterface;
import com.pack.diplomap.Interface.MouseManager;
import com.pack.diplomap.Main;
import com.pack.diplomap.MainThread;
import com.pack.diplomap.MapObjects.DrawMap;
import com.pack.diplomap.MapObjects.MyPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapState extends State
{
    int i=0;
MapInterface mapInterface;
    JButton exitButt;

    JButton redButt;
    JButton delButt;
    JButton createButt;
    JButton moveButt;
    JButton zoomInButt;
    JButton zoomOutButt;

    public MapState(Handler handler)
    {

        drawMap=new DrawMap();
        mapCamera=new MapCamera(handler);

        exitButt= new JButton("exit");
        redButt= new JButton("redact");
        delButt= new JButton("delete");
        createButt= new JButton("create");
        moveButt= new JButton("move");
        zoomInButt= new JButton("zoom IN");
        zoomOutButt= new JButton("zoom OUT");

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(1000, 900));
        canvas.setMaximumSize(new Dimension(1000, 900));
        canvas.setMinimumSize(new Dimension(1000, 900));
        canvas.setFocusable(false);

        this.add(exitButt);
        this.add(redButt);
        this.add(delButt);
        this.add(createButt);
        this.add(moveButt);
        this.add(zoomInButt);
        this.add(zoomOutButt);

        this.add(canvas);

    }
    @Override
    void init()
    {
mapInterface=new MapInterface();
        canvas.addMouseListener(mouseManager);
        canvas.addMouseMotionListener(mouseManager);

        thread=new MainThread();

        drawMap.add();
        thread.start();

    buttlistadd();
    }


    @Override
    public void tick()
    {
        mapCamera.tick();
        drawMap.tick(new MyPoint(mapCamera.getWorldloc()),mapCamera.getZoom());
    }

    @Override
    public void render(Graphics g)
    {
        mapCamera.render(g);
       drawMap.render(g);
       mapInterface.render(g);
    }

    void buttlistadd()
    {
     /*   this.add(redButt);
        this.add(delButt);
        this.add(createButt);
        this.add(moveButt);
        this.add(zoomInButt);
        this.add(zoomOutButt);
      */
        redButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               mapInterface.regime="redact";
            }
        });

        delButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapInterface.regime="delete";
            }
        });

        createButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapInterface.regime="create";
            }
        });

        moveButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapInterface.regime="move";
            }
        });

        zoomInButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapInterface.regime="zoomIn";
            }
        });

        zoomOutButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapInterface.regime="zoomOut";
            }
        });

        exitButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "menu");
                State.setCurrentState(Main.window.menuState);
            }
        });

    }


}
