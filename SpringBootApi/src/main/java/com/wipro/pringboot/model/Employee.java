package com.wipro.pringboot.model;

import javax.persistence.*;

@Entity
@Table(name="employeeDetails")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_Id")
    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + email + '\'' +
                ", email='" + firstName + '\'' +
                ", firstName='" + lastName + '\'' +
                '}';
    }


     public Employee(){

     }
    public Employee(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Employee(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
