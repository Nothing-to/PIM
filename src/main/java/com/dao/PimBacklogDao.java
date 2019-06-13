package com.dao;

import com.bean.PimBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 18:37
 */
public interface PimBacklogDao extends JpaRepository<PimBacklog,Integer> {

    /**
     * 根据 用户id 获取相应的 内容
     * @param belong
     * @return
     */
    List<PimBacklog> findByBelong(Integer belong);

    /**
     * 根据id 获取单条 详情
     * @param id
     * @return
     */
    @Override
    Optional<PimBacklog> findById(Integer id);


}
