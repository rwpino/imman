package com.mobiosd.functions;

import com.mobiosd.entity.AttributeResult;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntropiesTest {

    @Test
    public void testGetValueDistribution() {
        int[] result = Entropies.getValueDistribution(null, 0);
        Assert.assertEquals(result, new int[]{0});
    }

    @Test
    public void testGetProbabilityDistribution() {
        double[] result = Entropies.getProbabilityDistribution(null, 0);
        Assert.assertEquals(result, new double[]{0d});
    }

    @Test
    public void testShannonEntropy() {
        AttributeResult result = Entropies.ShannonEntropy(null, 0, true);
        Assert.assertEquals(result, null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme