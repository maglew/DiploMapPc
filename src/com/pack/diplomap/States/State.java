package com.pack.diplomap.States;

import com.pack.diplomap.Interface.MapCamera;
import com.pack.diplomap.Interface.MouseManager;
import com.pack.diplomap.Logs;
import com.pack.diplomap.MainThread;
import com.pack.diplomap.MapObjects.DrawMap;

import javax.swing.*;
import java.awt.*;


public abstract class State extends JPanel {

	public  int exception=0;
	public  Logs log;
	public  MainThread thread;
	public  DrawMap drawMap;
	public Canvas canvas;
	public MapCamera mapCamera;
	public MouseManager mouseManager;


	public State()
	{
		log=new Logs();
		mouseManager=new MouseManager();
	}

	private static State currentState = null;
	public static void setCurrentState(State state)
	{
		currentState = state;
		state.init();
	}
	public static State getCurrentState(){
		return currentState;
	}

	abstract void init();
	{

	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public  int getException() {
		return exception;
	}

	public  Logs getLog() {
		return log;
	}

	public  MainThread getThread() {
		return thread;
	}

	public  DrawMap getDrawMap() {
		return drawMap;
	}

	public  void setDrawMap(DrawMap drawMap) {
		this.drawMap=drawMap;
	}
}
