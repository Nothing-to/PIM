package com.service;

import com.bean.PimLinkman;
import com.bean.PimTaskList;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 18:27
 */
public interface PimTaskListService {

    /**
     * 根据 用户id 获取相应的内容
     *
     * @param belong
     * @return
     */
    List<PimTaskList> getByBelongAll(Integer belong);

    /**
     * 删除
     *
     * @param id
     */
    void deleteTaskList(Integer id);


    /**
     * 添加
     *
     * @param pimTaskList
     * @return
     */
    PimTaskList addTaskList(PimTaskList pimTaskList);

    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    Integer updateStatus(Integer id , String status);

}
