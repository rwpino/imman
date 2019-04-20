package com.mobiosd;

import org.testng.Assert;
import org.testng.annotations.Test;
public class MainTest {

    @Test
    public void testMain(){
        Main.main(new java.lang.String[]{"--bin=100", "--path='/a/b/c'", "--temperature=100"});
    }
}

