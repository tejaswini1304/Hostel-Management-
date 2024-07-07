package college_project;
import java.util.Scanner;
public  class Mess_Registration {
    int roomno;
    String name, Hostelid;
    int messno;

    messregistration(String Hostelid, int roomno, String name, int messno) {
        this.roomno = roomno;
        this.name = name;
        this.Hostelid = Hostelid;
        this.messno = messno;
    }
}

class register {
    Scanner sc = new Scanner(System.in);
    int roomno;
    String name, Hostelid;
    messregistration arr1[] = new messregistration[3];
    messregistration arr2[] = new messregistration[3];
    messregistration arr3[] = new messregistration[3];

    messregistration obj;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;

    boolean isfull(messregistration arr[], int count) {
        return count == arr.length;
    }

    boolean isempty(messregistration arr[], int count) {
        return count == 0;
    }

    void add(node root) {


        student obj = new student();
        int ans = 0;
        do {
            System.out.print("\n Enter Mess number :\n mess 1-> 1\n mess 2-> 2\n mess 3-> 3");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Scanner q1 = new Scanner(System.in);
                    Scanner q2 = new Scanner(System.in);
                    if (isfull(arr1, count1) == true) {
                        System.out.println("\n _______Mess Registration is full !_______\n");
                        break;

                    } else {
                        System.out.print("\n Enter HostelID : ");
                        Hostelid = q1.nextLine();
                        int flag2 = obj.search(root,Hostelid);
                        if (flag2 == 1) {
                            System.out.print("\n Enter name : ");
                            name = q2.nextLine();
                            System.out.print("\n Enter room number : ");
                            roomno = sc.nextInt();
                            messregistration var1 = new messregistration(Hostelid, roomno, name, choice);

                            arr1[count1] = var1;
                            count1++;
                        } else if(flag2!= 1) {
                            System.out.println("Invalid ID");
                        }
                    }
                    break;
                case 2:
                    Scanner q3 = new Scanner(System.in);
                    Scanner q4 = new Scanner(System.in);
                    if (isfull(arr2, count2) == true) {
                        System.out.println("\n _______Mess Registration is full !_______\n");
                        break;

                    } else {
                        System.out.print("\n Enter HostelID : ");
                        Hostelid = q3.nextLine();
                        int flag2 = obj.search(root,Hostelid);
                        if (flag2 == 1) {
                            System.out.print("\n Enter name : ");
                            name = q4.nextLine();
                            System.out.print("\n Enter room number : ");
                            roomno = sc.nextInt();
                            messregistration var2 = new messregistration(Hostelid, roomno, name, choice);

                            arr2[count2] = var2;
                            count2++;
                        } else if(flag2!= 1) {
                            System.out.println("Invalid ID");
                        }
                    }
                    break;
                case 3:
                    Scanner q5 = new Scanner(System.in);
                    Scanner q6 = new Scanner(System.in);
                    if (isfull(arr3, count3) == true) {
                        System.out.println("\n _______Mess Registration is full !________\n");
                        break;

                    } else {
                        System.out.print("\n Enter HostelID : ");
                        Hostelid = q5.nextLine();
                        int flag2 = obj.search(root,Hostelid);
                        if (flag2 == 1) {
                            System.out.print("\n Enter name : ");
                            name = q6.nextLine();
                            System.out.print("\n Enter room number : ");
                            roomno = sc.nextInt();
                            messregistration var3 = new messregistration(Hostelid, roomno, name, choice);

                            arr3[count3] = var3;
                            count3++;
                        }
                        else if(flag2!= 1) {
                            System.out.println("Invalid ID");
                        }
                    }
                    break;
                default:
                    System.out.println("invalid input !");
            }
            System.out.print("\n\t Want to register more ? yes=1/no=0:  ");
            ans = sc.nextInt();
        } while (ans == 1);
    }

    void call(messregistration arr[], int count) {
        if (isempty(arr, count) == true) {
            System.out.println("\n _______________No registration in mess___________\n");
        }
        System.out.format("%-20s %-15s %-15s %-15s\n", "Name  ", "Hostel Id   ", "Room No  ", "Mess No  ");

        for (int i = 0; i < count; i++) {
            System.out.format("%-20s %-15s %-15s %-15s\n", arr[i].name, arr[i].Hostelid, arr[i].roomno, arr[i].messno);
        }
        System.out.println("\n ================================================================= \n ");
    }

    void display() {

        this.call(arr1, count1);
        this.call(arr2, count3);
        this.call(arr3, count3);
    }


}
