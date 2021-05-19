package project.main;


import project.service.*;

public class Main {
    public static void main(String[] args){
        ServiceUser serviceUser = new ServiceUser();
        serviceUser.Menu();
        serviceUser.printRestaurants();


    }
}
