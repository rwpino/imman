package com.mobiosd.io;
import com.mobiosd.entity.Commands;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CommandReadersTest {

    @Test
    public void testGetCommands(){
        Commands commands = CommandReaders.getCommands(new java.lang.String[]{"--bin=100", "--path='/a/b/c'", "--temperature=100"});
        Assert.assertEquals(commands.getBin(), 100, "bin");
        Assert.assertEquals(commands.getPath(),"'/a/b/c'","path");
        Assert.assertEquals(commands.getTemperature(),new Double(100),"temperature");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme