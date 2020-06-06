package com.pack.diplomap.Interface;

import com.pack.diplomap.States.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomChangeForm {
    private JPanel panel1;
    private JButton addEdgesButton;
    private JButton exitButton;
    private JButton setEdgesButton;
    private JButton setNumberButton;
    private JButton OKButton;
    private JTextField textField1;
    private JTextField textField2;
int id=-1;
    public RoomChangeForm(int id)
    {
        this.id=id;
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setVisible(true);

        setEdgesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).setedgescount(Integer.parseInt(textField1.getText()));
            }
        });


    }



}
