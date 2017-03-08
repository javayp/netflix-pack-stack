package com.config.feign;

import com.app.model.DeviceClientData;
import com.app.service.ClientService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by ME on 3/8/2017.
 */

@Component
@FeignClient(name ="DATA-PRODUCER")
public interface ClientRemoteFeign {
    @RequestMapping(value = "/device-data",method = RequestMethod.GET)
    public Map<String,DeviceClientData> getAllMessages();
}
