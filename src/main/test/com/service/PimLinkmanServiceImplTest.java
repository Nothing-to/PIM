package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 14:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PimLinkmanServiceImplTest {

    @Autowired
    PimLinkmanService service;
    @Test
    public void getByBelongAll() {

        System.out.println(service.getByBelongAll(1));

    }
}