package com.service;

import com.bean.PimBacklog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 19:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PimBacklogServiceImplTest {

    @Autowired
    PimBacklogService service;

    @Test
    public void getByBelongAll() {
        System.out.println(service.getByBelongAll(1)+"************");

    }

    @Test
    public void addBacklog() {
        PimBacklog pimBacklog=new PimBacklog();
        pimBacklog.setBacklogContent("1");
        pimBacklog.setBacklogDate("1");
        pimBacklog.setBacklogImage("1");
        pimBacklog.setBacklogTitle("1");
        pimBacklog.setBelong(1);
        service.addBacklog(pimBacklog);

    }

    @Test
    public void test(){

    }
}