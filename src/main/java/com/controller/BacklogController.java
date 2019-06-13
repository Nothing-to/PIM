package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimBacklog;
import com.service.PimBacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    Integer id;

    /**
     * 待办事项
     *
     * @return
     */
    @GetMapping(value = "backlog")
    public ModelAndView backlog() {
        return new ModelAndView("backlog");
    }


    /**
     * 待办事项  详情
     *
     * @return
     */
    @GetMapping(value = "backlogDetails/{number}")
    public ModelAndView backlogDetails(@PathVariable Integer number) {
        id=number;
        System.out.println(id+"  *******");
        return new ModelAndView("backlog1");
    }


    /**
     * 待办事项 添加
     *
     * @return
     */
    @GetMapping(value = "backlogAdd")
    public ModelAndView backlogAdd() {
        return new ModelAndView("backlog2");
    }

    @GetMapping(value = "backlogEdit")
    public ModelAndView backlogEdit() {
        return new ModelAndView("backlog3");
    }


    @PostMapping(value = "backlogDetailsAJAX")
    @ResponseBody
    public String backlogContent(){
        List<PimBacklog> backlogs=service.getById(id);
        return JSONArray.toJSONString(backlogs);
    }


    /**
     * 待办事项 主页面，返回数据
     * @param session
     * @return
     */
    @PostMapping("backlogAjax")
    @ResponseBody
    public String backlogAjax(HttpSession session) {
        List<PimBacklog> backlogs = service.getByBelongAll((Integer) session.getAttribute("LoginId"));
        return JSONArray.toJSONString(backlogs);
    }




}
