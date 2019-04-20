package com.mobiosd;

import com.mobiosd.entity.Commands;
import com.mobiosd.entity.DataSet;
import com.mobiosd.io.CommandReaders;
import com.mobiosd.transformer.FromCSVReaderToDataSet;


public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to imman");
        Commands commands = CommandReaders.getCommands(args);

        FromCSVReaderToDataSet reader = new FromCSVReaderToDataSet();
        System.out.println(commands);
        try {
            DataSet set = reader.generateDataSet(commands.getPath(),commands.getIgnoreFirst());
        }catch (Exception ex) {
            System.out.println(ex);
        }



    }
}
