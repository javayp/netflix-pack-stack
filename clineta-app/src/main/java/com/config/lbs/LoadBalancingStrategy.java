package com.config.lbs;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by ME on 3/13/2017.
 */
public class LoadBalancingStrategy {

    @Autowired
    public IClientConfig ribbonClientConfig;

    @Bean
    public IRule rule(IClientConfig config){
        return new AvailabilityFilteringRule();
    }
}
