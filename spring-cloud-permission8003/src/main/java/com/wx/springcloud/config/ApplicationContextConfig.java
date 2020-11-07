package com.wx.springcloud.config;

import com.wx.springcloud.openfeign.UserOpenfeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig
{

    @Autowired
    UserOpenfeign userOpenfeign;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {

        return new RestTemplate();

    }


}
