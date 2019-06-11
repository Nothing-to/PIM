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

    /**
     * jpa 插入操作只能原生SQL，无奈之举
     * @param pimBacklog
     * @return
     */
    @Override
    public Integer addBacklog(PimBacklog pimBacklog) {
        return dao.addBacklog(pimBacklog.getBacklogContent(), pimBacklog.getBacklogDate(), pimBacklog.getBacklogImage(), pimBacklog.getBacklogTitle(), pimBacklog.getBelong());
    }
}
