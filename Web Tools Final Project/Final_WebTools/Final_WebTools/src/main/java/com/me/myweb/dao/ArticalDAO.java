
package com.me.myweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.me.myweb.exception.ArticalException;
import com.me.myweb.pojo.Artical;
import com.me.myweb.pojo.Comment;
import com.me.myweb.pojo.Favorite;
import com.me.myweb.pojo.User;


public class ArticalDAO extends DAO {

	public ArticalDAO() {

	}
	public List<Artical> getAllArticals() throws ArticalException {
		try {
			begin();	
			String q = "";
			q = "from Artical";
			Query q1 = getSession().createQuery(q);
			List<Artical> articals = q1.list();
			getSession().flush();
			commit();
			return articals;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not get articals  ", e);
		}
	}
	public List<Artical> getpage(int number) throws ArticalException {
		try {
			begin();	
			String q = "";
			q = "from Artical";
			Query q1 = getSession().createQuery(q);
			 q1.setFirstResult((number-1)*3);
		     q1.setMaxResults(3);
		        List toDelete = q1.list();
			List<Artical> articals = q1.list();
			getSession().flush();
			commit();
			return articals;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not get articals  ", e);
		}
	}
	
	
	public List<Artical>type(String search) throws ArticalException{
		try {
			begin();
            Query q = getSession().createQuery("FROM Artical as m WHERE m.type = :uquery");
            q.setString("uquery", search);
            List<Artical> articals = q.list();
            commit();
            return articals;
		}
		catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not get articals");
		}
	}
	
	
	
	
	public List<Artical>search(String search) throws ArticalException{
		try {
			begin();
            Query q = getSession().createQuery("FROM Artical as m WHERE m.content LIKE :uquery");
            q.setString("uquery", "%"+search+"%");
            List<Artical> articals = q.list();
            commit();
            return articals;
		}
		catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not get articals");
		}
	}
	
	
	
	
	
	public List<Artical> get(User user) throws ArticalException {
		try {
			begin();
			String q = "";
			q = "from Artical where personID_fk= :personID";
			Query q1 = getSession().createQuery(q);
			q1.setLong("personID", user.getPersonID());
			List<Artical> articals = q1.list();
			commit();
			return articals;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not get articals from " + user.getFirstName(), e);
		}
	}

	public Artical getArtical(long articalID) throws ArticalException {
		try {
			begin();
			String q = "";
			q = "from Artical where articalID= :articalID";
			Query q1 = getSession().createQuery(q);
			q1.setLong("articalID", articalID);
			Artical post = (Artical) q1.uniqueResult();
			commit();
			return post;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("could not find artical with id" + articalID);
		}
	}

	public Comment getComment(long commentID) throws ArticalException {
		try {
			begin();
			String q = "";
			q = "from Comment where commentID= :commentID";
			Query q1 = getSession().createQuery(q);
			q1.setLong("commentID", commentID);
			Comment comment = (Comment) q1.uniqueResult();
			commit();
			return comment;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("could not find comment with id" + commentID);
		}
	}
	
	public List<Comment> getArticalComments(long articalID) throws ArticalException{
		try {
			begin();
			Query q1=getSession().createQuery("from Comment where articalID=:articalID");
			q1.setLong("articalID",articalID);
			List<Comment> comments = q1.list();
			commit();
			return comments;
		}
		catch (HibernateException e) {
			rollback();
			throw new ArticalException("could not find comment with id" + articalID);
		}
	}
	
	
	public void deleteComment(Comment comment)throws ArticalException {
		try {
			begin();
			getSession().delete(comment);
			System.out.println("delete comment");
			commit();	
		}catch(HibernateException e) {
			rollback();
		throw new ArticalException("could not delete comment");
	}	
	}

	public Artical upload(Artical a) throws ArticalException {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(a);
			commit();
			return a;

		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Exception while uploading artical: " + e.getMessage());
		}
	}

	public void delete(Artical a) throws ArticalException {
		try {
			begin();
 	//	getSession().delete(a);
			Query q1 =getSession().createSQLQuery("Set FOREIGN_KEY_CHECKS=0");
			q1.executeUpdate();
			Query q = getSession()
					.createSQLQuery(
							"DELETE FROM blog.artical_table WHERE articalID= :articalID")
					.setParameter("articalID", a.getArticalID());
		   q.executeUpdate();
		   Query q2 =getSession().createSQLQuery("Set FOREIGN_KEY_CHECKS=1");
			q2.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Could not delete artical ");
		}
	}

	public long increment(String articalID) throws ArticalException {
		try {
			begin();
			System.out.println("like counter");
			long count = 0;
			long ID = Long.parseLong(articalID);
			String q = "";
			q = "from Artical where articalID= :articalID";
			Query q1 = getSession().createQuery(q);
			q1.setLong("articalID", ID);
			Artical artical = (Artical) q1.uniqueResult();
			count = artical.getFavoriteCount() + 1;
			getSession().update(artical);
			System.out.println("updated");
			commit();
			return count;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("cannot favorite this artical");
		}
	}

	public Comment addComment(Comment c) throws ArticalException {
		try {
			begin();
			getSession().saveOrUpdate(c);
			System.out.println("in com dao");
			commit();
			return c;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Exception while adding comment");
		}
	}

	public Favorite doesFavorites(User u, Artical a) throws ArticalException {
		try {
			//boolean flag = false;
			begin();
			/*String q = "";
			q = "from Like where likePhoto= :likePhoto and user= :user";
			Query q1 = getSession().createQuery(q);
			q1.setEntity("likePhoto", p);
			q1.setEntity("user", u);
			Like like = (Like) q1.uniqueResult();*/
			
			Criteria crit = getSession().createCriteria(Favorite.class);
			crit.add(Restrictions.eq("user", u));
			crit.add(Restrictions.eq("favoriteArtical",a));
			Favorite favorite = (Favorite)crit.uniqueResult();
			commit();
			return favorite;
		} catch (HibernateException e) {
			rollback();
			throw new ArticalException("Exception while checking favorite" + a.getArticalID());
		}
	}
    public int countFavorite(long articalID) throws ArticalException{
    	try {
    		begin(); 
    		System.out.println("----------------------");
    		Query q =getSession().createSQLQuery("select *from blog.like_table WHERE articalID_fk =:articalID");
              q.setLong("articalID", articalID);
  
//    		q.executeUpdate();
    		List<Long> count = q.list();
    		System.out.println("countFavorites"+count);
    		commit();
    		return count.size();
		
    	}catch(HibernateException e) {
    		throw new ArticalException("Exception while count Favortite");
    	}
    }
	public void registerLike(Favorite favorite) throws ArticalException {
		try {
			begin();
			getSession().save(favorite);
			commit();
		} catch (HibernateException e) {
			throw new ArticalException("Exception while favorite articals");
		}

	}
    
	public void removeFavorite(Favorite l) throws ArticalException {
		try{
			begin();
			getSession().delete(l);
			commit();
		}catch(HibernateException e){
			throw new ArticalException("Exception while unfavorite");
		}
	}
}
