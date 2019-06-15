package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:09
 */
@RestController
public class CipherController {


    @GetMapping(value = "cipher")
    public ModelAndView cipher() {
        return new ModelAndView("cipher");
    }

    @GetMapping(value = "cipherAdd")
    public ModelAndView cipherAdd() {
        return new ModelAndView("cipher1");
    }


    @PostMapping(value = "cipherAJAX")
    @ResponseBody
    public String cipherAJAX() {

        return "";
    }


}
