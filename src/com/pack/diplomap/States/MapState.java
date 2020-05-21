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
    JButton zeroButt;
    JButton saveButt;
    JButton loadButt;
    JComboBox comboBox1;
    JComboBox comboBox2;

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
        zeroButt= new JButton("zero");
        saveButt= new JButton("save map");
        loadButt= new JButton("load map");
        String[] items = {
                "Room",
                "Edge",
                "Wall"
        };
        String[] items2 = {
                "1",
                "2",
                "3"
        };

         comboBox1 = new JComboBox(items);
        comboBox2 = new JComboBox(items2);

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
        this.add(zeroButt);
        this.add(saveButt);
        this.add(loadButt);
        this.add(comboBox1);
        comboBox1.setEditable(true);
        this.add(comboBox2);
        comboBox2.setEditable(true);
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
        drawMap.tick(new MyPoint(mapCamera.getWorldloc()),mapCamera.getSize());
        mapInterface.tick();
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

        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JComboBox box1 = (JComboBox)event.getSource();
                String item = (String)box1.getSelectedItem();
                State.getCurrentState().drawMap.selectedfloor=Integer.parseInt(item)-1;
                mapInterface.typeObj=item;
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JComboBox box = (JComboBox)event.getSource();
                String item = (String)box.getSelectedItem();
                mapInterface.typeObj=item;
            }
        });

        zeroButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                MapCamera.worldlocation=new Point(0,0);
            }
        });
        saveButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               State.getCurrentState().drawMap.save();
            }
        });
        loadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                State.getCurrentState().drawMap.load();
            }
        });
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
              //  State.getCurrentState().canvas.
                if(MapCamera.size>1)
                    MapCamera.size-=1;

            }
        });

        zoomOutButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                if(MapCamera.size<15)
                    MapCamera.size+=1;
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
