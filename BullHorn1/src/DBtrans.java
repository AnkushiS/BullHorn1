import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import customTools.DBUtils;
import model.Microblog;

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
	
	
	public static List<Microblog> selectBlog(){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String sql = "select m from Microblog m ";
		
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
