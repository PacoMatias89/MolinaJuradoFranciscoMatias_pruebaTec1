package org.example.persistence;

import org.example.logic.Employee;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    EmployeeJpaController employeeJpaController = new EmployeeJpaController();

    //We create  the controller methods
    public void createEmployee(Employee employee) {
        employeeJpaController.createEmployee(employee);
    }

    public Employee updateEmploye(Employee employee) {
       return employeeJpaController.updateEmployee(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeJpaController.findEmployeeById(id);
    }

    public void deleteEmployee(Long id) {
        try {
            employeeJpaController.deleteEmployee(id);
        }catch (Exception e){
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Employee> getEmployees(){
        return employeeJpaController.ListEmployee();
    }


    public List<Employee> findEmployeeByPositio(String jobTitle){
        return  employeeJpaController.findEmployee(jobTitle);
    }



}
