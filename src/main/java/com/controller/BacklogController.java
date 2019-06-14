package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimBacklog;
import com.service.PimBacklogService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        if (number > 0) {
            id = number;
        }
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

    /**
     * 待办事项 编辑
     *
     * @return
     */
    @GetMapping(value = "backlogEdit")
    public ModelAndView backlogEdit() {
        return new ModelAndView("backlog3");
    }

    /**
     * 删除
     * @param jsonObject
     * @return
     */
    @PostMapping("backlogDel")
    @ResponseBody
    public JsonMsg backlogDel(@RequestBody JSONObject jsonObject){
        Integer id=(Integer) jsonObject.get("delId");
        service.deleteBacklog(id);
        return JsonMsg.success();
    }


    /**
     * 添加
     *
     * @param jsonObject
     * @param session
     * @return
     */
    @PostMapping("backlogAddAJAX")
    @ResponseBody
    public JsonMsg backlogAddAJAX(@RequestBody JSONObject jsonObject, HttpSession session) {
        String title = jsonObject.get("userTitle").toString();
        String content = jsonObject.get("UserContent").toString();
        PimBacklog pimBacklog = new PimBacklog();
        pimBacklog.setBacklogTitle(title);
        pimBacklog.setBacklogContent(content);
        pimBacklog.setBelong((Integer) session.getAttribute("LoginId"));
        pimBacklog.setBacklogDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        pimBacklog.setBacklogImage((new Random().nextInt(10) + 1) + ".jpg");
        PimBacklog result = service.addBacklog(pimBacklog);
        if (result.equals(pimBacklog)) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }

    }

    /**
     * 待办事项 编辑 并保存
     *
     * @param jsonObject
     * @return
     */
    @PostMapping(value = "backlogEditAJAX")
    @ResponseBody
    public JsonMsg backlogEditAJAX(@RequestBody JSONObject jsonObject) {
        Integer id = Integer.parseInt(jsonObject.get("id").toString());
        String title = jsonObject.get("title").toString();
        String content = jsonObject.get("content").toString();
        Integer result = service.updateBacklogId(id, title, content);
        if (result.equals(1)) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }


    /**
     * 待办事项  根据id 获取 单条内容
     *
     * @return
     */
    @PostMapping(value = "backlogDetailsAJAX")
    @ResponseBody
    public String backlogContent() {
        List<PimBacklog> backlogs = service.getById(id);
        return JSONArray.toJSONString(backlogs);
    }


    /**
     * 待办事项 主页面，返回数据
     *
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
