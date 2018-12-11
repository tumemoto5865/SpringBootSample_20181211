package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/sample", method = RequestMethod.GET)
	String index(Model model) {
	    List<User> list = jdbcTemplate.queryForObject("select * from java_user.user", new UserMapper());
	    model.addAttribute("list", list);
	    return "sample/index";
	}

	@RequestMapping(path = "/member", method = RequestMethod.GET)
	String member(Model model) {
	    return "/sample/member";
	}
	
	@RequestMapping(path = "/member", method = RequestMethod.POST)
	String memberReg(Model model, @ModelAttribute  UserForm userForm ) {
		jdbcTemplate.update("INSERT INTO java_user.user(name,nm_add,nk_tel) VALUES(?,?,?)",userForm.getName(),userForm.getNm_add(),userForm.getNk_tel());
	    List<User> list = jdbcTemplate.queryForObject("select * from java_user.user", new UserMapper());
	    model.addAttribute("list", list);
		return "/sample/index";
	}

}
