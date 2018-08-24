package com.me.myweb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.myweb.dao.ArticalDAO;
import com.me.myweb.dao.FollowerDAO;
import com.me.myweb.dao.UserDAO;
import com.me.myweb.exception.FollowerException;
import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.Artical;
import com.me.myweb.pojo.User;
import com.me.myweb.validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
 
	@Autowired
	@Qualifier("followerDao")
	FollowerDAO followerDao;

	@Autowired
	@Qualifier("articalDao")
	ArticalDAO articalDao;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// to redirect to registration page

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("redirectToRegister");
		return new ModelAndView("user_register", "user", new User());

	}

	// to redirect to login page (replaced by modal)

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	protected ModelAndView redirectUserPage(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		User u = (User) session.getAttribute("user");
		
		if(u == null){
			return new ModelAndView("error");
		}
		if(u.getRole().equals("User")) {
//			if(userDao.checkUserActive(u)) {
            if(u.getStatus().equals("active")) {
			session.setAttribute("user", u);
			List<User> following = new ArrayList<User>();
			List<Artical> feedlist = null;
			following = subscribersList(u);
			following.add(u);
			feedlist = new ArrayList<Artical>();
			for (User user : following) {
				for (Artical a : user.getArtical()) {
					feedlist.add(a);
				}
			}

			Collections.sort(feedlist, new Comparator<Artical>() {
				public int compare(Artical a1, Artical a2) {
					return a2.getUploadDate().compareTo(a1.getUploadDate());
				}
			});

			return new ModelAndView("homepage", "feeds", feedlist);}
            else{
            	return new ModelAndView("blacklist");
            	}
            }
            else {
            	session.setAttribute("user", u);
            	List<Artical> articalList = articalDao.getpage(0);
            	System.out.println("articalSize------"+articalList.size());
            		Collections.sort(articalList, new Comparator<Artical>() {
            			public int compare(Artical a1, Artical a2) {
            				return a2.getUploadDate().compareTo(a1.getUploadDate());
            			}
            		});
            	
            	return new ModelAndView("manage_articals","articals",articalList);
            }
	

	}

	// to login existing user and redirect to home page

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			System.out.print("loginUser");

			User u = userDao.get(request.getParameter("username"), request.getParameter("password"));

			if (u == null) {
			System.out.println("UserName/Password does not exist");
			session.setAttribute("errorMessage", "UserName/Password does not exist");
			return new ModelAndView("error");
			}
			else if(u.getRole().equals("User")) {
//				if(userDao.checkUserActive(u)) {
            if(u.getStatus().equals("active")) {
			session.setAttribute("user", u);
			List<User> following = new ArrayList<User>();
			List<Artical> feedlist = null;
			following = subscribersList(u);
			
			
			following.add(u);
			feedlist = new ArrayList<Artical>();
			for (User user : following) {
				for (Artical a : user.getArtical()) {
					feedlist.add(a);
				}
			}

			Collections.sort(feedlist, new Comparator<Artical>() {
				public int compare(Artical a1, Artical a2) {
					return a2.getUploadDate().compareTo(a1.getUploadDate());
				}
			});
			
			return new ModelAndView("homepage", "feeds", feedlist);}
            else{
            	return new ModelAndView("blacklist");
            	}
            }
            else {
            	session.setAttribute("user", u);
            	List<Artical> articalList = articalDao.getpage(0);
            	System.out.println("articalSize------"+articalList.size());
            		Collections.sort(articalList, new Comparator<Artical>() {
            			public int compare(Artical a1, Artical a2) {
            				return a2.getUploadDate().compareTo(a1.getUploadDate());
            			}
            		});
            	return new ModelAndView("manage_articals","articals",articalList);
            }

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error");
		}

	}

	// to register new user and redirect to feeds page

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("user") User user,
			BindingResult result) throws Exception {
		System.out.print("!!!!!!!!!!!!!!!!!!!!Validator");
		System.out.print(user.getFirstName());
	
		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("user_register", "user", user);
		}

		try {

			System.out.print("!!!!!!!!!!!!!!!!!!!!registerNewUser");
			User u = userDao.register(user);
			request.getSession().setAttribute("user", u);
            if(u.getRole().equals("User")) {
			return new ModelAndView("homepage", "user", u);
			}
            else {
            	List<Artical> articalList = articalDao.getpage(0);
            	System.out.println("articalSize------"+articalList.size());
            		Collections.sort(articalList, new Comparator<Artical>() {
            			public int compare(Artical a1, Artical a2) {
            				return a2.getUploadDate().compareTo(a1.getUploadDate());
            			}
            		});
            		
             return new ModelAndView("manage_articals","articals",articalList);
            }

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

	// to retrieve all users

	@RequestMapping(value = "/user/available", method = RequestMethod.GET)
	protected ModelAndView retrieveAllUsers(HttpServletRequest request) throws Exception {

		try {
			List<Boolean> checker = new ArrayList<Boolean>();
			List<User> userList = null;
			Map<String, Object> model = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			System.out.println("retriving the list of users");
			userList = userDao.retrieveUserList();
			
			for (User user : userList) {
				if (isPresent(user, u)) {
					checker.add(false);
				} else {
					checker.add(true);
				}
			}
			model.put("userlist", userList);
			model.put("checklist", checker);
			return new ModelAndView("user_list", "model", model);

		} catch (

		UserException e) {
			System.out.println("Exception:" + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while retrieving the list");
		}
	}
	
	//check if already has a relationship
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

	// to edit user

	// to logout a user

	@RequestMapping(value =
			"/logout", method = RequestMethod.GET)
	protected String returnToIndex(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		session.invalidate();
		return "index";

	}


	public List<User> subscribersList(User user) throws UserException, FollowerException {
		List<User> following = new ArrayList<User>();
		for (User u : userDao.retrieveUserList()) {
			for (User f : u.getFollowers()) {
				if (f.getPersonID() == user.getPersonID())
					following.add(u);
			}
		}
		return following;
//		
//		List<User> following = new ArrayList<User>();		
//		if(followerDao.retrievesubscribers(user).isEmpty())
//		{
//			  following=null;
//		}
//		else {
//		for(BigInteger i: followerDao.retrievesubscribers(user))
//		{
//		   for(User u:userDao.retrieveUserList()) {
//			   if(u.getPersonID()==i.longValue()) {
//				   following.add(u);
//			   }
//		   }
//		}
//		}
//		return following;
	}
   //to redirect interceptor to error page
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorcall() {
		return "error";
	}
}