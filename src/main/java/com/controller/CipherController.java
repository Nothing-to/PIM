package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.PimCipher;
import com.bean.PimLinkman;
import com.service.PimCipherService;
import com.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:09
 */
@RestController
public class CipherController {


    @Autowired
    PimCipherService service;


    @GetMapping(value = "cipher")
    public ModelAndView cipher() {
        return new ModelAndView("cipher");
    }

    @GetMapping(value = "cipherAdd")
    public ModelAndView cipherAdd() {
        return new ModelAndView("cipher1");
    }


    @DeleteMapping(value = "cipherDeleteAJAX")
    @ResponseBody
    public JsonMsg cipherDeleteAJAX(@RequestBody JSONObject jsonObject) {
        service.deletePimCipher(Integer.parseInt(jsonObject.get("delId").toString()));
        return JsonMsg.success();
    }


    @PostMapping(value = "cipherAddAJAX")
    @ResponseBody
    public JsonMsg cipherAddAJAX(@RequestBody JSONObject jsonObject, HttpSession session) {
        PimCipher pimCipher=new PimCipher();
        pimCipher.setBelong((Integer) session.getAttribute("LoginId"));
        pimCipher.setAccount(jsonObject.getString("account"));
        pimCipher.setCipher(jsonObject.getString("cipher"));
        pimCipher.setPlatform(jsonObject.getString("platform"));
        pimCipher.setRemark(jsonObject.getString("remark"));
        PimCipher result = service.addPimCipher(pimCipher);
        if (pimCipher.equals(result)) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }


    @PostMapping(value = "cipherAJAX")
    @ResponseBody
    public String cipherAJAX(HttpSession session) {
        List<PimCipher> backlogs = service.getByBelongAll((Integer) session.getAttribute("LoginId"));
        System.out.println(backlogs.size());
        return JSONArray.toJSONString(backlogs);
    }




}
