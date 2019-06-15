package com.service;

import com.bean.PimLinkman;
import com.bean.PimTaskList;
import com.dao.PimCipherDao;
import com.dao.PimTaskListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 18:28
 */
@Service
public class PimTaskListServiceImpl implements PimTaskListService {


    @Autowired
    PimTaskListDao dao;


    @Override
    public List<PimTaskList> getByBelongAll(Integer belong) {
        return dao.findByBelong(belong);
    }

    @Override
    public void deleteTaskList(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public PimTaskList addTaskList(PimTaskList pimTaskList) {
        return dao.save(pimTaskList);
    }

    @Transactional
    @Override
    public Integer updateStatus(Integer id,String status){
        return dao.updateBacklog(id, status);
    }

}
