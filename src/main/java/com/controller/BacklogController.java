package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimBacklog;
import com.service.PimBacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 20:34
 */
@RestController
public class BacklogController {

    @Autowired
    PimBacklogService service;

    @PostMapping("backlogAjax")
    @ResponseBody
    public String backlogAjax(HttpSession session) {
        List<PimBacklog> backlogs = service.getByBelongAll((Integer) session.getAttribute("LoginId"));
        return JSONArray.toJSONString(backlogs);
    }




}
