package org.example.util;

import org.example.logic.Employee;
import org.example.persistence.PersistenceController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Validation {
    static PersistenceController controller = new PersistenceController();
    static Employee employee = null;
    public static void employeeNotFound(Long id){
        List<Employee> employeById = controller.getEmployees();
        boolean employeeExists = false;
        for (Employee em : employeById){
            if (em.getId() == id){
                employeeExists = true;
                break;
            }
        }
        if (employeeExists){
            controller.findEmployeeById(id);
        }else {
            System.out.println("Employee doesn´t exist");
            System.out.println("look for another employees");
        }
    }

    public static List<Employee> findEmployee(String jobTitle){
        List<Employee> employeById = controller.getEmployees();
        boolean employeeExists = false;
        for (Employee em : employeById){
            if (em.getJobTitle().equalsIgnoreCase(jobTitle)){
                employeeExists = true;
                break;
            }
        }

        if (employeeExists){
            return controller.findEmployeeByPositio(jobTitle);
        }else {
            System.out.println("Employee doesn´t exist");
            System.out.println("look for another employees");

        }
        return employeById;
    }



    public static void avoidDuplicateEmployess(String name, String lastName){
        List<Employee>employeeDuplicate = controller.getEmployees();
        boolean employeeExists = false;
        //I compare the values in the database with the values that I enter
        for (Employee em : employeeDuplicate){
            if (em.getName().equalsIgnoreCase(name) && em.getSurname().equalsIgnoreCase(lastName)){
                employeeExists = true;
                break;
            }

        }

        if (employeeExists) {
            System.out.println("Employee you already exist.");
            System.out.println();
        } else {
            if (!name.matches(".*\\d.*") && !lastName.matches(".*\\d.*")) {
                // Agregar empleado a la base de datos
                controller.createEmployee(employee);
                System.out.println("Thank you! Employee created successfully.");
                System.out.println();
            } else {
                System.out.println("Invalid first or last name. The employee was not added to the database.");
                System.out.println();
            }


        }
    }


    public static double validateSalary(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            // Replace any comma with a period
            input = input.replace(',', '.');
            if (input.isBlank()) {
                System.out.println("Salary cannot be empty. Please enter a valid value.");
            } else{
                try {
                    double validatedSalary = Double.parseDouble(input);
                    if (validatedSalary >= 0) {
                        return validatedSalary;
                    } else {
                        System.out.println("Invalid salary, please enter a non-negative value.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    System.out.println("Exception details: " + e.getMessage()); // Imprime detalles de la excepción
                }
            }
        }
    }



    public static String validateString(String data) {
        while (true) {
            if (data != null &&  !data.isEmpty() && !data.matches(".*\\d.*") && !data.isBlank()) {
                return data;
            } else {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid name, please enter a valid name or last name");
                data = scanner.nextLine();
            }
        }

    }


    public static LocalDate validateEmployeeDateRegistration(Scanner scanner) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean validaDate = false;
        LocalDate daleEmployment = null;
        while (!validaDate) {

            String dateInput = scanner.nextLine();
            if ( dateInput.isEmpty()) {//We validate that the field is not empty
                System.out.println("Invalid date. Please enter a valid date in the format dd-MM-yyyy");
                continue;
            }
            try {
                daleEmployment = LocalDate.parse(dateInput, dateFormatter);

                //We check that the date is not in the future
                if (daleEmployment.isAfter(LocalDate.now())) {
                    System.out.println("The registration date cannot be later than the date: " + LocalDate.now() + ". Please enter a valid date");
                }else {
                    validaDate = true;
                }

            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date in the format dd-MM-yyyy");
            }
        }

        return  daleEmployment;
    }



}
