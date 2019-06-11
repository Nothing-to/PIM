package com.service;

import com.bean.PimBacklog;
import com.dao.PimBacklogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 18:38
 */
@Service
public class PimBacklogServiceImpl implements PimBacklogService {

    @Autowired
    PimBacklogDao dao;


    @Override
    public List<PimBacklog> getByBelongAll(Integer belong) {
        return dao.findByBelong(belong);
    }


    @Override
    public PimBacklog addBacklog(PimBacklog pimBacklog) {
       return dao.save(pimBacklog);
    }
}
