package com.me.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Person;
import com.me.app.pojo.Role;
import com.me.app.pojo.User;




public class UserDAO extends DAO{
	
	public UserDAO(){}
	public User get(User user){
		
		User loggedInUser=null;
		try{
			
			begin();
			Query q=getSession().createQuery("from User where username= :username and password= :password");
			q.setString("username", user.getUsername());
			q.setString("password", user.getPassword());			
			loggedInUser=(User)q.uniqueResult();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return loggedInUser;
	}
	
public boolean get(String username,String password){
		
	boolean isUser=false;
	try{
		
		begin();
		Query q=getSession().createQuery("from User where username= :username and password= :password");
		q.setString("username", username);
		q.setString("password", password);			
		User loggedInUser=(User)q.uniqueResult();
		if(loggedInUser!=null)
			isUser=true;
		commit();
		close();
		
	}catch(HibernateException ex){
		rollback();
	}
	
	return isUser;
	}
	
	public User insert(User userInputs){
		RoleDAO roleDao=new RoleDAO();
		
		
		
		User user=new User();
		user.setRole(roleDao.getRole(userInputs.getRoleName()));
		try{
			
			begin();			
			user.setUsername(userInputs.getUsername());
			user.setPassword(userInputs.getPassword());
			user.setFirstName(userInputs.getFirstName());
			user.setLastName(userInputs.getLastName());
			user.setEmailId(userInputs.getEmailId());
			System.out.println(userInputs.getRole());
			
			
			user.setIsAuthorized("false");
			getSession().save(user);
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return user;
	}
	
	public boolean checkUsername(String username){
		boolean isNewUsername=true;
		
		try{
			
			begin();
			Query q=getSession().createQuery("from User where username= :username");
			q.setString("username", username);
						
			User user=(User)q.uniqueResult();
			if(user!=null)
				isNewUsername=false;
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return isNewUsername;
	}
	
	public List<User> getUnauthorizedUsers(){
		List<User> users=null;	
		try{
			
			begin();
			Query q=getSession().createQuery("from User where isAuthorized= :authorize");
			q.setString("authorize", "false");				
			users=q.list();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return users;
	}
	
	public List<User> getAuthorizedUsers(){
		List<User> users=null;	
		try{
			
			begin();
			Query q=getSession().createQuery("from User where isAuthorized= :authorize");
			q.setString("authorize", "true");				
			users=q.list();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		
		return users;
	}
	
	public Person getPersonDetails(User user){
		
		Person person=new Person();
		try{
			
			begin();
			Query q=getSession().createQuery("from Person where personId= :personId");
			q.setInteger("personId", user.getPersonId());				
			person=(Person)q.uniqueResult();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		return person;
	}
	
public User getUserFrom(String username){
		
		User user=new User();
		try{
			
			begin();
			Query q=getSession().createQuery("from User where username= :username");
			q.setString("username", username);				
			user=(User)q.uniqueResult();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		return user;
	}
	
	public boolean authorizeUser(String personId){
		boolean isAuthorized=false;
		try{
			
			begin();
			User user=new User();
			Query q=getSession().createQuery("from User where personId= :personId");
			q.setString("personId", personId);				
			user=(User)q.uniqueResult();
			user.setIsAuthorized("true");
			isAuthorized=true;
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		return isAuthorized;
	}
	

}
