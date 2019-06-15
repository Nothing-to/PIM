package com.service;

import com.bean.PimAuthentication;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 23:05
 */
public interface PimAuthenticationService {

    /**
     * 注册用户
     *
     * @param name
     * @param password
     * @return
     */
    public PimAuthentication add(String name, String password);

    /**
     * 校验用户,正确则返回 用户Id，用于权限
     *
     * @param user
     * @param password
     * @return
     */
    public Integer verify(String user, String password);

}
