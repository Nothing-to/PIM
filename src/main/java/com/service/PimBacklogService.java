package com.service;

import com.bean.PimBacklog;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 18:38
 */


public interface PimBacklogService {

    /**
     * 根据 用户id 获取相应的内容
     *
     * @param belong
     * @return
     */
    List<PimBacklog> getByBelongAll(Integer belong);

    /**
     * 新增
     *
     * @param pimBacklog
     * @return
     */
    PimBacklog addBacklog(PimBacklog pimBacklog);

    /**
     * 根据 id获取
     *
     * @param id
     * @return
     */
    List<PimBacklog> getById(Integer id);

    /**
     * 更新
     * @param id
     * @param title
     * @param content
     * @return
     */
    Integer updateBacklogId(Integer id, String title, String content);

    /**
     * 删除
     * @param id
     */
    void deleteBacklog(Integer id);



}
