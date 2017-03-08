package com.message.controller;


import com.message.model.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ME on 3/8/2017.
 */
@RestController
public class DataController {

    @RequestMapping(value = "/device-data")
    public Map<String,Data> getLatestData(){

        Data data1=new Data("1","Desktop Data");
        Data data2=new Data("2","Mobile Data");
        Data data3=new Data("3","Raw Data");

        Map<String,Data> mapdata=new HashMap<>();
        mapdata.put("Desktop",data1);
        mapdata.put("Mobile",data2);
        mapdata.put("Raw Data",data3);

        return mapdata;
    }
}
