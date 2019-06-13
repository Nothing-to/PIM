package com.service;

import com.bean.PimBacklog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 18:38
 */

public interface PimBacklogService {

    /**
     * 根据 用户id 获取相应的内容
     * @param belong
     * @return
     */
    List<PimBacklog> getByBelongAll(Integer belong);

    /**
     * 新增
     * @param pimBacklog
     * @return
     */
    PimBacklog addBacklog(PimBacklog pimBacklog);


    List<PimBacklog> getById(Integer id);


}
