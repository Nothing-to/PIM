package com.service;

import com.bean.PimCipher;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:18
 */
public interface PimCipherService {


    /**
     * 根据 用户id 获取相应的内容
     *
     * @param belong
     * @return
     */
    List<PimCipher> getByBelongAll(Integer belong);


    /**
     * 删除
     *
     * @param id
     */
    void deletePimCipher(Integer id);


    /**
     * 添加
     *
     * @param pimCipher
     * @return
     */
    PimCipher addPimCipher(PimCipher pimCipher);


}
