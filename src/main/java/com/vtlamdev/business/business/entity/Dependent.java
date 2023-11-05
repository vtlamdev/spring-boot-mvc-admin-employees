package com.vtlamdev.business.business.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dependents")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dependent_id")
    private int dependent_id;
    @NotNull(message = "Is required")
    @Size(min = 1,message = "Must more than 1 letter")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "Is required")
    @Size(min = 1,message = "Must more than 1 letter")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "Is required")
    @Size(min = 1,message = "Must more than 1 letter")
    @Column(name = "relationship")
    private String relationship;
    @OneToOne
    @JoinColumn(name = "employee_id",insertable = false, updatable = false)
    private Employee employee;
    public Dependent(){}

    public Dependent(String firstName, String lastName, String relationship, Employee employee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.employee = employee;
    }

    public int getDependent_id() {
        return dependent_id;
    }

    public void setDependent_id(int dependent_id) {
        this.dependent_id = dependent_id;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return "dependent{" +
                "dependent_id=" + dependent_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", relationship='" + relationship + '\'' +
                ", employee=" + employee +
                '}';
    }
}
