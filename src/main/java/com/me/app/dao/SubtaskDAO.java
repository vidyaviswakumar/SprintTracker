package com.me.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Story;
import com.me.app.pojo.Subtask;
import com.me.app.pojo.User;

public class SubtaskDAO  extends DAO{

	public List<Subtask> get(int storyId){
		
		List<Subtask> subtaskList=new ArrayList<Subtask>();
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Subtask where storyId=:storyId"); 
			q.setInteger("storyId", storyId);
						
			commit();
			close();
			
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return subtaskList;
	}
	
	public boolean insert(Subtask subtask){
		boolean isSaved=false;
		try{
			getSession().save(subtask);
			
			commit();
			close();
			isSaved=true;
			
		}catch(HibernateException ex){
			rollback();
			close();
		}
		
		
		return isSaved;
	}

}
