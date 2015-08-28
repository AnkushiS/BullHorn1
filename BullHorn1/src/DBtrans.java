import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtils;
import model.Microblog;
import model.User;

public class DBtrans {

	public static void insert(Microblog user) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void insertUsr(User user) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	

	
	public static List<Microblog> selectBlog(){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String sql = "select m from Microblog m";
		TypedQuery<Microblog> mq = em.createQuery(sql, Microblog.class);
		
		List<Microblog> blogs;
		
		try{
			blogs = mq.getResultList();
			if(blogs==null || blogs.isEmpty()){
				blogs=null;
			}
		}finally {
			em.close();
		}
		return blogs;
		}


public static List<User> selectUsr(){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String sql = "select u from User u";
		TypedQuery<User> mq = em.createQuery(sql, User.class);
		
		List<User> blogs;
		
		try{
			blogs = mq.getResultList();
			if(blogs==null || blogs.isEmpty()){
				blogs=null;
			}
		}finally {
			em.close();
		}
		return blogs;
		}

	
	
	public static boolean checkLogin(String userName, String password) {
		boolean valid = false;
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		String sql = "select u from User u where u.userName= :userName";		
		TypedQuery<User> mq = em.createQuery(sql, User.class);
		mq.setParameter("userName", userName);
			
		try{
			if(mq.getSingleResult().getUserName().equals(userName)){
				
				//if(mq.getSingleResult().getPassword().equals(password)){
					//System.out.println(mq.getSingleResult().getUserName() + "      " + mq.getSingleResult().getPassword());
					valid=true;	
			//	}
			}
			
		}catch(Exception e){
			System.out.println("in checkLogin       " + e);
		}finally{
			em.close();
		}
		return valid;
	}
	
//	public static List<Microblog> selectUsrBlog(String userName){
//		
//		EntityManager em = DBUtils.getEmFactory().createEntityManager();
//		
//		String sql = "select m from Microblog m where m.userName= :userName";
//		TypedQuery<Microblog> mq = em.createQuery(sql, Microblog.class);
//		
//		mq.setParameter("userName", userName);
//		
//		List<Microblog> blogs;
//		
//		try{
//			blogs = mq.getResultList();
//			if(blogs==null || blogs.isEmpty()){
//				blogs=null;
//			}	
//		}finally {
//			em.close();
//		}
//		return blogs;
//		}
	
	
/*
	public static void update(User user) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(User user) {
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
*/
	
}
