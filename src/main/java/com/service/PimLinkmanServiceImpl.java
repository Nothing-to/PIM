package com.service;

import com.bean.PimLinkman;
import com.dao.PimLinkmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 14:07
 */
@Service
public class PimLinkmanServiceImpl implements PimLinkmanService {

    @Autowired
    PimLinkmanDao dao;

    @Override
    public List<PimLinkman> getByBelongAll(Integer belong) {
        return dao.findByBelong(belong);
    }

    @Override
    public void deleteLinkman(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public PimLinkman addLinkman(PimLinkman pimLinkman) {
        return dao.save(pimLinkman);
    }
}
