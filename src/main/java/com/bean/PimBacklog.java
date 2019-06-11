package com.bean;

import javax.persistence.*;


/**
 * @Author: 刘冠麟
 * @Date: 2019-06-11 18:24
 */
@Entity
@Table(name = "Pim_backlog")
public class PimBacklog {


    /**
     * 在第一次生成表的时候,使用的是Auto而不是IDENTITY 方式,
     * 这时候表的主键字段就不会有auto_increment这个属性,所以不管怎么改,都不会自增的
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer belong;
    private String backlogTitle;
    private String backlogContent;
    private String backlogImage;
    private String backlogDate;


    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBacklogTitle() {
        return backlogTitle;
    }

    public void setBacklogTitle(String backlogTitle) {
        this.backlogTitle = backlogTitle;
    }

    public String getBacklogContent() {
        return backlogContent;
    }

    public void setBacklogContent(String backlogContent) {
        this.backlogContent = backlogContent;
    }

    public String getBacklogImage() {
        return backlogImage;
    }

    public void setBacklogImage(String backlogImage) {
        this.backlogImage = backlogImage;
    }

    public String getBacklogDate() {
        return backlogDate;
    }

    public void setBacklogDate(String backlogDate) {
        this.backlogDate = backlogDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PimBacklog{");
        sb.append("id=").append(id);
        sb.append(", belong=").append(belong);
        sb.append(", backlogTitle='").append(backlogTitle).append('\'');
        sb.append(", backlogContent='").append(backlogContent).append('\'');
        sb.append(", backlogImage='").append(backlogImage).append('\'');
        sb.append(", backlogDate='").append(backlogDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
