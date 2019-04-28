package com.mobiosd.io;

import com.mobiosd.entity.Commands;

public class CommandReaders {

    public static Commands getCommands(String[] args) throws Error {
        if (args.length == 0) {
            return CommandReaders.getCommandsFromCommandLine();
        } else {
            return CommandReaders.getCommandsFromInput(args);
        }
    }

    private static Commands getCommandsFromCommandLine() {
        Commands commands = new Commands();
        return commands;
    }

    private static Commands getCommandsFromInput(String[] args) throws Error {
        Commands commands = new Commands();
        for (String arg : args) {
            String[] a = arg.split("=");
//
            if (a.length != 2) {
                throw new Error("command malformed");
            }

            if (a[0].equals("--path")) {
                commands.setPath(a[1]);
                commands.setOutputpath(a[1]+"_output_results.txt");
            } else if (a[0].equals("--bin")) {
                commands.setBin(Integer.parseInt(a[1]));
            } else if (a[0].equals("--temperature")) {
                commands.setTemperature(Double.parseDouble(a[1]));
            }
            else if (a[0].equals("--ignoreFirst")) {
                commands.setIgnoreFirst(Boolean.parseBoolean(a[1]));
            } else if (a[0].equals("--k")) {
                commands.setK(Boolean.parseBoolean(a[1]));
            }else if (a[0].equals("--z")) {
                commands.setZ(Boolean.parseBoolean(a[1]));
            }else if (a[0].equals("--help")) {
                System.out.println(commands.toString());
            }
            else {
                throw new Error("command not found: " + a[0]);
            }

        }

        return commands;
    }

}
