package com.ly.fish_boom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.enums.IsMilestoneEnum;
import com.ly.fish_boom.enums.PercentEnum;
import com.ly.fish_boom.enums.TaskPriorityEnum;
import com.ly.fish_boom.enums.TaskStatusEnum;
import com.ly.fish_boom.enums.TaskTypeEnum;

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
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @MyLog(desc="任务名字")
    private String name;

    private String code;
    @MyLog(desc="任务类型")
    private TaskTypeEnum type;
    @MyLog(desc="任务内容")
    private String content;

    private Integer fGid;

    private Integer cGid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="任务创建时间")
    private LocalDateTime creatDate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="任务开始时间")
    private LocalDateTime startDate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="任务到期时间")
    private LocalDateTime endDate;
    @MyLog(desc="优先级")
    private TaskPriorityEnum priority;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @MyLog(desc="任务完成时间")
    private LocalDateTime finishDate;
    
    @MyLog(desc="任务进度")
    private PercentEnum percent;
    
    @MyLog(desc="任务状态")
    private TaskStatusEnum status;
    
    private String version;
    
    private String itera;

    private Integer pid;
    
    private String modal;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdate;

    private String creator;
    
    private IsMilestoneEnum isMilestone;

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public TaskTypeEnum getType() {
        return type;
    }

    public void setType(TaskTypeEnum type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getfGid() {
        return fGid;
    }

    public void setfGid(Integer fGid) {
        this.fGid = fGid;
    }
    public Integer getcGid() {
        return cGid;
    }

    public void setcGid(Integer cGid) {
        this.cGid = cGid;
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
    public TaskPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(TaskPriorityEnum priority) {
        this.priority = priority;
    }
    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
    	
    		this.status =status;
    }
    public String getVersion() {
        return version;
    }

    public PercentEnum getPercent() {
		return percent;
	}

	public void setPercent(PercentEnum percent) {
		this.percent = percent;
	}

	public void setVersion(String version) {
        this.version = version;
    }
    public String getItera() {
        return itera;
    }

    public void setItera(String itera) {
        this.itera = itera;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public IsMilestoneEnum getIsMilestone() {
        return isMilestone;
    }

    public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setIsMilestone(IsMilestoneEnum isMilestone) {
        this.isMilestone = isMilestone;
    }

    public static final String ID = "id";
  
    public static final String NAME = "name";

    public static final String CODE = "code";
  
    public static final String TYPE = "type";
   
    public static final String CONTENT = "content";

    public static final String F_GID = "f_gid";

    public static final String C_GID = "c_gid";
   
    public static final String CREAT_DATE = "creat_date";
   
    public static final String END_DATE = "end_date";
    
    public static final String PRIORITY = "priority";
    
    public static final String FINISH_DATE = "finish_date";
   
    public static final String STATUS = "status";
   
    public static final String VERSION = "version";
    
    public static final String ITERA = "itera";

    public static final String PID = "pid";
  
    public static final String MODAL = "modal";
   
    public static final String LAST_UPDATE = "last_update";

    public static final String CREATOR = "creator";
    
    public static final String PERCENT = "percent";
    
    public static final String IS_MILESTONE = "is_milestone";

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", name=" + name +
            ", code=" + code +
            ", type=" + type +
            ", content=" + content +
            ", fGid=" + fGid +
            ", cGid=" + cGid +
            ", creatDate=" + creatDate +
            ", endDate=" + endDate +
            ", priority=" + priority +
            ", finishDate=" + finishDate +
            ", percent=" + percent +
            ", status=" + status +
            ", version=" + version +
            ", itera=" + itera +
            ", pid=" + pid +
            ", modal=" + modal +
            ", lastUpdate=" + lastUpdate +
            ", creator=" + creator +
            ", isMilestone=" + isMilestone +
        "}";
    }

}
