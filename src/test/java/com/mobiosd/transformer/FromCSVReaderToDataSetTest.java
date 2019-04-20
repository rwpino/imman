package com.mobiosd.transformer;

import com.mobiosd.entity.DataSet;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FromCSVReaderToDataSetTest {
    FromCSVReaderToDataSet reader = new FromCSVReaderToDataSet();

    @Test
    public void testGenerateDataSet() {
    String path = "/Users/ricardo/java-projects/imman2.0/datas/MOLZ_without_column_description.csv";
    try {
        DataSet set = reader.generateDataSet(path, false);
        Assert.assertEquals(set.getAttributes_count(), 478, "the number of attributes in the data");
        Assert.assertEquals(set.getAttribute_size(), 41, "the number of intances in the data");

    }catch (Exception ex) {
        System.out.println(ex);
    }


    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme