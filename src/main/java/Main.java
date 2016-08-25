import domain.Employee;

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

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(3333.3);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
