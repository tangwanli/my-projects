package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.enums.IsControlEnum;
import com.ly.fish_boom.enums.PercentEnum;
import com.ly.fish_boom.enums.ProjPriorityEnum;
import com.ly.fish_boom.enums.ProjectTypeEnum;

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
public class Proj implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String creator;

    private Integer pmUid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="项目创建时间")
    private LocalDateTime creatDate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="项目到期时间")
    private LocalDateTime startDate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="项目到期时间")
    private LocalDateTime endDate;
    @MyLog(desc="项目优先级")
    private ProjPriorityEnum priority;

    private Integer partnerGid;

    private Integer cGid;
    @MyLog(desc="项目描述")
    private String content;
    @MyLog(desc="项目进度")
    private String percent;
    @MyLog(desc="项目类型")
    private ProjectTypeEnum type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="项目最后更新时间")
    private LocalDateTime lastUpdate;

    private String code;

    private IsControlEnum isControl;

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
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Integer getPmUid() {
        return pmUid;
    }

    public void setPmUid(Integer pmUid) {
        this.pmUid = pmUid;
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
    public ProjPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(ProjPriorityEnum priority) {
        this.priority = priority;
    }
    public Integer getPartnerGid() {
        return partnerGid;
    }

    public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setPartnerGid(Integer partnerGid) {
        this.partnerGid = partnerGid;
    }
    public Integer getcGid() {
        return cGid;
    }

    public void setcGid(Integer cGid) {
        this.cGid = cGid;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
    public ProjectTypeEnum getType() {
        return type;
    }

    public void setType(ProjectTypeEnum type) {
        this.type = type;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public IsControlEnum getIsControl() {
        return isControl;
    }

    public void setIsControl(IsControlEnum isControl) {
        this.isControl = isControl;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String CREATOR = "creator";

    public static final String PM_UID = "pm_uid";

    public static final String CREAT_DATE = "creat_date";

    public static final String END_DATE = "end_date";

    public static final String PRIORITY = "priority";

    public static final String PARTNER_GID = "partner_gid";

    public static final String C_GID = "c_gid";

    public static final String CONTENT = "content";

    public static final String PERCENT = "percent";

    public static final String TYPE = "type";

    public static final String LAST_UPDATE = "last_update";

    public static final String CODE = "code";

    public static final String IS_CONTROL = "is_control";

    @Override
    public String toString() {
        return "Proj{" +
            "id=" + id +
            ", name=" + name +
            ", creator=" + creator +
            ", pmUid=" + pmUid +
            ", creatDate=" + creatDate +
            ", endDate=" + endDate +
            ", priority=" + priority +
            ", partnerGid=" + partnerGid +
            ", cGid=" + cGid +
            ", content=" + content +
            ", percent=" + percent +
            ", type=" + type +
            ", lastUpdate=" + lastUpdate +
            ", code=" + code +
            ", isControl=" + isControl +
        "}";
    }
}
