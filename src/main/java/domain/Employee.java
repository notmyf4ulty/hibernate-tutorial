package domain;

import javax.persistence.*;
import java.math.BigDecimal;

// @Entity annotation forces Hibernate to create tables in the connected database
// which will consist of the class' fields
@Entity
// @Table annotation modifies tables. Attribute 'name' allows to change the table's name.
@Table(name = "Pracownicy")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    //@Column annotation modifies column.
    // Attributes:
    // - 'name' allows to change the column name
    // - 'nullable' enforces NOT NULL (nullable = false -> NOT NULL)
    // - 'length' sets max column value's length
    // - 'columnDefinition' is SQL code's piece
    // - 'precision' sets max digits number
    // - 'scale' sets max digits number after comma
    @Column (name = "imie", nullable = false, length = 10)
    private String firstName;

    @Column (name = "nazwisko", columnDefinition = "VARCHAR(10) NOT NULL")
    private String lastName;

    @Column (name = "pensja", nullable = false)
    private double salary;

    @Column (precision = 10, scale = 2)
    private BigDecimal salary2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary2() {
        return salary2;
    }

    public void setSalary2(BigDecimal salary2) {
        this.salary2 = salary2;
    }
}
