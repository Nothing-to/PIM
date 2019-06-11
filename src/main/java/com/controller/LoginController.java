package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bean.PimAuthentication;
import com.service.PimAuthenticationService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-06 11:09
 */
@Controller
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

    /**
     * 待办事项
     *
     * @return
     */
    @GetMapping(value = "backlog")
    public String backlog() {
        return "backlog";
    }


    /**
     * 待办事项  详情
     *
     * @return
     */
    @GetMapping(value = "backlogDetails")
    public String backlogDetails() {
        return "backlog1";
    }


    /**
     * 待办事项 添加
     *
     * @return
     */
    @GetMapping(value = "backlogAdd")
    public String backlogAdd() {
        return "backlog2";
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


}
