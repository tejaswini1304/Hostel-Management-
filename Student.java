package college_project;
import java.util.*;

class node {
    node left, right;
    info data;

    public node(info d) {
        left = null;
        right = null;
        data = d;
    }
}

class info {
    int id, rm;
    String h1data, name, clgname, branch;


    info(String name, String clgname, String branch, String h1data, int rm) {
        this.name = name;
        this.branch = branch;
        this.clgname = clgname;
        this.h1data = h1data;
        this.rm = rm;
    }
}

public class Student {
    int count1;
    node root = null;
    String h1data, name, clgname, branch;
    Scanner sc = new Scanner(System.in);
    int front, rear, totalstudent, j;
    info arr[];

    student() {

    }

    student(int totalstudent) {
        front = 0;
        rear = -1;
        this.totalstudent = totalstudent;
        arr = new info[totalstudent];
    }

    boolean isFull() {
        return (rear == (totalstudent - 1));
    }

    boolean isEmpty() {
        return (rear == -1);
    }

    void accept() {
        Scanner sc12 = new Scanner(System.in);
        Scanner sc21 = new Scanner(System.in);
        //   int id = 1;

        int ans, count;
        count1 = 0;
        do {
            count = 0;
            int rm = (int) ((Math.random() * 100) + 300);
            do {
                if (isFull() == true) {
                    System.out.println("\n ____________ Admission is full _____________");
                    return;
                } else {
                    h1data = "H1_2022_" + Integer.toString((int) (Math.random() * 89) + 10);
                    System.out.print("\n -------------------- STUDENT DETAILS ---------------- ");
                    System.out.println("\n Room Number : " + rm);
                    System.out.print("\n Enter name of student : ");
                    name = sc12.nextLine();
                    System.out.print("\n Enter name of college : ");
                    clgname = sc12.nextLine();
                    System.out.print("\n Enter name of branch : ");
                    branch = sc12.nextLine();
                    System.out.print("\n Hostel ID: " + h1data);
                    rear++;
                    arr[rear] = new info(name, clgname, branch, h1data, rm);
                    // System.out.println(arr[rear]);
                    count++;
                    count1++;
                }
                System.out.print("\n Do you want to add another node? Yes:1 No:0 : ");
                ans = sc21.nextInt();
            } while (count < 3 && ans == 1);
        } while (ans == 1);
    }

    info dequeue() {
        info tempque = null;
        if (!isEmpty() == true) {
            tempque = arr[front];
            front++;
            if (tempque != null) {
                return tempque;
            } else {
                System.out.println(" _____empty list____ ");
                return null;
            }
        }
        return tempque;
    }

    void create() {
        node temp = null;
        Scanner sc = new Scanner(System.in);
        int yn = 0, i;
        do {
            info d = dequeue();
            temp = new node(d);
            if (root == null) {
                root = temp;
            } else {
                node ptr = root;
                while (ptr != null) {
                    if ((temp.data.h1data).compareTo(ptr.data.h1data) < 0) {
                        if (ptr.left == null) {
                            ptr.left = temp;
                            break;
                        } else {
                            ptr = ptr.left;
                        }
                    }
                    if ((temp.data.h1data).compareTo(ptr.data.h1data) > 0) {
                        if (ptr.right == null) {
                            ptr.right = temp;
                            break;
                        } else {
                            ptr = ptr.right;
                        }
                    }
                }
            }
            yn++;
        } while (yn < count1);
    }

    void display(node lRoot) {

        if (lRoot == null) {
            return;
        }
        display(lRoot.left);
        System.out.format("%-10d %-20s %-25s %-15s %-15s\n", lRoot.data.rm, lRoot.data.name, lRoot.data.clgname, lRoot.data.branch, lRoot.data.h1data);
        j++;
        display(lRoot.right);
    }

    int search(node root,String id) {
        Scanner in = new Scanner(System.in);
        int flag = 0;
        node ptr = root;
        while (ptr != null) {
            if (id.equals(ptr.data.h1data)) {
                flag = 1;
                break;
            }
            if (id.compareTo(ptr.data.h1data) < 0) {
                ptr = ptr.left;
            }
            if (id.compareTo(ptr.data.h1data) > 0) {
                ptr = ptr.right;
            }
        }
        if (flag == 1) {
            System.out.print("\n");
            System.out.format(" %-10s %-20s %-25s %-15s %-15s\n\n ", "ROOM NO ", "Name  ", "College Name   ", "Branch  ", "Roll No  ");

            System.out.format("%-10d %-20s %-25s %-15s %-15s\n", ptr.data.rm, ptr.data.name, ptr.data.clgname, ptr.data.branch, ptr.data.h1data);
        } else {
            System.out.println("\n _________________Data not found______________\n");
        }
        return flag;
    }
}


