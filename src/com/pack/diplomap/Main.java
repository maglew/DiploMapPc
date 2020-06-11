package com.pack.diplomap;

import com.pack.diplomap.States.Window;

public class Main
{
    public static Window window;

    public static void main(String[] args){
        window=new Window("MapRedPc", 1240, 1000);
        window.createDisplay();
    }
}
