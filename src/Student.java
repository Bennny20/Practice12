
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
public class Student extends Person {

    private String code;
    private double average;
    private String email;

    public Student() {
    }

    public Student(String code, double average, String email, String name, String dob, String address) {
        super(name, dob, address);
        this.code = code;
        this.average = average;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Student inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input code: ");
        code = sc.nextLine();
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input day of birth: ");
        dob = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
        System.out.print("Input email: ");
        email = sc.nextLine();
        System.out.print("Input average: ");
        average = Integer.parseInt(sc.nextLine());
        Student student = new Student(code, average, email, name, dob, address);
        return student;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Code:%-10s   Name: %-20s   Day of birth: %-15s   Address: %-30s   Email: %-30s   Average: %5.2f\n",
                code, name, dob, address, email, average);
    }

    public boolean checkScholarship() {
        return average >= 8;
    }

}
