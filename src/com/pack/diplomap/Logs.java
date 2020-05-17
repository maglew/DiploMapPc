package com.pack.diplomap;


import com.pack.diplomap.States.State;
import com.pack.diplomap.States.TestState;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logs
{
    String log="";
    String root ;
    File myDir ;
    File file ;
    String fname = "Log.txt";

    public Logs()
    {

        try {
             myDir = new File("C://Users//maglew//Desktop" , fname);
        }
        catch (Throwable t)
        {

        }
        createnewlog();

    }

    public void createnewlog()
    {
        try {

            if (!myDir.exists()) {
                myDir.mkdirs();
            }

            if (file.exists())
                file.delete();
        }
        catch (Throwable t)
        {

        }
    }

    public void cleanlog()
    {

    }

    public void addtolog(String logstring)
    {
       // Toast toast = Toast.makeText(Manifest, "Hello Android 7", Toast.LENGTH_LONG);
     //   toast.show();

        State.getCurrentState().exception++;

        String buf= State.getCurrentState().exception+") "+ logstring+"\n";
        System.out.print(buf);

        try {

            FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(buf);
            bufferWriter.close();
        }
        catch (Throwable t)
        {

        }


    }
}
