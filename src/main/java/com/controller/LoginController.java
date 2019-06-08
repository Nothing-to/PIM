package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bean.PimAuthentication;
import com.service.PimAuthenticationService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-06 11:09
 */
@Controller
public class LoginController {

    @Autowired
    PimAuthenticationService PimService;


    @RequestMapping(value = "Login")
    public String Login() {
        return "Login";
    }

    @RequestMapping(value = "register")
    public String Interface() {
        return "register";
    }

    @PostMapping(value = "checkLogin")
    @ResponseBody
    public JsonMsg checkLogin(@RequestBody JSONObject jsonObject) {

        System.out.println(jsonObject.toJSONString());
        String userId = jsonObject.get("userId").toString();
        String password = jsonObject.get("password").toString();
        boolean checkKey = PimService.verify(userId, password);
        if (checkKey) {
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("login_error", "账号或密码错误");

    }

    @PostMapping(value = "register")
    @ResponseBody
    public JsonMsg register(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.get("userId").toString();
        String password = jsonObject.get("password").toString();
        PimAuthentication pim = PimService.add(userId, password);
        if (userId == pim.getPimName() && password == pim.getPimPassword()) {
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("register_error", "注册失败！！");
    }





}
