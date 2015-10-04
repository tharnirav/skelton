package com.skelton.cc.batch;

import com.skelton.cc.domain.InvestAIBalance;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by nthar on 10/3/2015.
 */
public class CNCFileReader implements ItemReader<String> {


    String fileName;
    BufferedReader fileReader = null;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("Inside batch reader : Reading from file store. ");
        String line;
        while((line = fileReader.readLine()) != null) {
            return line;
        }
        fileReader.close();
        //throw new RuntimeException();
        return null;
    }

    @Value("#{jobParameters['input.file.name']}")
    public void setFileName(final String name) {
        this.fileName = name;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }
}
