package com.ly.fish_boom.controller;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.fish_boom.entity.Doc;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IDocService;
import com.ly.fish_boom.service.IProjService;
import com.ly.fish_boom.util.Result;
import cn.hutool.core.lang.Console;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/doc")
public class DocController {
	@Autowired
	private IDocService ids;
	@Autowired
	private IProjService ips;
	@PostMapping("/upload")
	public Result add(Integer id,MultipartFile file,HttpServletRequest request,String content,HttpSession session) {
		if(file==null)
			return Result.fail("文件不能为空");
		String projName=ips.getById(id).getName();
		File root=new File(request.getServletContext().getRealPath("upload"));
		File fileFolder=new File(root,projName);
		File descFile=new File(fileFolder,file.getOriginalFilename());
		if(!descFile.getParentFile().exists())
			descFile.getParentFile().mkdirs();
		if(descFile.exists())
			return Result.fail("项目中已存在该文件，请修改文件名或先删除原文件");
		try {
			file.transferTo(descFile);
			User u=(User)session.getAttribute("user");
			Doc d=new Doc();
			d.setContent(content);
			d.setName(file.getOriginalFilename());
			//这里说制作项目的文件
			d.setPid(id);
			d.setUpdateDate(LocalDateTime.now());
			d.setCreator(u.getName());
			d.setSize(Long.toString(descFile.length()));
			ids.save(d);
		} catch (IOException e) {
			e.printStackTrace();
			return Result.fail("上传失败");
		}
		
		return Result.success();
	}
	@GetMapping("/list")
	public Result list(Integer id) {
		List<Doc> docs=ids.list(new QueryWrapper<Doc>().eq("pid", id));
		
		return Result.success(docs);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam(value="id",required=true)String id,Integer pid,HttpServletRequest request) {
		String proName="";
		try {
			proName=ips.getById(pid).getName();
		} catch (Exception e) {
			return Result.fail("项目ID不对");
		}
		String[] deal=id.split(",");
		Map<String,File> map=new HashMap<String,File>(); 
		try {
			for(String d:deal) {
				String docName=ids.getById(d).getName();
				map.put(d,new File(request.getServletContext().getRealPath("upload/"+proName+"/"+docName)));
			}
			Set<Entry<String,File>> s=map.entrySet();
			for(Entry<String,File> entry:s) {
				ids.removeById(entry.getKey());
				entry.getValue().delete();
			}
				
		} catch (Exception e) {
			return Result.fail("删除失败,可能文件已经不存在");
		}
		return Result.success();
	}
	
}
