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
public class Opera implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private Integer tid;

    private String creator;

    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creatTime;

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
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public static final String ID = "id";

    public static final String PID = "pid";

    public static final String TID = "tid";

    public static final String CREATOR = "creator";

    public static final String CONTENT = "content";

    public static final String CREAT_TIME = "creat_time";

    @Override
    public String toString() {
        return "Opera{" +
            "id=" + id +
            ", pid=" + pid +
            ", tid=" + tid +
            ", creator=" + creator +
            ", content=" + content +
            ", creatTime=" + creatTime +
        "}";
    }
}
