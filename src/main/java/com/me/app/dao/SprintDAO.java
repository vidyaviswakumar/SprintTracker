package com.me.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Sprint;
import com.me.app.pojo.User;

public class SprintDAO extends DAO{

	public List<Sprint> get(){
		List<Sprint> sprintList=null;
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Sprint");			
			sprintList=q.list();
			commit();
			close();
			
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return sprintList;
	}
	
	public boolean insert(String sprintName){
		
		boolean isInserted=false;
		try{
			
			begin();
			Sprint sprint = new Sprint(sprintName);
			getSession().save(sprint);
			isInserted=true;
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return isInserted;
	}

	public int getSprintId(String sprintName){
		int sprintId=0;
		try{
			
			begin();
			Query q=getSession().createQuery("select sprintId from Story where sprintName=:sprintName");
			q.setString("sprintName", sprintName);				
			sprintId=(Integer)q.uniqueResult();
			commit();
			close();
			
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return sprintId;
	}
	
	public Sprint getSprint(String sprintId){
		Sprint sprint=new Sprint();
		try{
			
			begin();
			Query q=getSession().createQuery("from Sprint where sprintId=:sprintid");
			q.setString("sprintid", sprintId);				
			sprint=(Sprint)q.uniqueResult();
			commit();
			close();
			
			
		}catch(HibernateException ex){
			rollback();
		}
		return sprint;
		
	}
	
	public void save(Sprint sprint){
        try {
            begin();
            getSession().update(sprint);
            commit();
        } catch (HibernateException e) {
            rollback();
            
        }
    }
}
