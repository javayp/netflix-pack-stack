package com.proxy.Filters;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RoutingFilter extends ZuulFilter {
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private HttpServletRequest request;

    private DiscoveryClient client;

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //to know eureka server status
        InstanceInfo.InstanceStatus latestStatus = eurekaClient.getInstanceRemoteStatus();
        System.out.println("Eureka Server is "+latestStatus);


        Application app = eurekaClient.getApplication("client-app");
        System.out.println("Accessing application name "+app.getName());

        List<InstanceInfo> instanceInfos=app.getInstancesAsIsFromEureka();
        for (InstanceInfo info:instanceInfos){
            System.out.println("App Instance Id"+info.getInstanceId());
            System.out.println("data center info "+info.getDataCenterInfo());
            System.out.println("Health Check Url "+info.getHealthCheckUrl());
            System.out.println("Exploring app URL-----------------------");
            String urls=info.getHomePageUrl();
            try {
                URL url=new URL(urls);
                System.out.println("url "+url);
                String protocol = url.getProtocol();
                System.out.println("protocol "+protocol);
                String rootHost = url.getHost();
                System.out.println("rootHost "+rootHost);
                int port = url.getPort();
                System.out.println("Port "+port);
                String portS = (port > 0 ? ":" + port : "");
                System.out.println("Ports "+portS);

                //Accessing the incoming http requests
                RequestContext context=RequestContext.getCurrentContext();
                System.out.println("Current Request "+context.getRequest());
                System.out.println("Endpoint URL "+context.getRequest().getRequestURL());
                System.out.println("Zuul Proxy port no "+context.getRequest().getServerPort());
                context.setRouteHost(new URL(protocol+"://"+rootHost+portS));
                System.out.println("Route Host"+context.getRouteHost());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            System.out.println("End exploring----------------------------");
            System.out.println("App port no "+info.getPort());
            System.out.println("App getHostName "+info.getHostName());
            System.out.println("App getInstanceId "+info.getInstanceId());
            System.out.println("App getIPAddr "+info.getIPAddr());

        }
        System.out.println("-------Both above and below code are meant for same work");

        //to know information about client
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("client-app",false);
        System.out.println("App url "+instanceInfo.getHomePageUrl());
        System.out.println("App port no "+instanceInfo.getPort());
        System.out.println("App getHostName "+instanceInfo.getHostName());
        System.out.println("App getInstanceId "+instanceInfo.getInstanceId());
        System.out.println("App getIPAddr "+instanceInfo.getIPAddr());


        return true;
    }

    @Override
    public Object run() {
        RequestContext context= RequestContext.getCurrentContext();

        System.out.println("Getting header information");
        Map<String,String > headers=context.getZuulRequestHeaders();
        for (Map.Entry<String, String> entry:headers.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println("Contex Map");

        Set<Map.Entry<String,Object>> set=context.entrySet();
        for (Map.Entry<String,Object> m:set){
            System.out.println(m.getKey()+"-=-=-="+m.getValue());
        }
        return null;
    }

    boolean isAuthorized(){
        return false;
    }
}