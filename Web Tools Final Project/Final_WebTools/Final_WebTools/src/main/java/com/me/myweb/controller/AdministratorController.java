package com.me.myweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.myweb.dao.ArticalDAO;
import com.me.myweb.dao.FollowerDAO;
import com.me.myweb.dao.UserDAO;
import com.me.myweb.exception.FollowerException;
import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.Artical;
import com.me.myweb.pojo.Comment;
import com.me.myweb.pojo.Favorite;
import com.me.myweb.pojo.User;
import com.me.myweb.validator.UserValidator;

@Controller
public class AdministratorController {
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
	
	
	@RequestMapping(value = "/user/manage", method = RequestMethod.GET)
	protected ModelAndView manageUser() throws Exception {
		List<Boolean> checker = new ArrayList<Boolean>();
		List<User> userList = null;
		Map<String, Object> model = new HashMap<String, Object>();
//		HttpSession session = request.getSession();
//		User u = (User) session.getAttribute("user");
		System.out.println("retriving the list of users");
		userList = userDao.retrieveUserList();
		for (User user : userList) {
			if (isBlock(user)) {
				checker.add(true);
			} else {
				checker.add(false);
			}
		}
		model.put("userlist", userList);
		model.put("checklist", checker);
		return new ModelAndView("manage_users", "model",model);

	}
	
	 public boolean isBlock(User u) throws UserException {
		 boolean flag = false;          
	     if(u.getStatus().equals("active"))
	    	 flag=false;
	     else {
	    	 flag=true;
	 }	 
		 return flag;
	 }
	 
		@RequestMapping(value = "/blacklist/add", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public boolean switchFollower(HttpServletRequest request, @RequestParam String personID) throws Exception {
			System.out.println("reached controller");
			boolean flag = false;
			int id = Integer.parseInt(personID);
            User user = (User) userDao.get(id);
			if (isBlock(user)) {
				flag = userDao.removeBlock(user);
			
			} else {
				flag = userDao.addBlock(user);
			}
			return flag;
		}
	
	@RequestMapping(value = "/artical/manage", method = RequestMethod.GET)
	protected ModelAndView manageArtical() throws Exception {
//	List<Artical> articalList = articalDao.getAllArticals();
		List<Artical> articalList =articalDao.getpage(0);
	System.out.println("articalSize------"+articalList.size());
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
		return new ModelAndView("manage_articals", "articals", articalList);
	}
	@RequestMapping(value = "/artical/managepage", method = RequestMethod.GET)
	protected ModelAndView page(HttpServletRequest request) throws Exception {
//	List<Artical> articalList = articalDao.getAllArticals();
		String i =request.getParameter("page");
		int number=Integer.parseInt(i);
		List<Artical> articalList =articalDao.getpage(number);
	System.out.println("articalSize------"+articalList.size());
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
		return new ModelAndView("manage_articals", "articals", articalList);
	}
	
	
	@RequestMapping(value = "/artical/delete", method = RequestMethod.GET)
	protected ModelAndView deleteArtical(HttpServletRequest request) throws Exception {
     long id =Long.parseLong(request.getParameter("delete"));
	 Artical artical = articalDao.getArtical(id);
	 articalDao.delete(artical);
	 List<Artical> articalList = articalDao.getAllArticals();
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
		return new ModelAndView("manage_articals", "articals", articalList);
	}
	
	@RequestMapping(value = "/artical/view/{id}", method = RequestMethod.GET)
	protected ModelAndView viewPost(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		long articalID = Long.parseLong(id);
		boolean flag;
		Map<String, Object> map = new HashMap<String, Object>();
		Artical artical = articalDao.getArtical(articalID);
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Favorite l = articalDao.doesFavorites(u, artical);
		List<Comment> comments = articalDao.getArticalComments(articalID);
		
		Collections.sort(comments, new Comparator<Comment>() {
			public int compare(Comment a1, Comment a2) {
				return a2.getCommentTime().compareTo(a1.getCommentTime());
			}
		});
		
		
		if (l != null)
			flag = true;
		else
			flag = false;
		map.put("flag", flag);
		map.put("artical", artical);
		map.put("comments", comments);
		map.put("count", articalDao.countFavorite(articalID));
		return new ModelAndView("administrator_post_view", "map", map);
	}
	
	@RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
	protected ModelAndView deleteComment(HttpServletRequest request) throws Exception {
     long id =Long.parseLong(request.getParameter("delete"));
     System.out.println("commentid"+id);
     String articalId=request.getParameter("articalId");
     System.out.println("articalId"+articalId);
        Comment comment = articalDao.getComment(id);
	    articalDao.deleteComment(comment);
	    ModelAndView mav =new ModelAndView();
	    mav=viewPost(request,articalId);
	    System.out.println("fdggfg");
		return mav;
	}
	
}
