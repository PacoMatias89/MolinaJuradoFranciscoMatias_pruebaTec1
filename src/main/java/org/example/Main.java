package org.example;

import org.example.logic.Employee;
import org.example.persistence.PersistenceController;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Main {
    static PersistenceController controller = new PersistenceController();
    static Employee employee = null;


    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean exits = false;
        int option = 0;



        //Create


        do {
            System.out.println("Choose one of the options: ");
            System.out.println("**********************************");
            System.out.println("* 1. Enter an employee           *");
            System.out.println("* 2. List employees              *");
            System.out.println("* 3. Update employee             *");
            System.out.println("* 4. Delete employee             *");
            System.out.println("* 5. Search employee by position *");
            System.out.println("* 6. Exit                        *");
            System.out.println("**********************************");
            System.out.print("Select option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    scanner.nextLine();

                    employee = new Employee();
                    boolean validName = false;
                    /***************************** block to enter employee data ***************************************************/
                    System.out.println("Enter the employee's name: ");
                    String name = scanner.nextLine();
                    String validateName = validateName(name);


                    System.out.println("Enter the employee's last name ");
                    String lastName = scanner.nextLine();
                    String validateLastName = validateLastName(lastName);

                    System.out.println("Enter the employee's job title: ");
                    String jobTitle = scanner.nextLine();
                    String validateJobTitle = validateJobTitle(jobTitle);

                    System.out.println("Enter the employee's salary: ");
                    double validateSalary = validateSalary(scanner);


                    System.out.println("Enter the employee's date of employment (dd-MM-yyyy): ");
                    LocalDate dateEmployment = validateEmployeeDateRegistration(scanner);

                    //We verify that the user does not exist


                    employee = new Employee(null, validateName, validateLastName, validateJobTitle, validateSalary, dateEmployment);
                    /************************************ End of the block to enter employee data ***********************************/

                    avoidDuplicateEmployess(validateName, validateLastName);

                    break;

                case 2:
                    List<Employee> employees = controller.getEmployees();
                    System.out.println();
                    System.out.println("------------Employee data--------------");
                    for (Employee em : employees) {
                        System.out.println(em);
                        System.out.println("----------------------------------------");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the ID of the employee to search: ");
                    Long id = scanner.nextLong();
                    employeeNotFound(id);
                    List<Employee> employeById = controller.getEmployees();
                    for (Employee em : employeById) {
                        if (em.getId() == id) {
                            System.out.println();
                            System.out.println("------Employed before being modified------");
                            System.out.println(em);
                            System.out.println();
                            /***************************** block to enter employee update data ***************************************************/
                            System.out.println("Enter the employee's name : ");
                            scanner.nextLine();
                            String nameUpdate = scanner.nextLine();
                            validateName(nameUpdate);


                            System.out.println("Enter the employee's last name ");
                            String lastnameUpdate = scanner.nextLine();
                            validateName(lastnameUpdate);

                            System.out.println("Enter the employee's job title: ");
                            String jobTitleUpdate = scanner.nextLine();
                            validateJobTitle(jobTitleUpdate);

                            System.out.println("Enter the employee's salary: ");
                            double salaryUpdate = validateSalary(scanner);

                            System.out.println("Enter the employee's date of employment (dd-MM-yyyy): ");
                            LocalDate dateEmploymentUpdate = validateEmployeeDateRegistration(scanner);
                            /************************************ End of the block to enter employee update data ***********************************/

                            em.setName(nameUpdate);
                            em.setJobTittle(jobTitleUpdate);
                            em.setSalary(salaryUpdate);
                            em.setDateEmployment(dateEmploymentUpdate);


                            System.out.println();
                            System.out.println("------Employed after being modified------");
                            System.out.println(em);
                            System.out.println();
                            controller.updateEmploye(em);

                        }
                    }

                    break;
                case 4:
                    System.out.println("Enter employee ID to delete: ");
                    Long idDelete = scanner.nextLong();
                    Employee employeByIdDelete = null;
                    boolean foundEmployee= false;
                    employeeNotFound(idDelete);

                    //we find the employee first
                    for (Employee em : controller.getEmployees()) {
                       if (em.getId() == idDelete){
                           employeByIdDelete = em;
                           foundEmployee = true;
                           break;
                       }

                    }

                    // If we find the employee, we delete it
                    scanner.nextLine();
                    if (foundEmployee){
                        System.out.println("Employee found:");
                        System.out.println(employeByIdDelete);

                        System.out.println("Are you sure you want to delete this employee? (Y/N): ");
                        String confirm = scanner.nextLine();
                        System.out.println();
                        if (confirm.equals("Y") || confirm.equals("y")) {
                            controller.deleteEmployee(employeByIdDelete.getId());
                            System.out.println("Employee deleted successfully.");
                            System.out.println();
                        } else {
                            System.out.println("Deletion canceled.");
                            System.out.println();
                        }
                    }else {
                        System.out.println("Employee not found..");
                        System.out.println();
                    }

                    break;
                case 5:
                    System.out.println("Enter the position of the employee to search: ");
                    scanner.nextLine();
                    String position = scanner.nextLine();
                    List<Employee> employeByPosition = findEmployee(position);

                    for (Employee em : employeByPosition) {
                        if (em.getJobTitle().equalsIgnoreCase(position)) {
                            System.out.println();
                            System.out.println(em);
                            System.out.println("----------------------------------------");
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Are you sure you want exit program? (Y/N): ");
                    String exitProgram = scanner.nextLine();

                    if (exitProgram.equalsIgnoreCase("Y")){
                        exits = true;
                        System.out.println("Bye....");
                    }else if (exitProgram.equalsIgnoreCase("N")){

                        break;
                    }
            }


        } while (!exits);


    }

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



    public static String validateName(String name) {
        while (true) {
            if (name != null &&  !name.isEmpty() && !name.matches(".*\\d.*")) {
                return name;
            } else {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid name, please enter a valid name");
                name = scanner.nextLine();
            }
        }

    }

    public static String validateLastName(String lastName) {
        while (true) {
            if (lastName != null && !lastName.isEmpty() && !lastName.matches(".*\\d.*")) {
                return lastName;
            } else {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid last name, please enter a valid last name");
                lastName = scanner.nextLine();

            }
        }
    }


    public static String validateJobTitle(String jobTitle) {
        while (true) {
            if (jobTitle != null && !jobTitle.isEmpty() && !jobTitle.matches(".*\\d.*")) {
                return jobTitle;
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid jobTitle, please enter a valid jobTitle");
                jobTitle = scanner.nextLine();
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