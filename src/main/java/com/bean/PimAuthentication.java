package com.bean;

import javax.persistence.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 22:46
 */
@Entity
@Table(name = "pim_authentication")
public class PimAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String pimName;
    private String pimPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPimName() {
        return pimName;
    }

    public void setPimName(String pimName) {
        this.pimName = pimName;
    }

    public String getPimPassword() {
        return pimPassword;
    }

    public void setPimPassword(String pimPassword) {
        this.pimPassword = pimPassword;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PimAuthentication{");
        sb.append("id=").append(id);
        sb.append(", pimName='").append(pimName).append('\'');
        sb.append(", pimPassword='").append(pimPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
