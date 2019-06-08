package com.service;

import com.bean.PimAuthentication;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 23:05
 */
public interface PimAuthenticationService {

    public PimAuthentication add(String name, String password);

    public boolean verify(String user, String password);

}
