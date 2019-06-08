package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 23:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PimAuthenticationServiceTest {

    @Autowired
    PimAuthenticationService PAService;

    @Test
    public void add() {

        PAService.add("1","1");
    }

    @Test
    public void verify(){
        System.out.println(PAService.verify("1", "2"));
    }
}