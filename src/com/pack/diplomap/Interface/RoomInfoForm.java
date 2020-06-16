package com.pack.diplomap.Interface;

import com.pack.diplomap.MapObjects.RoomInfo;
import com.pack.diplomap.States.State;

import javax.swing.*;

public class RoomInfoForm {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panel1;
    private JLabel telephone;

    int id=-1;
    RoomInfo roomInfo2;

    public RoomInfoForm(int id)
    {
        this.id=id;

        roomInfo2=new RoomInfo();
        roomInfo2= State.getCurrentState().drawMap.floors.get(State.getCurrentState().drawMap.selectedfloor).drawObjects.elements.get(id).getRoomInfo();
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setVisible(true);

        textField1.setText(roomInfo2.getNumber()+"");
        textField2.setText(roomInfo2.getName()+"");
        textField3.setText(roomInfo2.getDescription()+"");
        textField4.setText(roomInfo2.getSite()+"");
        textField5.setText(roomInfo2.getTelephone()+"");
    }


}
