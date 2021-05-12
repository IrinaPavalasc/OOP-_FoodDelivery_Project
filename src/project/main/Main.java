package project.main;


import project.classes.*;
import project.service.*;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//        ServiceUser serviceDriver = new ServiceUser();
//        serviceDriver.registerDrivers(111,"Marius","Popa","mariusp@gmia.com",39,"0716182321","B 111 RRR","Bucuresti");
//        serviceDriver.printDrivers();
//
//        ServiceUser serviceUser = new ServiceUser();
//        serviceUser.registerUser();
//        serviceUser.printUsers();
//
//
//        ServiceUser serviceRestaurant = new ServiceUser();
//        serviceRestaurant.registerRestaurants("Burger King", "Fast Food", 30,4.5, "Bucuresti");
//        serviceRestaurant.registerRestaurants("Chinese Garden", "Asian", 50,4.2, "Timisoara");
//        serviceRestaurant.registerRestaurants("Amaretto", "Desert", 40,4.8, "Bucuresti");
//
//        serviceRestaurant.addDrink("Chinese Garden", "Coca Cola", 6, 330, false);
//        serviceRestaurant.addFood("Burger King", "Burger", "Whooper", 15, 250, "Carne de vita, castraveti murati", 15);
////      serviceRestaurant.printRestaurants();
//
//
//        serviceUser.PlaceOrder(ServiceUser.getRegisteredUsers().get(0));
//        serviceUser.printOrders();


        ServiceUser serviceUser = new ServiceUser();
        serviceUser.Menu();
        serviceUser.printRestaurants();


    }
}
