package com.me.myweb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.myweb.dao.FollowerDAO;
import com.me.myweb.dao.UserDAO;
import com.me.myweb.exception.FollowerException;
import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.User;



@Controller
public class FollowerController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("followerDao")
	FollowerDAO followerDao;

	// ajax function to follow and unfollow someone from user-list
	@RequestMapping(value = "/follow/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean switchFollower(HttpServletRequest request, @RequestParam String followeeID) throws Exception {
		System.out.println("reached controller");
		boolean flag = false;
		int id = Integer.parseInt(followeeID);
		HttpSession session = request.getSession();
		User follower = (User) session.getAttribute("user");
		try {
			User followee = (User) followerDao.get(id);
			if (isPresent(followee, follower)) {
				//System.out.println("before" +followee.getFollowers().size());
			//followee.getFollowers().remove(follower);
				//System.out.println("after" + followee.getFollowers().size());
				System.out.println("removed");
				flag = followerDao.removeFollower(followee,follower);

			} else {
			//	followee.getFollowers().add(follower);
				System.out.println("added");
				flag = followerDao.addFollower(followee,follower);

			}

		} catch (FollowerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	// check if already follows
	
	public  boolean isPresent(User user, User follower) throws UserException, FollowerException {
		boolean flag = false;
		for (BigInteger b: followerDao.retrieveFollowers(user)) {
			for(User u: userDao.retrieveUserList())
			{ if(u.getPersonID()==b.longValue()&&u.getPersonID()==follower.getPersonID())
			{
				flag = true;
				break;
			 }	
			}
			}
        System.out.println("sssssssssFlag"+flag);
		return flag;
	}

	// to retrieve list of followers

	@RequestMapping(value = "/follow/followers", method = RequestMethod.GET)
	protected ModelAndView retrieveFollowers(HttpServletRequest request) throws Exception {

		List<User> followerlist = null;
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		followerlist = followersList(u);
		return new ModelAndView("user_followers", "followerlist", followerlist);
	}

	// to retrieve list of following
	@RequestMapping(value = "/follow/following", method = RequestMethod.GET)
	protected ModelAndView retrieveFollowing(HttpServletRequest request) throws Exception {
		List<User> following = new ArrayList<User>();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		following = subscribersList(user);

		return new ModelAndView("user_following", "followinglist", following);
	}

	// to redirect to view profile page
	@RequestMapping(value = "/follow/view/{id}", method = RequestMethod.GET)
	protected ModelAndView viewProfile(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		boolean flag = false;
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		List<User> followingList = new ArrayList<User>();
		Map<String, Object> model = new HashMap<String, Object>();
		int followerID = Integer.parseInt(id);
		User follower = followerDao.get(followerID);
		followingList = subscribersList(follower);
		flag=isPresent(follower,currentUser);
		model.put("follower", follower);
		model.put("follows", flag);
		model.put("followinglist", followingList);
		System.out.print("profile_view_flag"+flag);
		return new ModelAndView("profile_view", "model", model);
	}
	
    //retrive the list of users followed
	public List<User> followersList(User user) throws UserException,FollowerException{
		List<User> followers = new ArrayList<User>();		
		if(followerDao.retrieveFollowers(user).isEmpty())
		{
			  followers=null;
		}
		else {
		for(BigInteger i: followerDao.retrieveFollowers(user))
		{
		   for(User u:userDao.retrieveUserList()) {
			   if(u.getPersonID()==i.longValue()) {
				   followers.add(u);
			   }
		   }
		}
		}
		return followers;
	}
	
	
	
	public List<User> subscribersList(User user) throws UserException, FollowerException {
		List<User> following = new ArrayList<User>();		
		if(followerDao.retrievesubscribers(user).isEmpty())
		{
			  following=null;
		}
		else {
		for(BigInteger i: followerDao.retrievesubscribers(user))
		{
		   for(User u:userDao.retrieveUserList()) {
			   if(u.getPersonID()==i.longValue()) {
				   following.add(u);
			   }
		   }
		}
		}
		return following;
	}
}
