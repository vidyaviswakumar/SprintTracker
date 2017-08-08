package com.me.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Status;
import com.me.app.pojo.User;

public class StatusDAO extends DAO{

	public List<Status> getQAStatus(){

		List<Status> statuses=new ArrayList<Status>();
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Status where statusId not in (7,3)");
			statuses=q.list();
			commit();
			close();
						
		}catch(HibernateException ex){
			rollback();
		}
		
		return statuses;
	}
	

	public List<Status> get(){

		List<Status> statuses=new ArrayList<Status>();
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Status where statusId not in (6,4)");
			statuses=q.list();
			commit();
			close();
						
		}catch(HibernateException ex){
			rollback();
		}
		
		return statuses;
	}
	
	public List<Status> getStoryStatus(){

		List<Status> statuses=new ArrayList<Status>();
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Status where statusId not in (3,7,6)");
			statuses=q.list();
			commit();
			close();
						
		}catch(HibernateException ex){
			rollback();
		}
		
		return statuses;
	}
	
	public Status getStatus(String statusName){

		Status status=new Status();
		
		try{
			
			begin();
			Query q=getSession().createQuery("from Status where statusName=:statusName");
			q.setString("statusName", statusName);
			status=(Status)q.uniqueResult();
			commit();
			close();
						
		}catch(HibernateException ex){
			rollback();
		}
		
		return status;
	}
	
	public User insert(String firstName,String lastName,String role,String emailId,String username,String password){
		
		User user=new User();
		try{
			
			begin();			
			user.setUsername(username);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(emailId);
			
			getSession().save(user);
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return user;
	}

	
}
