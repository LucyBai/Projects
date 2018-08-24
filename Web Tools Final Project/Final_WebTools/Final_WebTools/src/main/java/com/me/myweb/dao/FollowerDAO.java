package com.me.myweb.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;

import com.me.myweb.exception.FollowerException;
import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.User;


public class FollowerDAO extends DAO {

	public FollowerDAO() {
	}
	public List<BigInteger> retrieveFollowers(User u) throws FollowerException {

		try {
			List<BigInteger> followerList = null;
			begin();
			Query q = getSession().createSQLQuery("select followerID_fk from blog.user_follower_table WHERE personID_fk= :personID");
			q.setLong("personID", u.getPersonID());
			System.out.println("------------------------");
			followerList=q.list();
			getSession().flush();
			commit();
			return followerList;
		} catch (HibernateException e) {
			rollback();
			throw new FollowerException("Exception while retrieving follower list" + e.getMessage());
		}
	}

	public List<BigInteger> retrievesubscribers(User u) throws FollowerException {

		try {
			List<BigInteger> followerList = null;
			begin();
			Query q = getSession().createSQLQuery("select personID_fk from blog.user_follower_table WHERE followerID_fk= :followerID");
			q.setLong("followerID", u.getPersonID());
			followerList=q.list();
			getSession().flush();
			commit();
			return followerList;
		} catch (HibernateException e) {
			rollback();
			throw new FollowerException("Exception while retrieving follower list" + e.getMessage());
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

	public boolean addFollower(User subscriber,User follower ) throws FollowerException {
		boolean flag = false;
		try {
			begin();
		//	getSession().merge(subscriber);
			Query q = getSession().createSQLQuery("insert into blog.user_follower_table (personID_fk, followerID_fk) values (:personID,:followerID)");
			q.setLong("personID", subscriber.getPersonID());
			q.setLong("followerID", follower.getPersonID());
			int u = q.executeUpdate();
			if(u ==1){
			System.out.print("inside dao");
			commit();
			flag = true;
			}
		} catch (HibernateException e) {
			rollback();
			throw new FollowerException("cannot add follower" + e.getMessage());

		}
		return flag;
	}

	public boolean removeFollower(User subscriber,User follower) throws FollowerException {
		boolean flag = true;
		try {
			begin();
			Query q = getSession()
					.createSQLQuery(
					"DELETE FROM blog.user_follower_table WHERE personID_fk= :personID and followerID_fk= :followerID")
					.setParameter("personID", subscriber.getPersonID())
					.setParameter("followerID", follower.getPersonID());
			int up = q.executeUpdate();
			System.out.println("update"); 
			commit();
		
			System.out.println("commited");
			flag = false;
		} catch (HibernateException e) {
			rollback();
			throw new FollowerException("cannot remove follower" + e.getMessage());
		}
		return flag;
	}

}
