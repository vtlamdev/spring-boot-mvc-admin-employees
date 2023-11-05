package com.vtlamdev.business.business.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int DepartmentId;
    @NotNull
    @Column(name = "department_name")
    private String DepartmentName;
    @ManyToOne
    @JoinColumn(name = "location_id",insertable = false,updatable = false)
    private Location location; //foreign key

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee>employees;//getter setter
    public Department(){}

    public Department(String departmentName, Location location) {
        DepartmentName = departmentName;
        this.location = location;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DepartmentId=" + DepartmentId +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", location=" + location +
                '}';
    }
}
