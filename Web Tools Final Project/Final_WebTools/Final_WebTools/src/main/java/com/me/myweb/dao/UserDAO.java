package com.me.myweb.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.Artical;
import com.me.myweb.pojo.User;


public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where personID= :personID");
			q.setInteger("personID", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}
	
    public Boolean removeBlock(User u) throws UserException{
         boolean flag =false;
    	try{
    	    begin();
    	    u.setStatus("active");
    	    getSession().save(u);
    	    getSession().flush();
//    	    getSession().refresh(u);
    	    commit();
    	    flag=true;
    	 return flag;
    } catch (HibernateException e) {
		rollback();
		throw new UserException("Could not get user ");
	 }
    }
    
    public Boolean addBlock(User u) throws UserException{
       boolean flag =true;
   	try{
   	    begin();
   	    u.setStatus("block");
   	    getSession().save(u);
   	    getSession().flush();
//   	getSession().refresh(u);
   	    commit();
   	    flag=false;
   	   return flag;
   } catch (HibernateException e) {
		rollback();
		throw new UserException("Could not get user ");
	}
   }
    
	public User register(User u) throws UserException {
		try {	
			begin();
			System.out.println("inside DAO");
			User user = new User(u.getUsername(), u.getPassword());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(u.getEmail());
			user.setDateOfBirth(u.getDateOfBirth());
			user.setSex(u.getSex());
            user.setRole(u.getRole());
            user.setBio(u.getBio());
            user.setStatus("active");
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}


	public List<User> retrieveUserList() throws UserException {

		try {
			begin();
			List<User> userList = null;
			Query q = getSession().createQuery("from User u where u.role=:user");
			q.setString("user", "User");
			userList = q.list();
			getSession().flush();
			commit();
			return userList; 

		} catch (HibernateException e) {
			rollback();
			throw new UserException("cannot retrieve the list of users" + e.getMessage());
		}

	}

	public List<Artical> retrieveFeeds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkUserActive(User u) {
		begin();
		Query q = getSession().createQuery("from User u where u.status = :uname");
		q.setString("uname","active");
		List<User> result = q.list();
		commit();
		getSession().flush();
		if(result.size()>0) {
			return true;
		}else{
			return false;
		}
	}
	
	
	public boolean checkUsernameExists(String username){
		
			begin();
			Query q = getSession().createQuery("from User where username = :uname");
			q.setString("uname", username);
			List<User> result = q.list();
			commit();
			if(result.size() > 0){
				System.out.println("user exists");
				return true;
			}else{
				return false;
			}
		
	}
}
