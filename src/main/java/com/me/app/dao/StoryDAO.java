package com.me.app.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Sprint;
import com.me.app.pojo.Story;
import com.me.app.pojo.User;

public class StoryDAO extends DAO{
	
	public boolean insert(Story story){
		boolean isSaved=false;
		try{
			getSession().save(story);
			
			commit();
			close();
			isSaved=true;
			
		}catch(HibernateException ex){
			rollback();
			close();
		}
		
		
		return isSaved;
	}
	
	public List<Story> getStoryList(String sprintId){
		
		List<Story> storyList=new ArrayList<Story>();
		try{
			
			begin();			
			Query q=getSession().createQuery("from Story where sprintId=:sprintId");
			q.setString("sprintId", sprintId);				
			storyList=q.list();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return storyList;
	}
	
	
	public Story getStory(String storyId){
		Story story=new Story();
		try{
			
			begin();
			Query q=getSession().createQuery("from Story where storyId=:storyid");
			q.setString("storyid", storyId);				
			story=(Story)q.uniqueResult();
			commit();
			close();
			
			
		}catch(HibernateException ex){
			rollback();
		}
		return story;
		
	}
	
	public void save(Story story){
        try {
            begin();
            getSession().update(story);
            commit();
        } catch (HibernateException e) {
            rollback();
            
        }
    }

	
}
