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
        this.t = t!=0? t: 1;
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

            double hz1 = Enthalpy.H(entropy,z1,this.k,this.t);
            result.addValue("HZ1",hz1);

            double hz2 = Enthalpy.H(entropy,z2,this.k,this.t);
            result.addValue("HZ2",hz2);

            double hgz1 = Enthalpy.HG(hz1, att.size());
            result.addValue("HGZ1",hgz1);

            double hgz2 = InternalEnergy.UG(hz2, att.size());
            result.addValue("HGZ2",hgz2);

            double gz1 = Gibbs.G(I, hz1, this.t);
            result.addValue("GZ1",gz1);

            double gz2 = Gibbs.G(I, hz2, this.t);
            result.addValue("GZ2",gz2);

            double ggz1= Gibbs.GG(gz1, att.size());
            result.addValue("GGZ1",ggz1);

            double ggz2 = Gibbs.GG(gz2,att.size() );
            result.addValue("GGZ2",ggz2);

            double az1 = Helmholtz.A(I, uz1, this.t);
            result.addValue("AZ1",az1);

            double az2 = Helmholtz.A(I, uz2, this.t);
            result.addValue("AZ2",az2);

            double agz1 = Helmholtz.AG(az1,att.size());
            result.addValue("AGZ1",agz1);

            double agz2 = Helmholtz.AG(az2,att.size());
            result.addValue("AGZ2",agz2);


            this.results.add(result);
            index++;
            System.out.println("finished compute process of "+ att.getName().toUpperCase());
        }
    }


    @Override
    public String toString() {
        String result = "";
        result += "Attribute\tI\tIG\tZ1\tZ2\tUZ1\tUZ2\tUGZ1\tUGZ2\tHZ1\tHZ2\tHGZ1\tHGZ2\tGZ1\tGZ2\tGGZ1\tGGZ2\tAZ1\tAZ2\tAGZ1\tAGZ2\t";
        result += "\n";
        for (AttributeResult r:this.results) {
            result += r.toString();
            result += "\n";
        }
        return result;
    }
}
