package college_project;
import java.util.Scanner;

public class Hostel_management {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        student ob = new student(5);
        entry_exit obj = new entry_exit();
        register obr = new register();
        complaint_Queue obc = new complaint_Queue();
        nightout_functions night = new nightout_functions();
        int ans;


        do {
            System.out.print("\n\n============================================= DEEPRATNA HOSTEL ==========================================================\n\n");
            System.out.format("%-30s %-30s %-30s %-30s\n", "1.Admission ", "2.Student details   ", "3.Visitor Entry  ", "4.Visitor Exit \n ");
            System.out.format("%-30s %-30s %-30s \n", "5.Visitor details ", "6.Mess Registration   ", "7.Mess registration details \n");
            System.out.format("%-30s %-30s %-30s %-30s\n", "8.Lodge a Complaint ", "9.Resolve a Complaint   ", "10.View Complaint Queue ", "11.Search Student \n ");
            System.out.format("%-30s %-30s %-30s \n", "12.Fill out Night-out Form  ", "13.Students on NightOut ", "14.Return from Nightout \n ");
            System.out.print("----------------------------------------------------------------------------------------------------------------------------------");

            System.out.print("\n\n Enter you choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.accept();
                    ob.create();
                    break;
                case 2:
                    System.out.print("\n\n-------------------------------------------------------------------------------------------------------------\n");
                    System.out.format("%-10s %-20s %-25s %-15s %-15s\n", "ROOM NO ", "Name  ", "College Name   ", "Branch  ", "Roll No  ");
                    System.out.print("-------------------------------------------------------------------------------------------------------------\n");

                    ob.display(ob.root);
                    break;
                case 3:

                    obj.entry(ob.root);
                    break;
                case 4:
                    obj.exit();
                    break;
                case 5:
                    obj.viewVisitors();
                    break;
                case 6:
                    obr.add(ob.root);
                    break;
                case 7:
                    obr.display();
                    break;
                case 8:
                    obc.lodge(ob.root);
                    break;
                case 9:
                    obc.resolve();
                    break;
                case 10:
                    obc.display();
                    break;
                case 11:
                    Scanner in=new Scanner(System.in);
                    System.out.print(" Enter Hostel ID to be searched: ");
                    String id = in.nextLine();
                    ob.search(ob.root, id);
                case 12:
                    night.create(ob.root);
                    break;
                case 13:
                    night.display();
                    break;
                case 14:
                    night.delete();
                    break;

                default:
                    System.out.println("\n Please Enter Correct Choice ");
                    break;
            }
            System.out.print("-----------------------------------------------------------------------------------------------");
            System.out.print("\n Do you want to continue? Yes:1 No:0: ");
            ans = sc.nextInt();
        } while (ans == 1);
    }
}
