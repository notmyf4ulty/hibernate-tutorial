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

        // Database object creation
        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setFirstName("Piotr");
        employee.setLastName("Kowalski");
        employee.setSalary(2222.2);

        Employee employee2 = new Employee();
//        employee.setId(1L);
        employee2.setFirstName("Jan");
        employee2.setLastName("Rosiak");
        employee2.setSalary(4444.4);



        // Starting transaction
        entityManager.getTransaction().begin();
        // "Sending" new Employee object to the database
        entityManager.persist(employee);
        entityManager.persist(employee2);
        // Closing (commiting) transaction
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
