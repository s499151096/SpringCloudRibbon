package com.bcht.springcloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
public class ComputeController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    ComputeService service;

    @RequestMapping("/hello1")
    public String index(){
        return "HelloWorld1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a,@RequestParam Integer b) {
        return service.addService(a,b);
    }
}
