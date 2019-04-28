package com.mobiosd;

import com.mobiosd.entity.Attribute;
import com.mobiosd.entity.AttributeResult;
import com.mobiosd.entity.DataSet;
import com.mobiosd.functions.*;

import java.util.ArrayList;

public class Runner {

    DataSet set;
    double t;
    int bin;
    boolean k;
    ArrayList<AttributeResult> results;

    public Runner(DataSet set, int bin ,double t, boolean k) {

        this.set = set;
        this.bin = bin==0 ?set.getAttribute_size(): bin;
        this.t = t;
        this.k = k;
        this.results = new ArrayList<>();

    }

    public void run() {
        int index = 0;
        for (Attribute att:this.set) {
            System.out.println("start compute process of "+ att.getName().toUpperCase());
            AttributeResult result = new AttributeResult(att.getName(), index);
            int [] dist = Common.dist(att, this.bin);
            double entropy = Common.entropy(dist, att.size());

            double I = Entropy.I(entropy, this.k);
            result.addValue("I",I);

            double IG = Entropy.IG(I,att.size());
            result.addValue("IG",IG);

            double z1 = Z1.Z1(dist);
            result.addValue("Z1",z1);

            double z2 = Z2.Z2(dist);
            result.addValue("Z2",z2);

            double uz1 = InternalEnergy.U(entropy,z1,this.k,this.t);
            result.addValue("UZ1",uz1);

            double uz2 = InternalEnergy.U(entropy,z2,this.k,this.t);
            result.addValue("UZ2",uz2);

            double ugz1 = InternalEnergy.UG(uz1, att.size());
            result.addValue("UGZ1",ugz1);

            double ugz2 = InternalEnergy.UG(uz2, att.size());
            result.addValue("UGZ2",ugz2);

            this.results.add(result);
            index++;
            System.out.println("finished compute process of "+ att.getName().toUpperCase());
        }
    }


    @Override
    public String toString() {
        String result = "";
        result += "Attribute\tI\tIG\tZ1\tZ2\tUZ1\tUZ2\tUGZ1\tUGZ2\t";
        result += "\n";
        for (AttributeResult r:this.results) {
            result += r.toString();
            result += "\n";
        }
        return result;
    }
}
