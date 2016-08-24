import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by przemek on 20.08.16.
 */
public class Main {
    public static void main(String [] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
    }
}
