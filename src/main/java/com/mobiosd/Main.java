package com.mobiosd;

import com.mobiosd.entity.Commands;
import com.mobiosd.io.CommandReaders;;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to imman");
        Commands commands = CommandReaders.getCommands(args);
        System.out.println(commands);
    }
}
