package com.dao;

import com.bean.PimLinkman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 14:06
 */
public interface PimLinkmanDao extends JpaRepository<PimLinkman, Integer> {

    /**
     * 根据 用户id 获取相应的 内容
     *
     * @param belong
     * @return
     */
    List<PimLinkman> findByBelong(Integer belong);

}
