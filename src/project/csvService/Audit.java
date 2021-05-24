package project.csvService;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;

public class Audit {

    private static Audit single_instance = null;


    private Audit() {
    }

    public static Audit getInstance() {
        if (single_instance == null)
            single_instance = new Audit();

        return single_instance;
    }

    public void auditMethod(int option){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        try {
            FileWriter f = new FileWriter("src/project/Files/AuditCSV.csv", true);
            String data = option + ',' + timeStamp + ',';

        switch(option) {
            case 0:
                data = data + "Exit";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 1:
                data = data + "Add Restaurant";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 2:
                data = data + "Add foods to a restaurant.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 3:
                data = data + "Add drinks to a restaurant.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 4:
                data = data + "Add drivers.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 5:
                data = data + "Register users.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 6:
                data = data + "Login user.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 7:
                data = data + "Edit current user.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 8:
                data = data + "Show all local restaurants and place order.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 9:
                data = data + "Show all local drivers.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 10:
                data = data + "Show all current user's orders.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 11:
                data = data + "Show current user info.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
            case 12:
                data = data + "Show all restaurants.";
                f.write(data);
                f.write("\n");
                f.flush();
                break;
    }
        } catch(IOException e){
            System.out.println("Error");
        }
}
}