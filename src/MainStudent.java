
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
public class MainStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.next());
        Student[] listStudents = new Student[n];
        inputStudent(listStudents);
//        Student[] listStudents = new Student[5];
//        listStudents[0] = new Student("1", 9, "1", "1", "1", "1");
//        listStudents[1] = new Student("2", 7, "2", "2", "2", "2");
//        listStudents[2] = new Student("3", 10, "3", "3", "3", "3");
//        listStudents[3] = new Student("4", 6, "4", "4", "4", "4");
//        listStudents[4] = new Student("5", 8, "5", "5", "5", "5");
        System.out.println("==================");
        showStudent(listStudents);
        System.out.println("==================");
        showAverage(listStudents);
        System.out.println("==================");
        Student findStudent = findStudent(listStudents);
        if (findStudent.getCode() != null) {
            findStudent.displayInfo();
            System.out.println("Find success");
        } else {
            System.out.println("Not found");
        }

        System.out.println("==================");
        showScholarship(listStudents);
        System.out.println("==================");
        System.out.println("Danh sach sau sau sap xep");
        sortList(listStudents);
    }

    public static void inputStudent(Student[] listStudents) {
        System.out.println("Nhap thong tin sinh vien");
        for (int i = 0; i < listStudents.length; i++) {
            Student student = new Student();
            listStudents[i] = student.inputInfo();
        }
    }

    public static void showStudent(Student[] listStudents) {
        System.out.println("Hien thi thong tin tat ca sinh vien");
        for (int i = 0; i < listStudents.length; i++) {
            listStudents[i].displayInfo();
        }
    }

    public static void showAverage(Student[] listStudents) {
        System.out.println("Sinh vien diem trung binh cao nhat");
        Student maxAverageStudent = listStudents[0];
        Student minAverageStudent = listStudents[0];
        double max = listStudents[0].getAverage();
        for (int i = 1; i < listStudents.length; i++) {
            if (max < listStudents[i].getAverage()) {
                max = listStudents[i].getAverage();
                maxAverageStudent = listStudents[i];
            }
        }
        maxAverageStudent.displayInfo();

        System.out.println("Sinh vien diem trung binh thap nhat");
        double min = listStudents[0].getAverage();
        for (int i = 1; i < listStudents.length; i++) {
            if (min > listStudents[i].getAverage()) {
                min = listStudents[i].getAverage();
                minAverageStudent = listStudents[i];
            }
        }
        minAverageStudent.displayInfo();
    }

    public static Student findStudent(Student[] listStudents) {
        System.out.print("Nhap code muốn tìm: ");
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        Student student = new Student();
        for (Student listStudent : listStudents) {
            if (listStudent.getCode().equals(code)) {
                student = listStudent;
            }
        }
        return student;
    }

    public static void showScholarship(Student[] listStudents) {
        System.out.println("Danh sach student duoc hoc bong:");
        boolean check = false;
        for (Student listStudent : listStudents) {
            check = listStudent.checkScholarship();
            if (check) {
                listStudent.displayInfo();
            }
        }
    }

    public static void sortList(Student[] listStudents) {
        for (int i = 0; i < listStudents.length - 1; i++) {
            for (int j = i + 1; j < listStudents.length; j++) {
                if (listStudents[i].getAverage() > listStudents[j].getAverage()) {
                    Student temp = listStudents[i];
                    listStudents[i] = listStudents[j];
                    listStudents[j] = temp;
                }
            }
        }

        for (Student listStudent : listStudents) {
            listStudent.displayInfo();
        }
    }

}
