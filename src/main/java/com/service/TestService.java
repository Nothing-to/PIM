package com.service;

import com.bean.PimAuthentication;
import com.dao.PimAuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-06 10:26
 */
@Service
public class TestService  {

    @Autowired
    PimAuthenticationDao dao;

    public void add(){

        PimAuthentication p=new PimAuthentication();
        p.setPimName("2");
        p.setPimPassword("2");
        dao.save(p);

    }

}
