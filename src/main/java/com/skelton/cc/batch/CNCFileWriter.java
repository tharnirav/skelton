package com.skelton.cc.batch;

import com.skelton.cc.domain.InvestAIBalance;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by nthar on 10/3/2015.
 */
public class CNCFileWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        System.out.println("Inside batch writer : Intesrting in to data store. ");
        for(String listItem : list) {
            System.out.println("Writing item " + listItem);
        }
    }
}
