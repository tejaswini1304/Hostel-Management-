package college_project;

import java.util.Scanner;

class Visitor // node to collect data of Visitors
{
    String name;
    long contact;
    visitor next;
    String purpose;
    String intime;

    Visitor(String nam, long c, String purpose, String intime) {
        name = nam;
        contact = c;
        this.purpose = purpose;
        this.intime = intime;
        next = null;

    }

}

class entry_exit {
    Scanner sc1 = new Scanner(System.in);
    student ob1 = new student();
    visitor ptr = null;
    visitor head = null;
    int no = 0;

    void entry(node root) {
        Scanner c1=new Scanner(System.in);
        Scanner c2=new Scanner(System.in);

        System.out.print("  1.Enter Id : ");
        String id = c1.nextLine();
        int flag1 = ob1.search(root,id);
        if (flag1 != 1) {
            System.out.print("  2.Enter Name : ");
            String name = c1.nextLine();
            System.out.print("  3.Enter Contact number : ");
            long c = c2.nextLong();
            while((Long.toString(c)).length()!=10) {
                System.out.println("  Invalid phone number !");
                System.out.println("  Enter valid phone number: ");
                c=c2.nextLong();
            }
            System.out.print("  4.Enter In-time : ");
            String intime = c1.nextLine();
            System.out.print("  5.Enter Purpose of Visit : ");
            String purpose = sc1.nextLine();

            visitor temp = new visitor(name, c, purpose, intime);

            if (head == null)// When no visitors are there
            {
                head = temp;
                no++;
                //System.out.println("First Visitor");// To be removed later
            } else {
                ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
                no++;
                System.out.println("____ Visitor successfully Entered!____");
                System.out.println("\n ====================================================================================");
            }
        } else {
            System.out.println("\n-------------Student is a hosteller---------- ");
        }
    }

    void exit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Enter Name to be exited : ");
        String key = sc.next();
        ptr = head;
        visitor prev;
        int flag = 0;
        if (head == null) {
            System.out.println("\n _____________No Visitors present____________\n");
        } else if (key.compareToIgnoreCase(head.name) == 0) {
            head = ptr.next;
            flag++;
            no--;
            // System.out.println("Deleting head");

        } else {
            while (ptr.next != null) {
                prev = ptr;
                ptr = ptr.next;
                if (ptr.name.compareToIgnoreCase(key) == 0) {
                    prev.next = ptr.next;
                    no--;
                    flag++;
                    break;
                }

            }
        }
        if (flag == 1) {
            System.out.println("\n______Visitor Exited Successfully___\n");
        } else {
            System.out.println("\n Visitor Not found !! ");
        }
        viewVisitors();

    }

    void viewVisitors() {
        System.out.println("\n=====================VISITORS CURRENTLY IN HOSTEL PREMISES========================================\n");
        System.out.println("\n Number: " + no + " \n ");
        ptr = head;
        System.out.format("%-20s %-20s %-10s %-10s \n", "Name ", "Contact Number  ", "Purpose ", "In-time  ");
        while (ptr != null) {
            System.out.format("%-20s %-20s %-10s %-10s \n", ptr.name, ptr.contact, ptr.purpose, ptr.intime);
            ptr = ptr.next;
            System.out.println("");
        }
        System.out.println("\n====================================================================================\n");
    }
}
