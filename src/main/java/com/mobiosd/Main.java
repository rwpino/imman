package com.mobiosd;

import com.mobiosd.entity.Commands;
import com.mobiosd.entity.DataSet;
import com.mobiosd.io.CommandReaders;
import com.mobiosd.io.IO;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to imman");
        Commands commands = CommandReaders.getCommands(args);
        if(commands!=null) {
            System.out.println(commands);
            try {

                if(commands.getPath()!=null) {
                    DataSet set = IO.generateDataSet(commands.getPath(),commands.getIgnoreFirst());
                    Runner runner = new Runner(set, commands.getBin(), commands.getTemperature(), commands.getK());
                    runner.run();
                    IO.saveResults(commands.getOutputpath(), runner.toString());
                }
                System.out.println("finnished");

            } catch (IOException ex) {
                System.out.println(ex);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println(ex.getStackTrace());
            }
        }else{
            System.out.println(Commands.commands());
        }



    }
}
