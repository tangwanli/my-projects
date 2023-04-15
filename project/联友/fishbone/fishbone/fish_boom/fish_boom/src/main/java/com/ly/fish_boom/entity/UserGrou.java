package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public class UserGrou implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer gid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public static final String ID = "id";

    public static final String UID = "uid";

    public static final String GID = "gid";

    @Override
    public String toString() {
        return "UserGrou{" +
            "id=" + id +
            ", uid=" + uid +
            ", gid=" + gid +
        "}";
    }
}
