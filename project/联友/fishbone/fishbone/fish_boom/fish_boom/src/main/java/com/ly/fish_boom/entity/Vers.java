package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Vers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String name;

    private Integer demandNum;

    private Integer defectNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creatDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private Integer status;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final String ID = "id";

    public static final String PID = "pid";

    public static final String NAME = "name";

    public static final String DEMAND_NUM = "demand_num";

    public static final String DEFECT_NUM = "defect_num";

    public static final String CREAT_DATE = "creat_date";

    public static final String END_DATE = "end_date";

    public static final String STATUS = "status";

    public static final String CONTENT = "content";

    @Override
    public String toString() {
        return "Vers{" +
            "id=" + id +
            ", pid=" + pid +
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
