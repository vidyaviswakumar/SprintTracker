package com.me.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.app.pojo.Role;
import com.me.app.pojo.User;

public class RoleDAO extends DAO{


	
	public List<Role> getRoles(){
		List<Role> rolelist=new ArrayList<Role>();
			try{
			
			begin();			
			Query q=getSession().createQuery("from Role where roleName!=:rolename");
			q.setString("rolename", "admin");
			
			rolelist= q.list();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return rolelist;
	}
	
	
	public Role getRole(String rolename){
		Role role=new Role();
			try{
			
			begin();			
			Query q=getSession().createQuery("from Role where roleName=:rolename");
			q.setString("rolename", rolename);
			role=(Role)q.uniqueResult();
			commit();
			close();
			
		}catch(HibernateException ex){
			rollback();
		}
		close();
		
		return role;
	}
	
}
