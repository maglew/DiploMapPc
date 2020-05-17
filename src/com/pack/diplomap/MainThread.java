package com.pack.diplomap;



import com.pack.diplomap.States.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainThread implements Runnable
{



    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;




    public MainThread()
    {


    }

    private void init()
    {


    }

    private void tick()
    {
        State.getCurrentState().tick();


    }

    private void render(){
        bs =State.getCurrentState().canvas.getBufferStrategy();
        if(bs == null){
            State.getCurrentState().canvas.createBufferStrategy(3);
            return;
       }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, State.getCurrentState().canvas.getWidth(), State.getCurrentState().canvas.getHeight());
        //Draw Here!
        g.setColor(Color.black);
        g.fillRect(0,0,State.getCurrentState().canvas.getWidth(), State.getCurrentState().canvas.getHeight());
        State.getCurrentState().render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }



    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                // System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
