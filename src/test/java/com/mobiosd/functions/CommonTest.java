package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonTest {

    @Test
    public void testRound() {
        double result = Common.round(0d);
        Assert.assertEquals(result, 0d);
    }

    @Test
    public void testDist() {
        int[] result = Common.dist(new Attribute("name"), 0);
        Assert.assertEquals(result, new int[]{0});
    }

    @Test
    public void testDist2() {
        int[] result = Common.dist(new double[]{0d}, 0d, 0d, 0);
        Assert.assertEquals(result, new int[]{0});
    }

    @Test
    public void testProbdist() {
        double[] result = Common.probdist(new Attribute("name"), 0);
        Assert.assertEquals(result, new double[]{0d});
    }

    @Test
    public void testProbdist2() {
        double[] result = Common.probdist(new int[]{0}, 0);
        Assert.assertEquals(result, new double[]{0d});
    }

    @Test
    public void testEntropy() {
        double result = Common.entropy(new Attribute("name"), 0);
        Assert.assertEquals(result, 0d);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme