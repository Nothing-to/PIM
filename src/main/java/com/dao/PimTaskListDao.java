package com.dao;

import com.bean.PimLinkman;
import com.bean.PimTaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 18:26
 */
public interface PimTaskListDao extends JpaRepository<PimTaskList, Integer> {

    /**
     * 根据 用户id 获取相应的 内容
     *
     * @param belong
     * @return
     */
    List<PimTaskList> findByBelong(Integer belong);


    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    @Modifying
    @Query("update PimTaskList p set p.status=:status where id=:id")
    Integer updateBacklog(@Param("id") Integer id,  @Param("status") String status);

}
