package project.service;
import project.classes.*;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFile{

        private static WritingFile single_instance = null;


        private WritingFile()
        {}

        public static WritingFile getInstance()
        {
            if (single_instance == null)
                single_instance = new WritingFile();

            return single_instance;
        }
//        public void WriteRestaurants(Restaurant r){
//            try {
//                FileWriter f = new FileWriter("src/project/Files/RestaurantsCSV.csv",true);
//                    String data = r.getRestaurantName() + ',' +r.getCategory() + ',' +r.getMinimumOrder() + ',' + r.getScore() + ',' + r.getCity() + ',' +r.getFoodMeniu() + r.getDrinkMeniu() + '\n';
//                    f.write(data);
//                    f.flush();
//
//            } catch(IOException e){
//                System.out.println("Error");
//            }
//        }
//
//    public void WriteDrivers(Driver d){
//        try {
//            FileWriter f = new FileWriter("src/project/Files/DriversCSV.csv",true);
//                String data = d.getFirstName() + ',' + d.getLastName() + ',' + d.getEmail() + ',' + d.getAge()+ ',' + d.getPhoneNumber()+ ','+ d.getEmployeeId() + ',' + d.getCarRegistrationNumber() + ',' + d.getCity() + '\n';
//                f.write(data);
//                f.flush();
//        } catch(IOException e){
//            System.out.println("Error");
//        }
//    }
//
//    public void WriteUsers(User u){
//        try {
//            FileWriter f = new FileWriter("src/project/Files/UsersCSV.csv",true);
//
//                String data = u.getFirstName() + ',' + u.getLastName() + ',' + u.getEmail() + ',' + u.getAge()+ ',' + u.getPhoneNumber()+ ',' + u.getAddress().getCity() +',' + u.getAddress().getStreet() + ',' + u.getAddress().getNumber() + ',' + u.getAddress().getApartment() + ',' + u.getCard().getCardNumber() + ',' + u.getCard().getExpireDate() + ',' + u.getCard().getSecurityCode() + '\n';
//                f.write(data);
//                f.flush();
//
//        } catch(IOException e){
//            System.out.println("Error");
//        }
//    }
//    public void WriteOrders(Order o){
//        try {
//            FileWriter f = new FileWriter("src/project/Files/OrdersCSV.csv",true);
//            Restaurant r = o.getRestaurant();
//            User u = o.getUser();
//            Driver d = o.getDriver();
//
//            String data = o.getOrderNumber() + "," + o.getOrderDate() + ',' + o.getDeliveryTime() + ',' + r.getRestaurantName() + ',' +r.getCategory() + ',' +r.getMinimumOrder() + ',' + r.getScore() + ',' + r.getCity() + ',' +r.getFoodMeniu() + r.getDrinkMeniu() + ',' + d.getFirstName() + ',' + d.getLastName() + ',' + d.getEmail() + ',' + d.getAge()+ ',' + d.getPhoneNumber()+ ','+ d.getEmployeeId() + ',' + d.getCarRegistrationNumber() + ',' + d.getCity() + ','+ u.getFirstName() + ',' + u.getLastName() + ',' + u.getEmail() + ',' + u.getAge()+ ',' + u.getPhoneNumber()+ ',' + u.getAddress().getCity() +',' + u.getAddress().getStreet() + ',' + u.getAddress().getNumber() + ',' + u.getAddress().getApartment() + ',' + u.getCard().getCardNumber() + ',' + u.getCard().getExpireDate() + ',' + u.getCard().getSecurityCode()+'\n';
//            f.write(data);
//            f.flush();
//
//        } catch(IOException e){
//            System.out.println("Error");
//        }
//    }

    public <T> void Writing (T obj){
        if (obj instanceof Restaurant){
            try {
                FileWriter f = new FileWriter("src/project/Files/RestaurantsCSV.csv",true);
                String data = ((Restaurant)obj).getRestaurantName() + ',' +((Restaurant)obj).getCategory() + ',' +((Restaurant)obj).getMinimumOrder() + ',' + ((Restaurant)obj).getScore() + ',' + ((Restaurant)obj).getCity() + ',' +((Restaurant)obj).getFoodMeniu() + ((Restaurant)obj).getDrinkMeniu() + '\n';
                f.write(data);
                f.flush();

            } catch(IOException e){
                System.out.println("Error");
            }
        }

        if(obj instanceof Driver){
            try {
                FileWriter f = new FileWriter("src/project/Files/DriversCSV.csv",true);
                String data = ((Driver)obj).getFirstName() + ',' + ((Driver)obj).getLastName() + ',' + ((Driver)obj).getEmail() + ',' + ((Driver)obj).getAge()+ ',' + ((Driver)obj).getPhoneNumber()+ ','+ ((Driver)obj).getEmployeeId() + ',' + ((Driver)obj).getCarRegistrationNumber() + ',' + ((Driver)obj).getCity() + '\n';
                f.write(data);
                f.flush();
            } catch(IOException e){
                System.out.println("Error");
            }
        }
        if(obj instanceof User){
            try {
                FileWriter f = new FileWriter("src/project/Files/UsersCSV.csv",true);

                String data = ((User)obj).getFirstName() + ',' + ((User)obj).getLastName() + ',' + ((User)obj).getEmail() + ',' + ((User)obj).getAge()+ ',' + ((User)obj).getPhoneNumber()+ ',' + ((User)obj).getAddress().getCity() +',' + ((User)obj).getAddress().getStreet() + ',' + ((User)obj).getAddress().getNumber() + ',' + ((User)obj).getAddress().getApartment() + ',' + ((User)obj).getCard().getCardNumber() + ',' + ((User)obj).getCard().getExpireDate() + ',' + ((User)obj).getCard().getSecurityCode() + '\n';
                f.write(data);
                f.flush();

            } catch(IOException e){
                System.out.println("Error");
            }
        }
        if(obj instanceof Order){
            try {
                FileWriter f = new FileWriter("src/project/Files/OrdersCSV.csv",true);
                Restaurant r = ((Order)obj).getRestaurant();
                User u = ((Order)obj).getUser();
                Driver d = ((Order)obj).getDriver();

                String data = ((Order)obj).getOrderNumber() + "," + ((Order)obj).getOrderDate() + ',' + ((Order)obj).getDeliveryTime() + ',' + r.getRestaurantName() + ',' +r.getCategory() + ',' +r.getMinimumOrder() + ',' + r.getScore() + ',' + r.getCity() + ',' +r.getFoodMeniu() + r.getDrinkMeniu() + ',' + d.getFirstName() + ',' + d.getLastName() + ',' + d.getEmail() + ',' + d.getAge()+ ',' + d.getPhoneNumber()+ ','+ d.getEmployeeId() + ',' + d.getCarRegistrationNumber() + ',' + d.getCity() + ','+ u.getFirstName() + ',' + u.getLastName() + ',' + u.getEmail() + ',' + u.getAge()+ ',' + u.getPhoneNumber()+ ',' + u.getAddress().getCity() +',' + u.getAddress().getStreet() + ',' + u.getAddress().getNumber() + ',' + u.getAddress().getApartment() + ',' + u.getCard().getCardNumber() + ',' + u.getCard().getExpireDate() + ',' + u.getCard().getSecurityCode()+'\n';
                f.write(data);
                f.flush();

            } catch(IOException e){
                System.out.println("Error");
            }

        }

    }
}
