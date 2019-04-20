package com.mobiosd.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommandsTest {
    Commands commands= new com.mobiosd.entity.Commands();
    @Test
    public void testSetParameters(){
        commands.setBin(100);
        commands.setPath("/a/b/c");
        commands.setTemperature(100);
        Assert.assertEquals(commands.getBin(), 100);
        Assert.assertEquals(commands.getTemperature(), new Double(100));
        Assert.assertEquals(commands.getPath(), "/a/b/c");
    }
    @Test
    public void testToString(){
        commands.setBin(100);
        commands.setPath("/a/b/c");
        commands.setTemperature(100);
        java.lang.String result = commands.toString();
        Assert.assertEquals(result.contains("temperature: 100.0"), true, "temperature");
        Assert.assertEquals(result.contains("bin: 100 "), true, "bin");
        Assert.assertEquals(result.contains("path: /a/b/c"), true, "path");

    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme