package project.service;

import project.csvService.Audit;
import project.csvService.ReadingFile;
import project.csvService.WritingFile;
import project.models.*;
import project.repository.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DriverService {
    private static List<Driver> registeredDrivers = new ArrayList<>();
    public WritingFile write = WritingFile.getInstance();
    public ReadingFile r = ReadingFile.getInstance();
    public Audit audit = Audit.getInstance();

    public void MenuContent(){
        System.out.println("--------------------------------Driver Services-----------------------------------");
        System.out.println("======================================================================================");
        System.out.println("1. Register a new driver.");
        System.out.println("2. Show all drivers.");
        System.out.println("3. Edit driver by id.");
        System.out.println("4. Delete driver by id.");
        System.out.println("0. Exit.");
    }
    public void Menu(){
        int option = -1;
        Scanner read = new Scanner(System.in);
        Scanner readInt = new Scanner(System.in);
        ///Etapa 2:
        //Driver driverT = new Driver();
        //registeredDrivers = r.Reading(driverT);

        ///Etapa 3:
        DriverRepository driverRepository = new DriverRepository();
        registeredDrivers = driverRepository.getAllDrivers();
        while (option != 0) {
            MenuContent();
            System.out.println("Type the option number: ");
            option = readInt.nextInt();
            if (option == 1) {
                System.out.println("                     Register a new Driver!                                ");
                System.out.println("===========================================================================");
                try {
                    System.out.println("Employee Id: ");
                    int employeeId = readInt.nextInt();
                    System.out.println("First name: ");
                    String firstName = read.nextLine();
                    System.out.println("Last name: ");
                    String lastName = read.nextLine();
                    System.out.println("Email: ");
                    String email = read.nextLine();
                    System.out.println("Age: ");
                    int age = readInt.nextInt();
                    System.out.println("Phone number: ");
                    String phoneNumber = read.nextLine();
                    System.out.println("Car Registration Number: ");
                    String carRegistrationNumber = read.nextLine();
                    System.out.println("City: ");
                    String city = read.nextLine();
                    Driver driver = new Driver(employeeId, firstName, lastName, email, age, phoneNumber, carRegistrationNumber, city);
//                    Etapa 2
//                    write.Writing(driver);
//                    registeredDrivers = r.Reading(driver);
//                    Etapa 3
                    driverRepository.insertDrivers(driver);
                    registeredDrivers = driverRepository.getAllDrivers();
                    System.out.println("Driver registered successfully!");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }

//                audit.auditMethod(option);
            }
            if (option == 2) {
                registeredDrivers.clear();
                registeredDrivers = driverRepository.getAllDrivers();
                printDrivers();
                ///audit.auditMethod(option);
            }
            if (option == 3) {
                    System.out.print("                     Edit a driver by id!                                    ");
                    System.out.println("===========================================================================");
                    int edit = -1;
                    System.out.println("Enter the id of the driver you want to edit: ");
                    int id = readInt.nextInt();
                    while (edit != 0) {
                        System.out.println("What do you want to edit?");
                        System.out.println("1.First Name; 2. Last Name; 3.Email");
                        System.out.println("4.Age; 5.Phone Number; 6.Car Registration Number; 7.City; 0.Exit");
                        try {
                            edit = readInt.nextInt();
                            if (edit == 1) {
                                System.out.println("First Name: ");
                                String firstName = read.nextLine();
                                driverRepository.updateDriverFirstName(firstName,id);

                            }
                            if (edit == 2) {
                                System.out.println("Last Name: ");
                                String lastName = read.nextLine();
                                driverRepository.updateDriverLastName(lastName,id);
                            }
                            if (edit == 3) {
                                System.out.println("Email: ");
                                String email = read.nextLine();
                                driverRepository.updateDriverEmail(email,id);

                            }
                            if (edit == 4) {
                                System.out.println("Age: ");
                                int age = readInt.nextInt();
                                driverRepository.updateDriverAge(age,id);
                            }
                            if (edit == 5) {
                                System.out.println("Phone number: ");
                                String phoneNumber = read.nextLine();
                                driverRepository.updateDriverPhoneNumber(phoneNumber,id);
                            }
                            if (edit == 6) {
                                System.out.println("Car Registration Number: ");
                                String carNumber = read.nextLine();
                                driverRepository.updateDriverCarNumber(carNumber,id); ;
                            }
                            if (edit == 7) {
                                System.out.println("City: ");
                                String city = read.nextLine();
                                driverRepository.updateDriverCity(city,id);
                            }
                            System.out.println("Edit successful!");
                        }
                        catch(InputMismatchException e){
                            System.out.println("Please make sure all fields are filled in correctly.");
                            readInt.next();
                        }
                    }

                registeredDrivers = driverRepository.getAllDrivers();
//              audit.auditMethod(option);
            }
            if (option == 4) {
                System.out.println("Enter the id of the driver you want to delete: ");
                int id = readInt.nextInt();
                driverRepository.deleteDriverbyId(id);
                registeredDrivers = driverRepository.getAllDrivers();
            }

        }
    }
    public static List<Driver> getRegisteredDrivers() {
        return registeredDrivers;
    }

    public void printDrivers() {
        System.out.println(registeredDrivers);
    }
}
