package com.pack.diplomap;

import com.pack.diplomap.Interface.MouseManager;
import com.pack.diplomap.States.State;
import com.pack.diplomap.States.Window;

public class Handler {

private Window window;


public Handler(Window window)
{this.window=window;}

    public int getWidth()
    {return window.width;}

    public int getHeight()
    {return window.height;}





    public MouseManager getMouseManager()
    {return State.getCurrentState().mouseManager;}

    public MainThread getThread() {
        return State.getCurrentState().getThread();
    }


    public State getState()
    {
        return State.getCurrentState();
    }

    public Window getWindow()
    {
        return Main.window;
    }

    }
