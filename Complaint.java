package college_project;
import java.util.Scanner;
class complaint// Implementing Queue Using LL
{
    String name;
    int room_no;
    String date;
    String description;
    complaint next;

    complaint(String name, int room_no, String date, String description) {
        this.name = name;
        this.room_no = room_no;
        this.date = date;
        this.description = description;
        next = null;
    }
}

class complaint_Queue {
    Scanner sc = new Scanner(System.in);
    complaint front = null;
    complaint rear = null;
    complaint ptr;
    int no = 0;

    void lodge(node root) {
        Scanner sc123=new Scanner(System.in);
        student bj=new student();
        int choice;
        do {
            System.out.print("\n Enter HostelID : ");
            String id = sc123.nextLine();
            int flag2 = bj.search(root,id);
            if (flag2 == 1) {
                System.out.print("1.Enter name : ");
                String name = sc.next();
                System.out.print("2.Enter Room No : ");
                int room_no = sc.nextInt();
                System.out.print("3.Enter date of Complaint : ");
                String date = sc.next();
                System.out.print("4.Enter description of Complaint : ");
                String description = sc.next();
                complaint temp = new complaint(name, room_no, date, description);
                if (front == null)// When Queue is empty
                {
                    front = temp;
                    rear = front;
                    //System.out.println("Added first node");
                    no++;
                } else {
                    rear.next = temp;
                    rear = rear.next;
                    no++;
                    System.out.println("\n_______________Successfully lodged your complaint____________________\n ");
                }
            }else {
                System.out.println("Invalid ID !");
            }
            System.out.print(" Do you want to add more?\t Yes:1 No:0 : ");
            choice = sc.nextInt();
        } while (choice != 0);

    }

    void resolve() {
        if (front == null) {
            System.out.println("\n___________No Complaints present_____________\n");
        } else {
            System.out.println(" --------------------------- Details of Resolved Complaint-------------------\n");
            System.out.format("%-15s %-20s %-15s %-25s\n", "DATE  ", "NAME   ", "Room No  ", "Complaint  ");
            System.out.format("%-15s %-20s %-15s %-25s\n", front.date, front.name, front.room_no, front.description);
            System.out.println(" -------------------------------------------------------------------------------\n");
            front = front.next;
            no--;
        }
    }

    void display() {
        System.out.println("\n No. of Unresolved Complaints : " + no);
        if (front == null) {
            System.out.println("\n_____________No Complaints in Queue________________\n");
        } else {
            ptr = front;
            System.out.format("%-15s %-20s %-15s %-25s\n", "DATE  ", "NAME   ", "Room No  ", "Complaint  ");

            while (ptr != null) {
                System.out.format("%-15s %-20s %-15s %-25s\n", ptr.date, ptr.name, ptr.room_no, ptr.description);
                System.out.println("");
                ptr = ptr.next;
            }
            //System.out.println("\n=================================================================================================");
        }
    }
}

class nightout// Create a linked list update into Students Info in the BST(Create new
//attribute in BST)
{Scanner sc = new Scanner(System.in);

    String outgoing;
    String incoming;
    int days;
    String name;
    int roomno;
    String Id;
    String address;
    long contactno;
    nightout next;
//student obj = new student();

    nightout(String outgoing, String incoming, int days, String name, int roomno, String address, long contactno, String id) {
        this.outgoing = outgoing;
        this.incoming = incoming;
        this.days = days;
        this.name = name;
        this.address = address;
        this.roomno = roomno;
        this.contactno = contactno;
        this.Id = id;
        next = null;

    }

}

class nightout_functions// Still have to write function to compare data entered with that of student
//records in BST
{
    Scanner sc1 = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    nightout head = null;
    nightout ptr;
    student obj = new student();


    void display() {
        ptr = head;
        if (head == null) {
            System.out.println("\n___________Noboby is on Nightout_______________\n");
        } else {
            System.out.println("\n xxxxxxxxxx NIGHT OUT LIST XXXXXXXXXXXXXX\n");
            while (ptr != null) {
                System.out.println("Id:" + ptr.Id + "\tRoom No:" + ptr.roomno + "\tName:" + ptr.name + "\tOutgoing Date:" + ptr.outgoing
                        + "\tIncoming Date:" + ptr.incoming + "\tNo of Days:" + ptr.days + "\tAddress:" + ptr.address
                        + "\tContact No:" + ptr.contactno);
                System.out.println(" ");
                ptr = ptr.next;
            }
        }
    }

    void create(node root) {// To input Students in Night out LL
        Scanner b1=new Scanner(System.in);
        System.out.print("  1.Enter Id : ");
        String id = b1.nextLine();
        int flag2 = obj.search(root,id);

        if (flag2 == 1) {
            Scanner sc = new Scanner(System.in);
            System.out.print("  2.Enter Room no :");
            int roomno = sc.nextInt();
            System.out.print("  3.Enter Name : ");
            String name = b1.nextLine();
            System.out.print("  4.Enter outgoing date : ");
            String outgoing = sc.next();
            System.out.print("  5.Enter Incoming Date: ");
            String incoming = sc.next();
            System.out.print("  Enter no of days: ");
            int days = sc.nextInt();
            System.out.print("  6.Enter Address : ");
            String address = sc1.nextLine();
            System.out.print("  7.Enter Contact no : ");
            long contactno = sc.nextLong();
            while((Long.toString(contactno)).length()!=10) {
                System.out.println("Invalid phone number !");
                System.out.println("Enter valid phone number !");
                contactno = sc.nextLong();
            }

            nightout temp = new nightout(outgoing, incoming, days, name, roomno, address, contactno, id);


            if (head == null)// If no nightouts are present;
            {
                head = temp;
                //System.out.println("\n Successfully added head node");// To be removed later
            } else// When LL already exists
            {
                ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
                //System.out.println("\n Succesfully added not head node");// To be removed later
            }


        } else {
            System.out.println("\n _______No Such Student Id found sorry_______");
        }
    }

    void delete()// ie when someone comes back from nightout
    {
        nightout prev = null;
        int flag2 = 0;
        ptr = head;
        if (head == null) {
            System.out.println("\n ___No Students are on Night Out__");
        } else {
            System.out.print("\n Enter your ID : ");
            String ID = sc.next();
            if (ptr.Id.compareToIgnoreCase(ID) == 0)//Deleting first node
            {   //System.out.println("Inside head case");
                head = ptr.next;
                flag2++;
            } else {
                while (ptr.next != null) {
                    prev = ptr;
                    ptr = ptr.next;
                    if (ptr.Id.compareToIgnoreCase(ID) == 0) {
                        prev.next = ptr.next;
                        flag2 = flag2 + 1;
                        // System.out.println("flag has been put to 1");
                        break;
                    }
                }
            }
            if (flag2 == 1) {
                System.out.println("You have Successfully Returned!");
            } else {
                System.out.println("\n_______No such student Id found_______\n");
            }
        }
    }
}
