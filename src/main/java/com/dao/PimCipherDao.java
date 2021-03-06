package com.dao;

import com.bean.PimCipher;
import com.bean.PimLinkman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:17
 */
public interface PimCipherDao extends JpaRepository<PimCipher, Integer> {


    /**
     * 根据 用户id 获取相应的 内容
     *
     * @param belong
     * @return
     */
    List<PimCipher> findByBelong(Integer belong);
}
