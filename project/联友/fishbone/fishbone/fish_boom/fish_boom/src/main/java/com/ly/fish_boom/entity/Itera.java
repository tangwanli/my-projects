package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ly.fish_boom.enums.IteraEnum;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public class Itera implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer demandNum;

    private Integer defectNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creatDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private IteraEnum status;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getDemandNum() {
        return demandNum;
    }

    public void setDemandNum(Integer demandNum) {
        this.demandNum = demandNum;
    }
    public Integer getDefectNum() {
        return defectNum;
    }

    public void setDefectNum(Integer defectNum) {
        this.defectNum = defectNum;
    }
    public LocalDateTime getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDateTime creatDate) {
        this.creatDate = creatDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public IteraEnum getStatus() {
        return status;
    }

    public void setStatus(IteraEnum status) {
        this.status = status;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String DEMAND_NUM = "demand_num";

    public static final String DEFECT_NUM = "defect_num";

    public static final String CREAT_DATE = "creat_date";

    public static final String END_DATE = "end_date";

    public static final String STATUS = "status";

    public static final String CONTENT = "content";

    @Override
    public String toString() {
        return "Itera{" +
            "id=" + id +
            ", name=" + name +
            ", demandNum=" + demandNum +
            ", defectNum=" + defectNum +
            ", creatDate=" + creatDate +
            ", endDate=" + endDate +
            ", status=" + status +
            ", content=" + content +
        "}";
    }
}
