package com.bcht.springcloud.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/3/23.
 */
@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(Integer a,Integer b) {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a="+a+"&b="+b, String.class).getBody();
    }
    public String addServiceFallback(Integer a,Integer b) {
        return "error";
    }
}
