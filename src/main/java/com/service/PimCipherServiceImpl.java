package com.service;

import com.bean.PimBacklog;
import com.bean.PimCipher;
import com.dao.PimCipherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:19
 */
@Service
public class PimCipherServiceImpl implements PimCipherService {

    @Autowired
    PimCipherDao dao;

    @Override
    public List<PimCipher> getByBelongAll(Integer belong) {
        return dao.findByBelong(belong);
    }

    @Override
    public void deletePimCipher(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public PimCipher addPimCipher(PimCipher pimCipher) {
        return dao.save(pimCipher);
    }
}
