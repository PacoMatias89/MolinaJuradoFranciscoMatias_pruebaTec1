package org.example;

import org.example.logic.Employee;
import org.example.persistence.PersistenceController;
import org.example.util.Validation;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Employee employee = null;
    static PersistenceController controller = new PersistenceController();
//    Validation validation = new Validation();


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
                    String validateName = Validation.validateString(name);


                    System.out.println("Enter the employee's last name ");
                    String lastName = scanner.nextLine();
                    String validateLastName = Validation.validateString(lastName);

                    System.out.println("Enter the employee's job title: ");
                    String jobTitle = scanner.nextLine();
                    String validateJobTitle = Validation.validateString(jobTitle);

                    System.out.println("Enter the employee's salary: ");
                    double validateSalary = Validation.validateSalary(scanner);


                    System.out.println("Enter the employee's date of employment (dd-MM-yyyy): ");
                    LocalDate dateEmployment = Validation.validateEmployeeDateRegistration(scanner);

                    //We verify that the user does not exist


                    employee = new Employee(null, validateName, validateLastName, validateJobTitle, validateSalary, dateEmployment);
                    /************************************ End of the block to enter employee data ***********************************/

                    Validation.avoidDuplicateEmployess(validateName, validateLastName);

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
                    Validation.employeeNotFound(id);
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
                            Validation.validateString(nameUpdate);


                            System.out.println("Enter the employee's last name ");
                            String lastnameUpdate = scanner.nextLine();
                            Validation.validateString(lastnameUpdate);

                            System.out.println("Enter the employee's job title: ");
                            String jobTitleUpdate = scanner.nextLine();
                            Validation.validateString(jobTitleUpdate);

                            System.out.println("Enter the employee's salary: ");
                            double salaryUpdate = Validation.validateSalary(scanner);

                            System.out.println("Enter the employee's date of employment (dd-MM-yyyy): ");
                            LocalDate dateEmploymentUpdate = Validation.validateEmployeeDateRegistration(scanner);
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
                    Validation.employeeNotFound(idDelete);

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
                    List<Employee> employeByPosition = Validation.findEmployee(position);

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


}