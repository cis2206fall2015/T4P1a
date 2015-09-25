package ipTracker;

import java.util.Scanner;

/**
 *
 * @author Your Name Here
 */
public class ipTrackerApp {

    ipTrackerDAO ipList = new ipTrackerDAO();
    Scanner sc = new Scanner(System.in);

    public ipTrackerApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id, retrieved;
        String address, date;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\n IP Tracker App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(ipList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New employee ID: ");
                    address = Validator.getLine(sc, "IP Address: ");
                    date = Validator.getLine(sc, "Date Entered: ");
                    retrieved = 0;
                    ipList.createRecord(new ipTracker(id, address, date, retrieved));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Employee id to retrieve: ");
                    System.out.println(ipList.retrieveRecord(id));
                    
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    address = Validator.getLine(sc, "IP Address: ");
                    date = Validator.getLine(sc, "Enter current date: ");
                    retrieved = Validator.getInt;
                    ipList.updateRecord(new ipTracker(id, address, date, retrieved++));

                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(ipList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        ipList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ipTrackerApp();
    }
}
