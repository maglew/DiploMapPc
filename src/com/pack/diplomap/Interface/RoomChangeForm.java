package com.pack.diplomap.Interface;

import com.pack.diplomap.MapObjects.RoomInfo;
import com.pack.diplomap.States.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RoomChangeForm {
    private JPanel panel1;
    private JButton addEdgesButton;
    private JButton exitButton;
    private JButton setEdgesButton;
    private JButton setNumberButton;
    private JButton OKButton;
    private JTextField textedges;
    private JTextField textnumber;
    private JButton setNameButton;
    private JButton setDescriptionButton;
    private JButton setWebSiteButton;
    private JButton setTelephoneButton;
    private JTextField textname;
    private JTextField textdes;
    private JTextField textweb;
    private JTextField texttel;
    int id=-1;
    RoomInfo roomInfo;
    public RoomChangeForm(int id)
    {
        this.id=id;
        roomInfo=new RoomInfo();
        roomInfo=State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).getRoomInfo();
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setVisible(true);

        setEdgesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setedgescount(Integer.parseInt(textedges.getText()));
            }
        });


        setNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                roomInfo.setNumber(Integer.parseInt(textedges.getText()));
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setroom(roomInfo);

            }
        });
        setNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomInfo.setName(textname.getText());
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setroom(roomInfo);

            }
        });
        setDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomInfo.setDescription(textdes.getText());
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setroom(roomInfo);

            }
        });
        setTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomInfo.setTelephone(texttel.getText());
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setroom(roomInfo);

            }
        });
        setWebSiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomInfo.setSite(textweb.getText());
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setroom(roomInfo);

            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
        });
    }



}
