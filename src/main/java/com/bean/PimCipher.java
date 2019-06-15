package com.bean;

import javax.persistence.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 16:01
 */
@Entity
@Table(name = "Pim_cipher")
public class PimCipher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer belong;
    private String platform;
    private String account;
    private String cipher;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PimCipher{");
        sb.append("id=").append(id);
        sb.append(", belong=").append(belong);
        sb.append(", platform='").append(platform).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", cipher='").append(cipher).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
