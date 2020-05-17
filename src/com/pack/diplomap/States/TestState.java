package com.pack.diplomap.States;



import com.pack.diplomap.Handler;
import com.pack.diplomap.Main;
import com.pack.diplomap.MainThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestState extends State
{

    private Canvas canvas;
    JButton b1;

    public TestState(Handler handler)
    {
        b1= new JButton("exit");
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(400, 400));
        canvas.setMaximumSize(new Dimension(400, 400));
        canvas.setMinimumSize(new Dimension(400, 400));
        canvas.setFocusable(false);

        this.add(b1);
        this.add(canvas);



    }

    @Override
    void init()
    {
        thread=new MainThread();
        thread.start();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Main.window.getCardLayout().show(Main.window.getCardPanel(), "menu");
                State.setCurrentState(Main.window.menuState);

            }
        });
    }



    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
