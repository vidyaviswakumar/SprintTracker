package com.me.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.app.dao.RoleDAO;
import com.me.app.dao.SprintDAO;
import com.me.app.dao.StoryDAO;
import com.me.app.dao.UserDAO;
import com.me.app.pojo.Sprint;
import com.me.app.pojo.Story;
import com.me.app.pojo.User;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String getUser(@ModelAttribute("user")User user,BindingResult result){
		
		
		return "index";
	}
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	@RequestMapping(value = "ajax.htm", method = RequestMethod.POST)
	public void checkUser(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletResponse response){
		

		
		PrintWriter out;
		try {
			out = response.getWriter();
			if(userDao.get(username, password)){
				out.print("success");
			}
			else{
				out.print("error");
			}
				
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	@Autowired
	@Qualifier("sprintDao")
	SprintDAO sprintDao;
	@RequestMapping(value = "loginUser.htm", method = RequestMethod.POST)
	public ModelAndView home(@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		
		String val=user.getIsAuthorized();
		User loggedInUser=userDao.get(user);
		if(loggedInUser!=null){
			//request.setAttribute("user", loggedInUser);
			request.getSession(false).setAttribute("user", loggedInUser);
			Sprint sprint = new Sprint();
			if(loggedInUser.getIsAuthorized().equals("false")){
				
				mv.setViewName("unauthorized");
				return mv;
			}
			List<Sprint> sprintList=sprintDao.get();
			request.setAttribute("sprintList", sprintList);
			HttpSession session=request.getSession(false);
					session.setAttribute("sprintList", sprintList);
			if(loggedInUser.getRole().getRoleName().equalsIgnoreCase("scrum-master")){
				mv.addObject(sprint);
				mv.setViewName("createSprint");
			}
			else if(loggedInUser.getRole().getRoleName().equalsIgnoreCase("admin")){
				mv.addObject(sprint);
				mv.setViewName("authorize");
			}
			else{
			mv.addObject(sprint);
			mv.setViewName("home");
			}
			
		}
		else{
			mv.setViewName("error");
		}
		return mv;
	}
	
	
	@Autowired
	@Qualifier("roleDao")
	RoleDAO roleDao;
	@RequestMapping(value = "register.htm", method = RequestMethod.GET)
	public String registerPage(@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request) {
		
		
		request.setAttribute("roles", roleDao.getRoles());
		return "register";
	}
	

	@RequestMapping(value = "home.htm", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user,BindingResult result) {
		
		if(result.hasErrors())
		{
			return "register";
		}
		
		if(userDao.checkUsername(user.getUsername()))
			userDao.insert(user);
		else
			return "error";
		
		return "unauthorized";
	}
	
	@RequestMapping(value="home.htm", method=RequestMethod.GET)
	public String home1(HttpServletRequest request,HttpSession session){
		return "reLogin";
	
	}
	

	@RequestMapping(value = "logout.htm")
	public String logout(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);
		if(session!=null)
			 session.invalidate();
		
		return "logout";
	}
	}
