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
public class Doc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    private String content;

    private Integer tid;
    
    private String size;
    
    private String creator;
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
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public static final String ID = "id";

    public static final String PID = "pid";

    public static final String NAME = "name";

    public static final String UPDATE_DATE = "update_date";

    public static final String CONTENT = "content";

    public static final String TID = "tid";

    @Override
    public String toString() {
        return "Doc{" +
            "id=" + id +
            ", pid=" + pid +
            ", name=" + name +
            ", updateDate=" + updateDate +
            ", content=" + content +
            ", tid=" + tid +
        "}";
    }
}
