package com.vtlamdev.business.business.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employee_id;
    @NotNull(message = "Is required")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "Is required")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "Is required")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull(message = "Is required")
    @Column(name = "hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id",insertable = false,updatable = false)
    private Job job; //foreign key
    @Column(name = "job_id")
    private int jobId;
    @NotNull(message = "Is required")
    @Column(name = "salary")
    private double Salary;
    @ManyToOne
    @JoinColumn(name = "manager_id",insertable = false,updatable = false)
    private Employee manager; // foreign key
    @Column(name = "manager_id")
    private Integer managerId;
    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false,updatable = false)
    private Department department; // foreign key
    @Column(name = "department_id")
    private int departmentId;

    @OneToMany(mappedBy = "employee")
    private List<Dependent> dependents;
    public Employee(){}

    public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, Job job, int jobId, double salary, Employee manager, Integer managerId, Department department, int departmentId, List<Dependent> dependents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.job = job;
        this.jobId = jobId;
        Salary = salary;
        this.manager = manager;
        this.managerId = managerId;
        this.department = department;
        this.departmentId = departmentId;
        this.dependents = dependents;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", job=" + job +
                ", Salary=" + Salary +
                ", manager=" + manager +
                ", department=" + department +
                '}';
    }
}
