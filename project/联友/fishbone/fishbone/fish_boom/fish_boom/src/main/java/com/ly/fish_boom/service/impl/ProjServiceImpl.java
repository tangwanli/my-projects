package com.ly.fish_boom.service.impl;

import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.entity.UserGrou;
import com.ly.fish_boom.enums.ProjectTypeEnum;
import com.ly.fish_boom.mapper.OperaMapper;
import com.ly.fish_boom.mapper.ProjMapper;
import com.ly.fish_boom.mapper.TaskMapper;
import com.ly.fish_boom.mapper.UserMapper;
import com.ly.fish_boom.service.IGrouService;
import com.ly.fish_boom.service.IProjService;
import com.ly.fish_boom.service.IUserGrouService;
import com.ly.fish_boom.vo.ProjectVo;

import cn.hutool.core.lang.Console;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
public class ProjServiceImpl extends ServiceImpl<ProjMapper, Proj> implements IProjService {
	@Autowired
	private ProjMapper pm;
	@Autowired
	private UserMapper um;
	@Autowired
	private IUserGrouService iugs;
	@Autowired
	private IGrouService igs;
	@Autowired
	private TaskMapper tm;
	@Autowired
	private OperaMapper om;
	@Override
	@Transactional
	public Page<ProjectVo> projectList(Page<Proj> page,QueryWrapper<Proj> query) {
		List<Proj> pls=pm.selectPage(page,query).getRecords();
		List<ProjectVo> ls=new ArrayList<ProjectVo>();
		for(Proj p:pls) {
			//设置项目的进度
			if(p.getType()==ProjectTypeEnum.WATERFALL) {
				Console.log("进入瀑布项目修改进度");
				float finish=tm.selectCount(new QueryWrapper<Task>().eq("pid",p.getId()).and(i->i.eq("status",2)));
				float tatal=tm.selectCount(new QueryWrapper<Task>().eq("pid",p.getId()));
				int percent=(int)((finish/tatal)*100);
				Console.log(finish+"----"+tatal+"----"+percent);
				p.setPercent(percent+"%");
				pm.updateById(p);
			}
			ProjectVo pvo=new ProjectVo();
			BeanUtils.copyProperties(p, pvo);
			if(p.getcGid()!=null)
				pvo.setCc(getUsers(p.getcGid()));
			if(p.getPartnerGid()!=null)
				pvo.setPartner(getUsers(p.getPartnerGid()));
			if(p.getPmUid()!=null)
				pvo.setPm(getUserById(p.getPmUid()));
			ls.add(pvo);
		}
		Page<ProjectVo> voPage=new Page<ProjectVo>();
		BeanUtils.copyProperties(page, voPage);
		voPage.setRecords(ls);
		return voPage;
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
	@Override
	@Transactional
	public Integer creatProject(ProjectVo pvo) {
		Proj project=new Proj();
		BeanUtils.copyProperties(pvo, project);
		//设置人和组的对应关系
		//设置人
		if(pvo.getPm()!=null) {
			Integer pmid=pvo.getPm().getId();
			project.setPmUid(pmid);
		}
		List<User> cc=pvo.getCc();
		if(cc!=null) {
			Integer cGid=igs.addGroup(cc);
			project.setcGid(cGid);
		}
		List<User> partner=pvo.getPartner();
		if(partner!=null) {
			Integer partnerGid=igs.addGroup(partner);
			project.setPartnerGid(partnerGid);
		}
		project.setLastUpdate(LocalDateTime.now());
		this.save(project);
		return project.getId();
	}
	/** 
	 * @param pid
	 * @return
	 * @see com.ly.fish_boom.service.IProjService#deleteProject(java.lang.Integer)
	 * @author ly-lizhyi 2019年10月19日 下午2:41:10
	 * @version 1.0
	 */
	@Override
	@Transactional
	public boolean deleteProject(Integer pid) {
		Proj proj=pm.selectById(pid);
		//把对应的任务制空
		List<Task> tasks=tm.selectList(new QueryWrapper<Task>().eq("pid", pid));
		for(Task t:tasks) {
			t.setPid(null);
			tm.updateById(t);
			
		}
		//对应的评论也删了
			om.delete(new QueryWrapper<Opera>().eq("pid", pid));
		pm.deleteById(pid);
		Integer cGid=proj.getcGid();
		Integer pGid=proj.getPartnerGid();
		iugs.removeByGid(cGid);
		iugs.removeByGid(pGid);
		return true;
	}
	/** 
	 * @param id
	 * @return
	 * @see com.ly.fish_boom.service.IProjService#listOneById(java.lang.Integer)
	 * @author ly-lizhyi 2019年11月8日 下午5:53:56
	 * @version 1.0
	 */
	@Override
	@Transactional
	public ProjectVo listOneById(Integer id) {
		Proj p=this.getById(id);
		ProjectVo pvo=new ProjectVo();
		BeanUtils.copyProperties(p, pvo);
		pvo.setCc(getUsers(p.getcGid()));
		pvo.setPartner(getUsers(p.getPartnerGid()));
		pvo.setPm(getUserById(p.getPmUid()));
		return pvo;
	}

}
