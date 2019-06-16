package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bean.PimAuthentication;
import com.service.PimAuthenticationService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-06 11:09
 */
@Controller()
@RequestMapping(value = "PIM")
public class LoginController {

    @Autowired
    PimAuthenticationService PimService;

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping(value = "Login")
    public String Login() {
        return "Login";
    }

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping(value = "")
    public String defaultLogin() {
        return "Login";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @GetMapping(value = "register")
    public String Interface() {
        return "register";
    }


    /**
     * 主页面
     *
     * @return
     */
    @GetMapping(value = "mainPage")
    public ModelAndView mainPage() {
        return new ModelAndView("mainPage");
    }

    @GetMapping(value = "email")
    public ModelAndView email(){
        return new ModelAndView("email");
    }


    /**
     * 登陆校验
     *
     * @param jsonObject
     * @return
     */
    @PostMapping(value = "checkLogin")
    @ResponseBody
    public JsonMsg checkLogin(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        System.out.println(jsonObject.toJSONString());
        String userId = jsonObject.get("userId").toString();
        String password = jsonObject.get("password").toString();
        Integer checkKey = PimService.verify(userId, password);

        if (checkKey != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("LoginId", checkKey);
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("login_error", "账号或密码错误");

    }

    /**
     * 注册用户
     *
     * @param jsonObject
     * @return
     */
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

    @GetMapping(value = "dog")
    public ModelAndView dog(){
        return new ModelAndView("dog");
    }


}
