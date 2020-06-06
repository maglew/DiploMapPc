package com.pack.diplomap;


import com.pack.diplomap.States.State;
import com.pack.diplomap.States.*;
import com.pack.diplomap.gfx.Assets;

import javax.swing.*;
import java.awt.*;

public class Window
{
    public JFrame frame;

    CardLayout cardLayout;


    Handler handler;


    public State menuState;
    public State mapState;
    public State redactState;

    JPanel cardPanel;

    public String title;
    public int width, height;


    public Window(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        handler=new Handler(this);
        Assets.init();


    }

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());


        menuState=new MenuState(handler);
        mapState=new MapState(handler);
        redactState=new RedactorState(handler);

        cardLayout = new CardLayout();
         cardPanel = new JPanel(cardLayout);



        cardPanel.add(menuState,"menu");
        cardPanel.add(mapState,"map");
        cardPanel.add(redactState,"redactor");
        State.setCurrentState(Main.window.menuState);



        frame.add(cardPanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }


    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public State getMenuState() {
        return menuState;
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }

    public State getMapState() {
        return mapState;
    }

    public void setMapState(MapState mapState) {
        this.mapState = mapState;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }
}
