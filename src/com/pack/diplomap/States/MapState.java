package com.pack.diplomap.States;

import com.pack.diplomap.Handler;
import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.Interface.MapInterface;
import com.pack.diplomap.Main;
import com.pack.diplomap.MainThread;
import com.pack.diplomap.MapObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MapState extends State
{
    int i=0;
    MapInterface mapInterface;
    JButton exitButt;

    JButton zoomInButt;
    JButton zoomOutButt;
    JButton zeroButt;
    JComboBox comboBox2;
    JTextField textField;
    JButton findButt;
    public MapState(Handler handler)
    {
        drawMap=new DrawMap();
        mapCamera=new MapCamera(handler);

        exitButt= new JButton("exit");

        zoomInButt= new JButton("zoom IN");
        zoomOutButt= new JButton("zoom OUT");
        zeroButt= new JButton("zero");
        textField=new JTextField(3);
        findButt= new JButton("find");
        String[] items = {
                "Room",
                "Edge",
                "Wall"
        };
        String[] items2 = {
                "1",
                "2",
                "3",
                "4"
        };

        comboBox2 = new JComboBox(items2);
        canvas=new Canvas();
        canvas.setBounds(0,0,1000,900);
        canvas.setSize(new Dimension(1000, 900));
        canvas.setFocusable(false);

        this.add(exitButt);

        this.add(zoomInButt);
        this.add(zoomOutButt);
        this.add(zeroButt);
        this.add(comboBox2);
        comboBox2.setEditable(true);
        this.add(textField);
        this.add(findButt);
        this.add(canvas);

    }
    @Override
    void init()
    {

        mapInterface=new MapInterface();
        canvas.addMouseListener(mouseManager);
        canvas.addMouseMotionListener(mouseManager);

        thread=new MainThread();

       // drawMap.add();
        drawMap.load();
        thread.start();

        buttlistadd();
    }


    @Override
    public void tick()
    {
        mapCamera.tick();

        mapInterface.tick();
        drawMap.tick();
    }

    @Override
    public void render(Graphics g)
    {
        mapInterface.render(g);
        mapCamera.render(g);

        g2d= (Graphics2D) g;

        g2d.translate(mapCamera.getWorldloc().x,mapCamera.getWorldloc().y);
        g2d.scale(mapCamera.getSize(),mapCamera.getSize());
        drawMap.render(g);

        g2d.dispose();
    }

    void buttlistadd()
    {

        findButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)
            {
                int num=Integer.parseInt(textField.getText());
                int floornum=0;

                for(DrawMapFloor floor:State.getCurrentState().drawMap.floors)
                {
                    for(Room room : floor.drawObjects.rooms)
                    {
                        if(room.roomInfo.getNumber() ==num)
                        {
                            State.getCurrentState().drawMap.selectedfloor=floornum;
                         //   State.getCurrentState().mapCamera.relativeworldlocation.setLocation( new Point(room.location.x,room.location.y));
                            State.getCurrentState().drawMap.floors.get(floornum).drawObjects.addPointer(new MyPoint(room.location.x,room.location.y));

                            //State.getCurrentState().drawMap.floors.get(floornum).drawObjects.clearadd();
                                   // location=(new MyPoint(room.location.x,room.location.y));
                        }
                    }

                    floornum++;
                }
/*
                for(Room room : State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.rooms)
                {
                    if(room.roomInfo.getNumber() ==num)
                    {
                        State.getCurrentState().mapCamera.relativeworldlocation.setLocation( new Point(room.location.x,room.location.y));

                    }
                }
                */
            }
        });


        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JComboBox box1 = (JComboBox)event.getSource();
                String item = (String)box1.getSelectedItem();
                State.getCurrentState().drawMap.selectedfloor=Integer.parseInt(item)-1;
                mapInterface.floor=Integer.parseInt(item)-1;
            }
        });

        zeroButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)
            {
               State.getCurrentState().mapCamera.relativeworldlocation.setLocation(new Point(0,0));
            }
        });


        zoomInButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //  State.getCurrentState().canvas.
                if(MapCamera.size<15)
                    MapCamera.size*=2;
            }
        });

        zoomOutButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(MapCamera.size>0)
                    MapCamera.size/=2;


            }
        });

        exitButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "menu");
             //   thread.stop();
                State.setCurrentState(Main.window.menuState);
            }
        });

    }
}
