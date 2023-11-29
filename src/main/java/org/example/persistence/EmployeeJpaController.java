package org.example.persistence;

import org.example.logic.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import java.util.List;

/**
 *
 * CRUD Logic Responsible List of Employees
 * */

public class EmployeeJpaController {

    // Creamos un objeto de EntityManagerFactory para crear y guardar en ella instancias de EntityManager.
    private EntityManagerFactory factory = null;


    public EmployeeJpaController() {
        factory = Persistence.createEntityManagerFactory("companyPU");
    }

    public EntityManager getEntityManager(){
        return  factory.createEntityManager();
    }

    /*---------------------------------- We create CRUD methods --------------------------------------------*/

    public void createEmployee(Employee employee) {

        EntityManager manager = null;
        try {

            manager = getEntityManager();
            manager.getTransaction().begin();//We open transaction manager
            manager.persist(employee);
            manager.getTransaction().commit();// We close transaction manager

        } catch (RuntimeException e) {
            JOptionPane.showConfirmDialog(null, "User could not be created succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    //We are looking for an employee by id
    public Employee updateEmployee(Employee employee) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();//We open transaction manager
            return manager.merge(employee);
        } catch (RuntimeException e) {
            JOptionPane.showConfirmDialog(null, "User could not be updated succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (manager!= null) {
                manager.getTransaction().commit();// We close transaction manager
                manager.close();
            }
        }
        return null;
    }

    public Employee findEmployeeById(Long id) {
        EntityManager manager = null;
        try {
            manager = getEntityManager(); //We open transaction manager
            manager.getTransaction().begin();
            return manager.find(Employee.class, id);
        } catch (RuntimeException e) {
            JOptionPane.showConfirmDialog(null, "User could not be updated succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (manager!= null) {
                manager.getTransaction().commit();// We close transaction manager
                manager.close();
            }
        }
        return null;
    }



    //We delete employee by id
    public void deleteEmployee(Long id) {
        EntityManager manager = null;
        try {
            manager = getEntityManager(); //We open transaction manager
            manager.getTransaction().begin();
            Employee employee = manager.find(Employee.class, id);
            manager.remove(employee);
            manager.getTransaction().commit();// We close transaction manager

        } catch (RuntimeException e) {
            JOptionPane.showConfirmDialog(null, "User could not be deleted succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (manager!= null) {
                manager.close();
            }
        }
    }


    //We list all employees
    public List<Employee> ListEmployee() {
        EntityManager manager = null;
        List<Employee> employees = null;
        try {

            manager = getEntityManager();
            manager.getTransaction().begin();//We open transaction manager
            employees = manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();//Returns the list of employees
            manager.getTransaction().commit();// We close transaction manager

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Employee could not be listed succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (manager!= null) {
                manager.close();
            }
        }
        return employees;

    }


    //Find employees by their employee title
    public List<Employee> findEmployee(String jobTitle) {
        EntityManager manager = getEntityManager();
        try {
            //We create the query to obtain the employees for your order
            Query queryEmployees = manager.createQuery(
                    "SELECT em FROM Employee em WHERE em.jobTitle = :jobTitle",
                    Employee.class
            );// Returns our position in the company

            queryEmployees.setParameter("jobTitle", jobTitle);
            List<Employee> employees = queryEmployees.getResultList(); //We get the results of the list from the database
            return employees;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Employee could not be listed succesfully", "Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            if (manager!= null) {
                manager.close();
            }
        }
        return null;

    }


}
