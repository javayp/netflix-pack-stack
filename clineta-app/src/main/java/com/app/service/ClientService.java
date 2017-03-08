package com.app.service;

import com.app.model.DeviceClientData;
import com.config.feign.ClientRemoteFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by ME on 3/8/2017.
 */
@Service
public class ClientService {

    @Autowired
    private ClientRemoteFeign clientRemoteFeign;

    @HystrixCommand(fallbackMethod ="fallbackGetAllMessages")
    public Map<String,DeviceClientData> getAllMessages(){
       return clientRemoteFeign.getAllMessages();
    }

    public Map<String,DeviceClientData> fallbackGetAllMessages(){
        return Collections.singletonMap("Outagae",new DeviceClientData("ooo","Server Outage"));
    }
}
