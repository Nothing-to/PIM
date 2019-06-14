package com.dao;

import com.bean.PimBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * 根据 id 更新
     * @param id
     * @param title
     * @param content
     * @return
     */
    @Modifying
    @Query("update PimBacklog p set p.backlogTitle=:title, p.backlogContent=:content where id=:id")
    Integer updateBacklog(@Param("id") Integer id,@Param("title") String title,@Param("content") String content);




}
