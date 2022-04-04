
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
public class Person {
    protected String name;
    protected String dob;
    protected String address;

    public Person() {
    }

    public Person(String name, String dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Person inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input day of birth: ");
        String dob = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
        Person person = new Person(name, dob, address);
        return person;
    }
    
    
    public void displayInfo(){
        System.out.printf("Name: %-20s\tDay of birth: %-15s\tAddress: %-30s\n"
        , name, dob, address);
    }
}
