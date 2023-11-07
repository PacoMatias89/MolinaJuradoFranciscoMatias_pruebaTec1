package org.example.logic;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String jobTitle;
    private Double salary;

    private LocalDate dateEmployment;


    public Employee() {
    }

    public Employee(Long id, String name, String surname, String jobTitle, Double salary, LocalDate dateEmployment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateEmployment = dateEmployment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTitle = jobTittle;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(LocalDate dateEmployment) {
        this.dateEmployment = dateEmployment;
    }



    @Override
    public String toString() {

        return  "id: " + id +'\n' +
                "name: " + name + '\n' +
                "surname: " + surname + '\n' +
                "jobTittle: " + jobTitle + '\n' +
                "Date of Employment: " + dateEmployment + '\n' +
                "salary: " + salary;
    }
}
