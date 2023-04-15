
package com.ly.fish_boom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminPageController {
	@GetMapping(value="/admin")
	public String admin(){
	    return "redirect:admin_user_list";
	}
	@RequestMapping("/admin_user_list")
	public String listUser(){
		return "admin/listuser";

	}
	@RequestMapping("/admin_proj_list")
	public String listProject() {
		return "index";
	}

}

