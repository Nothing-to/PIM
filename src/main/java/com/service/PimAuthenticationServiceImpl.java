package com.service;

import com.bean.PimAuthentication;
import com.dao.PimAuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 22:57
 */
@Service
public class PimAuthenticationServiceImpl implements PimAuthenticationService{

    @Autowired
    private PimAuthenticationDao Dao;

    @Override
    public PimAuthentication add(String name,String password){
        PimAuthentication pimAuthentication=new PimAuthentication();
        pimAuthentication.setPimName(name);
        pimAuthentication.setPimPassword(password);
        return Dao.save(pimAuthentication);

    }

    @Override
    public boolean verify(String user, String password) {

        List<PimAuthentication>  list =Dao.getByPimNameStartingWithAndPimPassword(user,user);
        if (list.size()==1){
            boolean checkName=list.get(0).getPimName().equals(user);
            boolean checkPass=list.get(0).getPimPassword().equals(password);
            if (checkName && checkPass){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


}
