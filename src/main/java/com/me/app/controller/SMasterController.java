package com.me.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.me.app.dao.RoleDAO;
import com.me.app.dao.SprintDAO;
import com.me.app.dao.StatusDAO;
import com.me.app.dao.StoryDAO;
import com.me.app.dao.UserDAO;
import com.me.app.pojo.Sprint;
import com.me.app.pojo.Story;
import com.me.app.pojo.Subtask;
import com.me.app.pojo.User;
import com.me.app.springView.PdfReportView;


@Controller
public class SMasterController {
		
	@Autowired
	@Qualifier("sprintDao")
	SprintDAO sprintDao;
		@RequestMapping(value="successSprint.htm", method=RequestMethod.POST)
		public ModelAndView successCreate(@ModelAttribute("sprint")Sprint sprint,BindingResult result,HttpServletRequest request){
			
			ModelAndView mv=new ModelAndView();
			
			if(sprintDao.insert(sprint.getSprintName())){		
				
			request.setAttribute("sprintList", sprintDao.get());
			
			
				mv.addObject(sprint);
				mv.setViewName("createSprint");
			}else{
				mv.setViewName("error");
			}
			
			
			return mv;
		
		}
		
		@RequestMapping(value="successSprint.htm", method=RequestMethod.GET)
		public String authorized1(HttpServletRequest request,HttpSession session){
			return "reLogin";
		
		}
		
		
		@RequestMapping(value="insert.htm", method=RequestMethod.POST)
		public ModelAndView insert(){
			ModelAndView mv=new ModelAndView();
			Sprint sprint= new Sprint();
			mv.addObject(sprint);
			mv.setViewName("newSprint");
			return mv;
		
		}
		
		@RequestMapping(value="insert.htm", method=RequestMethod.GET)
		public String insert1(HttpServletRequest request,HttpSession session){
			return "reLogin";
		
		}
	
		@Autowired
		@Qualifier("userDao")
		UserDAO userDao;
		
		@Autowired
		@Qualifier("statusDao")
		StatusDAO statusDao;
		@RequestMapping(method=RequestMethod.POST, value="storycreate.htm")
		public ModelAndView createStory(HttpServletRequest request,HttpSession session){
			ModelAndView mv=new ModelAndView();
			Story story= new Story();
			mv.addObject(story);
			
			request.setAttribute("status",statusDao.getStoryStatus());
			
			request.setAttribute("user",userDao.getAuthorizedUsers());
						
			mv.setViewName("storyCreation");
			return mv;
		}
		
		@RequestMapping(value="storycreate.htm", method=RequestMethod.GET)
		public String storyCrea(HttpServletRequest request,HttpSession session){
			return "reLogin";
		
		}
		
		@RequestMapping(method=RequestMethod.POST, value="subtaskcreate.htm")
		public ModelAndView createSubtask(HttpServletRequest request,HttpSession session){
			ModelAndView mv=new ModelAndView();
						
			request.setAttribute("storyId",request.getParameter("storyId"));
			Subtask subtask= new Subtask();
			mv.addObject(subtask);
			
			User user=(User)session.getAttribute("user");
			if(user.getRole().getRoleName().equalsIgnoreCase("qa")){
				request.setAttribute("status",statusDao.getQAStatus());
			}
			else{
				request.setAttribute("status",statusDao.get());
			}
			
			request.setAttribute("user",userDao.getAuthorizedUsers());
						
			mv.setViewName("subtaskCreation");
			return mv;
		}
		
		@RequestMapping(value="subtaskcreate.htm", method=RequestMethod.GET)
		public String storyCrea1(HttpServletRequest request,HttpSession session){
			return "reLogin";
		
		}
		
		@Autowired
		@Qualifier("storyDao")
		StoryDAO storyDao;
		@RequestMapping(value = "report.htm", method = RequestMethod.POST)
		public ModelAndView registerPage(HttpServletRequest request,HttpSession session) {
			
			View view = new PdfReportView();
			Map<String,String> storyData=new HashMap<String, String>();
			
			String sprintId=(String)session.getAttribute("sprintId");
			List<Story> stories=storyDao.getStoryList(sprintId);
			for(Story story: stories){
				storyData.put(story.getStoryTitle(), story.getStatus().getStatusName());
			}
			
			return new ModelAndView(view,"storyData", storyData);

		}

		@RequestMapping(value="report.htm", method=RequestMethod.GET)
		public String report1(HttpServletRequest request,HttpSession session){
			return "reLogin";
		
		}
}
