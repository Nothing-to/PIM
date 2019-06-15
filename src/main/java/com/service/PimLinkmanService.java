package com.service;

import com.bean.PimLinkman;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 14:06
 */
public interface PimLinkmanService {

    /**
     * 根据 用户id 获取相应的内容
     *
     * @param belong
     * @return
     */
    List<PimLinkman> getByBelongAll(Integer belong);


    void deleteLinkman(Integer id);

    PimLinkman addLinkman(PimLinkman pimLinkman);

}
