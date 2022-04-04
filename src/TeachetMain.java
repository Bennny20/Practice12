
import java.util.Arrays;
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
public class TeachetMain {

    public static void main(String[] args) {
        Teacher[] listTeacher = new Teacher[4];
        listTeacher[0] = new Teacher('G', 100000, 100, "Ten 1", "Ngay 1", "Dia chi 1");
        listTeacher[1] = new Teacher('H', 200000, 200, "Ten 2", "Ngay 2", "Dia chi 2");
        listTeacher[2] = new Teacher('I', 300000, 300, "Ten 3", "Ngay 3", "Dia chi 3");
        listTeacher[3] = new Teacher('K', 400000, 400, "Ten 4", "Ngay 4", "Dia chi 4");
        showTeacher(listTeacher);
        System.out.println("=============================");
        System.out.println("Giao vien co luong cao nhat: ");
        Teacher maxSalary = maxSalary(listTeacher);
        maxSalary.displayInfo();
        System.out.println("Luong nhan duoc: " + maxSalary.calculateSalary());
        System.out.println("==================");
        Teacher findTeacher = findTeacher(listTeacher);
        if (findTeacher.getName() != null) {
            findTeacher.displayInfo();
            System.out.println("Find success");
        } else {
            System.out.println("Not found");
        }
        System.out.println("===================");
        //System.out.println("Nhap thong tin giao vien mơi");
        Teacher newTeacher = new Teacher('M', 500000, 50, "Ten 5", "Ngay 5", "Dia chi 5");
//        newTeacher = newTeacher.inputInfo();
        listTeacher = addTeacher(listTeacher, newTeacher);
        showTeacher(listTeacher);
    }

    public static void showTeacher(Teacher[] listTeachers) {
        System.out.println("Hien thi thong tin tat ca giao vien: ");
        for (int i = 0; i < listTeachers.length; i++) {
            listTeachers[i].displayInfo();
        }
    }

    public static Teacher maxSalary(Teacher[] listTeachers) {
        Teacher teacher = listTeachers[0];
        double max = listTeachers[0].calculateSalary();
        for (int i = 1; i < listTeachers.length; i++) {
            if (listTeachers[i].calculateSalary() > max) {
                max = listTeachers[i].calculateSalary();
                teacher = listTeachers[i];
            }
        }
        return teacher;
    }

    public static Teacher findTeacher(Teacher[] listTeachers) {
        System.out.print("Nhap name muốn tìm: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Teacher teacher = new Teacher();
        for (Teacher listTeacher : listTeachers) {
            if (listTeacher.getName().equals(name)) {
                teacher = listTeacher;
            }
        }
        return teacher;
    }

    public static Teacher[] addTeacher(Teacher[] listTeacher, Teacher newTeacher) {
        listTeacher = Arrays.copyOf(listTeacher, listTeacher.length + 1);
        listTeacher[listTeacher.length - 1] = newTeacher;
        return listTeacher;
    }
}
