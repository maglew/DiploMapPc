package com.pack.diplomap.States;


import com.pack.diplomap.Handler;
import com.pack.diplomap.Main;
import com.pack.diplomap.MainThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class MenuState extends State
{
  // public JPanel menupanel=new JPanel();
    JButton b1 = new JButton("Map");
    JButton b2 = new JButton("Test");

    public MenuState(Handler handler)
    {
        this.add(b1);
        this.add(b2);
        this.addliss();

    }


    void  addliss() {

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "map");
                State.setCurrentState(Main.window.mapState);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "test");
                State.setCurrentState(Main.window.testState);
            }
        });


    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {

    }

    @Override
    void init() {

    }
}
