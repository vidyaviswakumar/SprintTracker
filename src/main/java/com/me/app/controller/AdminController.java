package com.me.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.app.dao.SprintDAO;
import com.me.app.dao.UserDAO;
import com.me.app.pojo.Person;
import com.me.app.pojo.Sprint;
import com.me.app.pojo.User;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@RequestMapping(value="listOfUser.htm", method=RequestMethod.POST)
	public String successCreate(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("user")!=null){
		List<Person> persons=new ArrayList<Person>();
		for(User user:userDao.getUnauthorizedUsers()){
			persons.add(userDao.getPersonDetails(user));		
		}
		request.setAttribute("unAuth",persons);		
		
		return "listUsers";
		}
		return "login";
	
	}
	
	@RequestMapping(value="listOfUser.htm", method=RequestMethod.GET)
	public String yescreate(HttpServletRequest request,HttpSession session){
		return "reLogin";
	
	}
	
	@Autowired
	@Qualifier("sprintDao")
	SprintDAO sprintDao;
	@RequestMapping(value="authorized.htm", method=RequestMethod.POST)
	public ModelAndView authorized(HttpServletRequest request,HttpSession session){
		
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("user")!=null){
		String personId=request.getParameter("person");		
		if(userDao.authorizeUser(personId)){	
		Sprint sprint=new Sprint();		
		request.setAttribute("sprintList", sprintDao.get());
		mv.addObject(sprint);
		}
		mv.setViewName("authorize");
		}else{
			mv.setViewName("login");
		}
		return mv;
		
		
	
	}
	@RequestMapping(value="authorized.htm", method=RequestMethod.GET)
	public String authorized1(HttpServletRequest request,HttpSession session){
		return "reLogin";
	
	}
	
	
	
}