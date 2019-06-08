package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-06 10:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    TestService service;

    @Test
    public void add() {

        service.add();
    }
}