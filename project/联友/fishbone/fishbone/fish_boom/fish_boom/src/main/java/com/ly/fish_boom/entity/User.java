package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String acco;

    private String name;
    
    @JsonIgnore
    @JsonDeserialize
    private String password;
    @JsonIgnore
    private String salt;
    
    private String dept;

    private String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getAcco() {
        return acco;
    }

    public void setAcco(String acco) {
        this.acco = acco;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static final String ID = "id";

    public static final String ACCO = "acco";

    public static final String NAME = "name";

    public static final String PASSWORD = "password";

    public static final String SALT = "salt";

    public static final String DEPT = "dept";

    public static final String POSITION = "position";

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", acco=" + acco +
            ", name=" + name +
            ", password=" + password +
            ", salt=" + salt +
            ", dept=" + dept +
            ", position=" + position +
        "}";
    }
}
