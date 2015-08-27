package customTools;
//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DBUtils {
	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("BullHorn1");
				public static EntityManagerFactory getEmFactory() {
					return emf;
				}

}
