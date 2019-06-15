package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimLinkman;
import com.service.PimLinkmanService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 13:19
 */
@RestController
public class LinkmanController {

    @Autowired
    PimLinkmanService service;


    @GetMapping(value = "linkman")
    public ModelAndView linkman() {
        return new ModelAndView("linkman");
    }

    @GetMapping(value = "linkmanAdd")
    public ModelAndView linkmanAdd() {
        return new ModelAndView("linkman1");
    }

    @PostMapping(value = "linkmanAJAX")
    @ResponseBody
    public String linkmanAJAX(HttpSession session) {
        List<PimLinkman> backlogs = service.getByBelongAll((Integer) session.getAttribute("LoginId"));
        return JSONArray.toJSONString(backlogs);
    }

    @DeleteMapping(value = "linkmanDeleteAJAX")
    @ResponseBody
    public JsonMsg linkmanDeleteAJAX(@RequestBody JSONObject jsonObject) {
        service.deleteLinkman(Integer.parseInt(jsonObject.get("delId").toString()));
        return JsonMsg.success();
    }

    @PostMapping(value = "linkmanAddAJAX")
    @ResponseBody
    public JsonMsg linkmanAddAJAX(@RequestBody JSONObject jsonObject, HttpSession session) {
        PimLinkman pimLinkman = new PimLinkman();
        pimLinkman.setBelong((Integer) session.getAttribute("LoginId"));
        pimLinkman.setName(jsonObject.getString("LinkName"));
        pimLinkman.setNumber(jsonObject.getInteger("LinkNumber"));
        pimLinkman.setEmail(jsonObject.getString("LinkEmail"));
        pimLinkman.setRemark(jsonObject.getString("LinkRemark"));
        PimLinkman result = service.addLinkman(pimLinkman);
        if (pimLinkman.equals(result)) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }


    }


}
