package com.bean;


import javax.persistence.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-15 18:09
 */
@Entity
@Table(name = "Pim_taskList")
public class PimTaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer belong;
    private String status;
    private String item;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PimTaskList{");
        sb.append("id=").append(id);
        sb.append(", belong=").append(belong);
        sb.append(", status='").append(status).append('\'');
        sb.append(", item='").append(item).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
