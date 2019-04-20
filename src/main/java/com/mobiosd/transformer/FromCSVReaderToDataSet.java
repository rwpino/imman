package com.mobiosd.transformer;

import com.mobiosd.entity.DataSet;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
public class FromCSVReaderToDataSet {

    public DataSet generateDataSet(String stringPath, boolean ignoreFirst) throws Exception {
        DataSet set = new DataSet();
        File file = new File(stringPath);

        if(!file.canRead()) {
            throw new Exception("unreadable file");
        }

        BufferedReader reader = new BufferedReader( new FileReader( file ) );

        String first = reader.readLine();

        if(first.length() > 0) {

            String [] att_lines = first.trim().split(",");

            set.setNumberOfAttributes(ignoreFirst ?att_lines.length -1: att_lines.length);

            int i = ignoreFirst? 1 : 0;

            for (; i < att_lines.length; i++) {
                set.addAttribute(att_lines[i]);
            }

            String line = reader.readLine();

            while (line!= null) {
                set.increaseSize();

                att_lines= line.trim().split( "," );

                i = ignoreFirst? 1 : 0;

                for (; i < att_lines.length; i++) {
                    set.addValueToAttribute(ignoreFirst?i-1:i, Double.parseDouble(att_lines[i]));
                }

                line = reader.readLine();
            }
        }

        reader.close();
        return set;
    }

}
