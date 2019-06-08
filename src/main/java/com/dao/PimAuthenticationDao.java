package com.dao;

import com.bean.PimAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 22:54
 */
public interface PimAuthenticationDao extends JpaRepository<PimAuthentication,Integer> {

    List<PimAuthentication> getByPimNameStartingWithAndPimPassword(String pimName, String password);
}
