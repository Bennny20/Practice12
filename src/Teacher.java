
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phien
 */
public class Teacher extends Person {

    private char classRoom;
    private double salary;
    private int workingHours;

    public Teacher() {
    }

    public Teacher(char classRoom, double salary, int workingHours, String name, String dob, String address) {
        super(name, dob, address);
        this.classRoom = classRoom;
        this.salary = salary;
        this.workingHours = workingHours;
    }

    public char getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(char classRoom) {
        this.classRoom = classRoom;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public boolean checkClassRoom(char classRoom) {
        Scanner sc = new Scanner(System.in);
        char[] listcClassRoom = {'G', 'H', 'K', 'L', 'I', 'M'};
        boolean check = false;
        while (!check) {
            for (int i = 0; i < listcClassRoom.length; i++) {
                if (classRoom == listcClassRoom[i]) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.print("Nhap lai Class room");
                classRoom = sc.next().charAt(0);
            }
        }

        return check;
    }

    @Override
    public Teacher inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input class room: ");
        char classRoomTemp = sc.next().charAt(0);
        boolean check = checkClassRoom(classRoomTemp);
        if (check) {
            classRoom = classRoomTemp;
        }       
        System.out.print("Input Name: ");
        name = sc.nextLine();
        System.out.print("Input day of birth: ");
        dob = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
        System.out.print("Input salary: ");
        salary = Double.parseDouble(sc.nextLine());
        
        Teacher teacher = new Teacher(classRoom, salary, workingHours, name, dob, address);
        return teacher;
    }

    public void displayInfo() {
        System.out.printf("Classroom: %3c   Name: %-20s   Day of birth: %-12s   Address: %-30s   Salary: %5.2f   Working hours: %4d\n",
                classRoom, name, dob, address, salary, workingHours);
    }

    public double calculateSalary() {
        if (classRoom == 'M' || classRoom == 'L') {
            return salary * workingHours + 200000;
        } else {
            return salary * workingHours;
        }
    }
}
