package com.me.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.app.dao.SprintDAO;
import com.me.app.dao.StatusDAO;
import com.me.app.dao.StoryDAO;
import com.me.app.dao.SubtaskDAO;
import com.me.app.dao.UserDAO;
import com.me.app.pojo.Sprint;
import com.me.app.pojo.Status;
import com.me.app.pojo.Story;
import com.me.app.pojo.Subtask;
import com.me.app.pojo.User;

@Controller
@Scope("session")
public class CommonController {

	@Autowired
	@Qualifier("sprintDao")
	SprintDAO sprintDao;
	
	@RequestMapping(value = "sprint.htm", method = RequestMethod.GET)
	public ModelAndView getStories(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("user")!=null){
		String sprintId=request.getParameter("sprint");
		session.setAttribute("sprintId",request.getParameter("sprint"));
			Sprint sprint= new Sprint();
			sprint = sprintDao.getSprint(sprintId);	
			User user=(User)session.getAttribute("user");
			if(user!=null){
			if( !user.getRole().getRoleName().equalsIgnoreCase("scrum-master")){
				mv.setViewName("stories");
			}
			else{
				mv.setViewName("storiesScrum");
			}
			}
			mv.addObject(sprint);
		}else{
			mv.setViewName("reLogin");
		}
	
		
		
		return mv;
	}
	
	@Autowired
	@Qualifier("statusDao")
	StatusDAO statusDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	@RequestMapping(value="sprint.htm",method=RequestMethod.POST)
	public String getHomePage(@ModelAttribute("story")Story story,HttpSession session,HttpServletRequest request){
		
		User user=(User)session.getAttribute("user");
		String sprintId=(String)session.getAttribute("sprintId");
		Sprint sprint=sprintDao.getSprint(sprintId);
		story.setSprintId(sprint);
		story.setCreatedBy(user);
		
		Status status=statusDao.getStatus(story.getStatusName());
		story.setStatus(status);
		story.setAssignedTo(userDao.getUserFrom(story.getUsername()));
		storyDao.insert(story);				
		sprintDao.save(sprint);
		request.setAttribute("sprintList", sprintDao.get());
		
		return "createSprint";
	}
	
	
	@Autowired
	@Qualifier("storyDao")
	StoryDAO storyDao;
	@RequestMapping(value = "story.htm", method = RequestMethod.GET)
	public ModelAndView getSubtasks(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("user")!=null){
		String storyId=request.getParameter("story");
		
		Story story= new Story();
		story = storyDao.getStory(storyId);			
		mv.addObject(story);
		mv.setViewName("subtasks");
		
		request.getSession(false).setAttribute("storyId", storyId);
		}else{
			mv.setViewName("reLogin");
		}
		return mv;
	}
	
	@Autowired
	@Qualifier("subtaskDao")
	SubtaskDAO subtaskDao;
	@RequestMapping(value="subtasks.htm",method=RequestMethod.POST)
	public ModelAndView getHomePage1(@ModelAttribute("subtask")Subtask subtask,HttpSession session,HttpServletRequest request){
		
		
		User user=(User)session.getAttribute("user");
		String storyId=(String)session.getAttribute("storyId");
		Story story=storyDao.getStory(storyId);
		
		subtask.setStoryId(story);
		subtask.setCreatedBy(user);		
		Status status=statusDao.getStatus(subtask.getStatusName());
		subtask.setStatus(status);
		if(user.getRole().getRoleName().equalsIgnoreCase("qa")){
			subtask.setIsDefect("Yes");
		}
		else{
			subtask.setIsDefect("No");
		}
		subtask.setAssignedTo(userDao.getUserFrom(subtask.getUsername()));
		subtaskDao.insert(subtask);			
		storyDao.save(story);
		String sprintId=(String)session.getAttribute("sprintId");
		
		request.setAttribute("storyList", storyDao.getStoryList(sprintId));
		List<Sprint> sprints=sprintDao.get();
		ModelAndView mv=new ModelAndView();
		mv.addObject(sprints);
		mv.setViewName("home");
		return mv;
		
	}
	
	@RequestMapping(value="subtasks.htm", method=RequestMethod.GET)
	public String storyCrea12(HttpServletRequest request,HttpSession session){
		return "reLogin";
	
	}
	
	@RequestMapping(value="loginUser.htm", method=RequestMethod.GET)
	public String storyCrea123(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("user")!=null){
			return "home";
		}
		return "reLogin";
	
	}
	}
	
	
