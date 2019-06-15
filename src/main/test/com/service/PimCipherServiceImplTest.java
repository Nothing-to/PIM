package com.service;

import com.bean.PimCipher;
import com.dao.PimCipherDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 17:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PimCipherServiceImplTest {

    @Autowired
    PimCipherDao dao;
    @Test
    public void getByBelongAll() {
    }

    @Test
    public void deletePimCipher() {
    }

    @Test
    public void addPimCipher() {

        PimCipher pimCipher=new PimCipher();
        pimCipher.setRemark("1");
        pimCipher.setPlatform("1");
        pimCipher.setCipher("1");
        pimCipher.setBelong(1);
        pimCipher.setAccount("1");
        dao.save(pimCipher );

    }
}