package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntropiesTest {

    private static Attribute getTestAttribute() {
        String name = "test";
        Attribute att = new Attribute(name);
        for (int i = 1; i <= 10; i++) {
            att.addValue(Double.parseDouble(""+i));
        }
        return att;
    }
    @Test
    public void testGetValueDistribution() {
        int [] out = new int[10];
        for (int i = 1; i <= 10; i++) {
            out[i-1]=1;
        }

        int[] result = Entropies.dist(getTestAttribute(), 10);

        Assert.assertEquals(result, out);
    }

    @Test
    public void testGetProbabilityDistribution() {
        Double [] out = new Double[10];
        for (int i = 1; i <= 10; i++) {
            out[i-1]= new Double(1) / new Double(10);
        }

        double[] result = Entropies.probdist(getTestAttribute(), 10);
        Assert.assertEquals(result, out);
    }

    @Test
    public void testI() {
        Attribute att = getTestAttribute();
        double result = Entropies.I(att, 10, false);
        System.out.println(result);
        Assert.assertEquals(result, new Double(1));
    }

    @Test
    public void testIKtrue() {
        Attribute att = getTestAttribute();
        double result = Entropies.I(att, 10, true);
        Assert.assertEquals(result, 1.3806487999999995E-23);
    }

    @Test
    public void testIG() {
        Attribute att = getTestAttribute();
        double result = Entropies.IG(att, 10, false);
        Assert.assertEquals(result, 10);
    }

    @Test
    public void testIGtrue() {
        Attribute att = getTestAttribute();
        double result = Entropies.IG(att, 10, true);
        Assert.assertEquals(result, 1.3806487999999995E-22);
    }

    @Test
    public void testboltzmann_constant() {
        Assert.assertEquals(Entropies.boltzmann_constant, 1.3806487999999998E-23);
    }


    @Test
    public void testZ1() {
        Attribute att = getTestAttribute();
        double result = Entropies.Z1(att, 10);
        Assert.assertEquals(result,1.0);
    }
    @Test
    public void testZ2() {
        Attribute att = getTestAttribute();
        double result = Entropies.Z2(att, 10);
        Assert.assertEquals(result,1.0);
    }
}
