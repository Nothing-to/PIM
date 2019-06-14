package com.service;

import com.bean.PimBacklog;
import com.dao.PimBacklogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
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

    @Override
    public List<PimBacklog> getById(Integer id) {
        return dao.findById(id).map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Transactional
    @Override
    public Integer updateBacklogId(Integer id, String title, String content) {
        return dao.updateBacklog(id, title, content);
    }

    @Override
    public void deleteBacklog(Integer id) {
        dao.deleteById(id);
    }


}
