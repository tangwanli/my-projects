package com.ly.fish_boom.service.impl;

import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.entity.UserGrou;
import com.ly.fish_boom.mapper.GrouMapper;
import com.ly.fish_boom.mapper.ProjMapper;
import com.ly.fish_boom.mapper.TaskMapper;
import com.ly.fish_boom.mapper.UserGrouMapper;
import com.ly.fish_boom.mapper.UserMapper;
import com.ly.fish_boom.service.IGrouService;
import com.ly.fish_boom.service.IOperaService;
import com.ly.fish_boom.service.IProjService;
import com.ly.fish_boom.service.ITaskService;
import com.ly.fish_boom.service.IUserGrouService;
import com.ly.fish_boom.vo.TaskVo;

import cn.hutool.core.lang.Console;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {
	@Autowired
	private UserMapper um;
	@Autowired
	private IGrouService igs;
	@Autowired
	private IUserGrouService iugs;
	@Autowired
	private ProjMapper pm;
	@Autowired
	private IOperaService ios;
	@Autowired
	private IProjService ips;
	/** 
	 * @param page
	 * @param items
	 * @return
	 * @see com.ly.fish_boom.service.ITaskService#projectList(com.baomidou.mybatisplus.extension.plugins.pagination.Page, java.util.List)
	 * @author ly-lizhyi 2019年10月17日 上午11:35:11
	 * @version 1.0
	 */
	@Override
	public Page<TaskVo> taskList(Page<Task> page,QueryWrapper<Task> query) {
		List<Task> tls=this.page(page,query).getRecords();
		List<TaskVo> tvls=new ArrayList<TaskVo>();
		for(Task t:tls) {
			TaskVo tv=new TaskVo();
			BeanUtils.copyProperties(t, tv);
			tv.setFf(getUsers(t.getfGid()));
			tv.setCc(getUsers(t.getcGid()));
			if(t.getPid()!=null)
				tv.setProject(ips.listOneById(t.getPid()));
			tvls.add(tv);
			}
		Page<TaskVo> pageVo=new Page<TaskVo>();
		BeanUtils.copyProperties(new Page<Task>(), pageVo);
		return pageVo.setRecords(tvls);
	}
	private User getUserById(Integer uid) {
		return um.selectById(uid);
	}
	private List<User> getUsers(Integer gid){
		QueryWrapper<UserGrou> query=new QueryWrapper<>();
		query.eq("gid", gid);
		List<UserGrou> ugls=iugs.list(query);
		Set<User> userSet=new TreeSet<>(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getId()-o2.getId();
			}
		});
		for(UserGrou ug:ugls) {
			User u=getUserById(ug.getUid());
			userSet.add(u);
		}
		List<User> ls=new ArrayList<User>();
		ls.addAll(userSet);
		return ls;
	}
	/** 
	 * @param tvo
	 * @param session
	 * @return
	 * @see com.ly.fish_boom.service.ITaskService#creatProject(com.ly.fish_boom.vo.TaskVo, javax.servlet.http.HttpSession)
	 * @author ly-lizhyi 2019年10月19日 上午10:25:28
	 * @version 1.0
	 */
	@Override
	@Transactional
	public int addTask(TaskVo tvo) {
		
		Task t=new Task();
		BeanUtils.copyProperties(tvo, t);
		if(tvo.getCc().size()>0) {
			Integer cGid=igs.addGroup(tvo.getCc());
			t.setcGid(cGid);
		}
		if(tvo.getFf().size()>0) {
			Integer fGid=igs.addGroup(tvo.getFf());
			t.setfGid(fGid);
		}
		if(tvo.getProject()!=null) {
			Integer pid=tvo.getProject().getId();
			t.setPid(pid);
		}
		this.save(t);
		return t.getId();
	}
	/** 
	 * @param tid
	 * @return
	 * @see com.ly.fish_boom.service.ITaskService#remove(java.lang.Integer)
	 * @author ly-lizhyi 2019年10月19日 下午2:28:21
	 * @version 1.0
	 */
	@Override
	@Transactional
	public boolean remove(Integer tid) {
		Task t=super.getById(tid);
		Integer fid=t.getfGid();
		Integer cid=t.getcGid();
		ios.remove(new QueryWrapper<Opera>().eq("tid", tid));
		super.removeById(tid);
		iugs.remove(new QueryWrapper<UserGrou>().eq("gid", fid).or().eq("gid", cid));
		return true;
	}

}
