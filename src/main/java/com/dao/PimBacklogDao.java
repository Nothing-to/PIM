package com.dao;

import com.bean.PimBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

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
     * 新增 ，插入操作只能用原生的SQL ，太鸡肋
     * @param content
     * @param date
     * @param image
     * @param title
     * @param belong
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "insert into pim_backlog(backlog_content,backlog_date,backlog_image,backlog_title,belong) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    Integer addBacklog(String content,String date,String image,String title,Integer belong);
}
