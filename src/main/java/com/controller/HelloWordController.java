package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 17:07
 */

@RestController
public class HelloWordController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String Test(){
     return "HelloWord";
    }

}
