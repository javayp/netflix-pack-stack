package com.app.controller;

import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import com.app.model.DeviceClientData;
/**
 * Created by ME on 3/8/2017.
 */

@RestController
public class MessageController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/message-data")
    public Map<String,DeviceClientData> getlatestMessage(){
            return clientService.getAllMessages();
    }
}
