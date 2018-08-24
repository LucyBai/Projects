package com.me.myweb.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.myweb.dao.ArticalDAO;
import com.me.myweb.dao.FollowerDAO;
import com.me.myweb.dao.UserDAO;
import com.me.myweb.exception.ArticalException;
import com.me.myweb.exception.FollowerException;
import com.me.myweb.exception.UserException;
import com.me.myweb.pojo.Artical;
import com.me.myweb.pojo.Comment;
import com.me.myweb.pojo.Favorite;
import com.me.myweb.pojo.User;
import com.me.myweb.utils.JsonUtils;


@Controller
public class ArticalController {
	@Autowired
	@Qualifier("articalDao")
	ArticalDAO articalDao;

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("followerDao")
	FollowerDAO followerDao;
	
	// to redirect to page to upload picture

	@RequestMapping(value = "/artical/create", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
	    Artical artical =new Artical(); // should be AutoWired
		// command object
		model.addAttribute("artical", artical);
		// return form view
		return "artical_create";
	}
	
	@RequestMapping(value = "/artical/upload", method = RequestMethod.POST)
	public ModelAndView handleUpload(@ModelAttribute("artical") Artical artical, HttpServletRequest request) throws Exception {
		ModelAndView mv = null;
		try {

			HttpSession session = (HttpSession) request.getSession();
			User u = (User) session.getAttribute("user");
			String check = "/";
			String dir = check + "user_images_" + u.getPersonID();
			File directory;
		    String path = "F:/SpringProjects/Final_WebTools/src/main/webapp/resources/images";
	        String content =request.getParameter("content");
	        String articalName = request.getParameter("articalName");
	        String type =request.getParameter("type");
			path += dir;
			directory = new File(path);
			boolean temp = directory.exists();
			if (!temp) {
				temp = directory.mkdir();
			}
			if (temp) {
				CommonsMultipartFile articalInMemory = artical.getPic();
			    System.out.print(articalInMemory);
				String fileName = articalInMemory.getOriginalFilename();
                System.out.print(fileName);
				File localFile = new File(directory.getPath(), fileName);
				articalInMemory.transferTo(localFile);
				String fName = check + "images" + dir + check + fileName;
				artical.setFileName(fName);
				artical.setArticalName(articalName);
				artical.setContent(content);
				artical.setType(type);
				System.out.println("File is stored at" + localFile.getPath());
				System.out.print("registerNewUser");
			    // User u = (User) session.getAttribute("user");
				artical.setUser(u);
				artical.setUploadDate(new Date());
				Artical p = articalDao.upload(artical);
				//mv = retriveArticals(request);
				//UserController uc =new UserController();
				mv =allArticals(request);

			} else {
				System.out.println("Failed to create directory!");
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (ArticalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
    
	@RequestMapping(value = "/artical/station", method = RequestMethod.GET)
	public ModelAndView allArticals(HttpServletRequest request) throws ArticalException {
		List<Artical> articalList = articalDao.getAllArticals();
		
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
	
		
		return new ModelAndView("artical_station", "articals", articalList);
	}
	
	@RequestMapping(value = "/artical/search", method = RequestMethod.POST)
	public ModelAndView searchArticals(HttpServletRequest request) throws ArticalException {
		String search =request.getParameter("search");
		
		List<Artical> articalList = articalDao.search(search);
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
		return new ModelAndView("artical_station", "articals", articalList);
	}
	
	@RequestMapping(value = "/artical/type", method = RequestMethod.GET)
	public ModelAndView classifyArticals(HttpServletRequest request) throws ArticalException {
		String search =request.getParameter("name");
		
		List<Artical> articalList = articalDao.type(search);
		Collections.sort(articalList, new Comparator<Artical>() {
			public int compare(Artical a1, Artical a2) {
				return a2.getUploadDate().compareTo(a1.getUploadDate());
			}
		});
		return new ModelAndView("artical_station", "articals", articalList);
	}
	     

	
	
	// to retrieve pictures of a user and display
	@RequestMapping(value = "/user/station", method = RequestMethod.GET)
	public ModelAndView retriveArticals(HttpServletRequest request) throws FollowerException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Artical> artical_list = null;
		List<User> following = null;
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		try {
			following = subscribersList(u);
			artical_list = articalDao.get(u);
		} catch (ArticalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("artical_list", artical_list);
		model.put("following", following);
		return new ModelAndView("user_station", "model", model);

	}

	
	// ajax function to favorite/unfavorite
	@RequestMapping(value = "/artical/hit", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String favoriteUnfavorite(HttpServletRequest request, @RequestParam String articalID) throws Exception {
		boolean flag;
		HttpSession session = request.getSession();
		long id = Long.parseLong(articalID);
		User u = (User) session.getAttribute("user");
		Artical a = articalDao.getArtical(id);
		Favorite l = articalDao.doesFavorites(u, a);
		if (l == null) {
			Favorite favorite = new Favorite();
			favorite.setFavoriteArtical(a);
			favorite.setUser(u);
			a.setFavoriteCount(a.getFavoriteCount()+1);
			articalDao.registerLike(favorite);
			flag = true;
		} else {    
			a.setFavoriteCount(a.getFavoriteCount()-1);
			articalDao.removeFavorite(l);
			flag = false;
		}
		String result = "{" + JsonUtils.toJsonField("flag", String.valueOf(flag))
				+ (", " + JsonUtils.toJsonField("count", String.valueOf(a.getFavorite().size()))) + "}";
		return result;
	}

	
	// to redirect to view post page
	@RequestMapping(value = "/artical/comment/{id}", method = RequestMethod.GET)
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
				return a1.getCommentTime().compareTo(a2.getCommentTime());
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
		return new ModelAndView("post_view", "map", map);
	}

	// ajax function to add comment

	@RequestMapping(value = "/artical/comment/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addComment(HttpServletRequest request, @RequestParam String comText, @RequestParam String articalID)
			throws Exception {
		long artiID = Long.parseLong(articalID);
		Artical artical = articalDao.getArtical(artiID);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Comment com = new Comment();
		com.setUser(user);
		com.setCommentContent(comText);
		com.setCommentArtical(artical);
		com.setCommentTime(new Date());
		articalDao.addComment(com);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.S"); 
		String s =formatter.format(com.getCommentTime());
		System.out.println("added comment");
		String result = "{" + JsonUtils.toJsonField("user", com.getUser().getUsername())
				+ (", " + JsonUtils.toJsonField("comment", com.getCommentContent())) 
				+ (", " + JsonUtils.toJsonField("time", s))+"}";
		return result;

	}


	// to retrieve the file path of picture and store it and redirect to gallery


	
	@RequestMapping(value = "/user/favorite", method = RequestMethod.POST)
	@ResponseBody
	public long favoriteCounter(HttpServletRequest request, @RequestParam String articalID) {
		System.out.println("reached");
		long count = 0;
		try {
			count = articalDao.increment(articalID);
		} catch (ArticalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	// retrieve list of following for the user

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
