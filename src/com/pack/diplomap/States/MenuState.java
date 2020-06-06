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
    JButton redactbutt = new JButton("Redactor");
    JButton mapbutt = new JButton("Map");

    public MenuState(Handler handler)
    {
        this.add(mapbutt);
        this.add(redactbutt);
        this.addliss();

    }


    void  addliss() {

        mapbutt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "map");
                State.setCurrentState(Main.window.mapState);
            }
        });

        redactbutt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "redactor");
                State.setCurrentState(Main.window.redactState);
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
