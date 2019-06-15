package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimTaskList;
import com.service.PimTaskListService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 18:22
 */
@RestController
public class TaskListController {

    @Autowired
    PimTaskListService service;

    @GetMapping(value = "taskList")
    public ModelAndView  taskList(){
        return new ModelAndView("taskList");
    }

    @GetMapping(value = "taskListAdd")
    public ModelAndView  taskListAdd(){
        return new ModelAndView("taskList1");
    }

    @PostMapping(value = "taskListAJAX")
    @ResponseBody
    public String taskListAJAX(HttpSession session){
        List<PimTaskList> pimTaskLists=service.getByBelongAll((Integer) session.getAttribute("LoginId"));
        return JSONArray.toJSONString(pimTaskLists);
    }


    @DeleteMapping(value = "taskListDeleteAJAX")
    @ResponseBody
    public JsonMsg taskListDeleteAJAX(@RequestBody JSONObject jsonObject) {
        service.deleteTaskList(Integer.parseInt(jsonObject.get("delId").toString()));
        return JsonMsg.success();
    }

    @PostMapping(value = "taskListAddAJAX")
    @ResponseBody
    public JsonMsg taskListAddAJAX(@RequestBody JSONObject jsonObject, HttpSession session) {
        PimTaskList pimTaskList=new PimTaskList();
        pimTaskList.setBelong((Integer) session.getAttribute("LoginId"));
        pimTaskList.setItem(jsonObject.getString("taskItem"));
        PimTaskList result = service.addTaskList(pimTaskList);
        if (pimTaskList.equals(result)) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }


    @PutMapping(value = "taskListCheckboxT")
    @ResponseBody
    public JsonMsg taskListCheckboxT(@RequestBody JSONObject jsonObject){

       int result= service.updateStatus(jsonObject.getInteger("changeId"),"checked");
        if (result==1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }

    }

    @PutMapping(value = "taskListCheckboxF")
    @ResponseBody
    public JsonMsg taskListCheckboxF(@RequestBody JSONObject jsonObject){

        int result= service.updateStatus(jsonObject.getInteger("changeId"),"");
        if (result==1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }

    }



}
