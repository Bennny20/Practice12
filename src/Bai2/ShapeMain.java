/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author phien
 */
public class ShapeMain {
    static Scanner sc =new Scanner(System.in);
    
    public static void main(String[] args) {
        Rectangle[] listRectangles = new Rectangle[5];
        listRectangles[0] = new Rectangle(4, 5);
        listRectangles[1] = new Rectangle(3, 9);
        listRectangles[2] = new Rectangle(1, 1);
        listRectangles[3] = new Rectangle(2, 3);
        listRectangles[4] =new Rectangle(2.1, 8.4);
        Circle[] listCircles = new Circle[5];
        listCircles[0] = new Circle(2.5);
        listCircles[1] = new Circle(1);
        listCircles[2] = new Circle(2);
        listCircles[3] = new Circle(5);
        listCircles[4] = new Circle(3.1);
     
        boolean checkMenu1 = true;
        boolean checkMenu2 = true;
        while(checkMenu1){
            menu1();
            System.out.print("Your choice: ");
            int choiceMenu1 = sc.nextInt();
            switch(choiceMenu1){
                case 1:
                    while (checkMenu2) { 
                    menu2(choiceMenu1);
                        System.out.print("Your choice: ");
                        int choiceMenu2 = sc.nextInt();
                        switch(choiceMenu2){
                            case 1:
                                showAllCircle(listCircles);
                                
                                break;
                            case 2:
                                System.out.print("Vi tri muon them: ");
                                int index = sc.nextInt();
                                Circle newCircle = new Circle(6.5);
                                Circle[] newListCircle = addNewCir(listCircles, newCircle, index);
                                listCircles = new Circle[newListCircle.length];
                                for (int i = 0; i < newListCircle.length; i++) {
                                    listCircles[i] = newListCircle[i];
                                }
                                System.out.println("Add success!!!");
                                break;
                            case 3:
                                System.out.print("Vi tri muon xoa: ");
                                int indexRemove = sc.nextInt();
                                Circle[] removeListCircle = removeCir(listCircles, indexRemove);
                                listCircles = new Circle[removeListCircle.length];
                                for (int i = 0; i < removeListCircle.length; i++) {
                                    listCircles[i] = removeListCircle[i];
                                }
                                System.out.println("Remove success!!!");
                                break;
                            case 4:
                                System.out.print("Vi tri muon cap nhat: ");
                                int indexUpdate = sc.nextInt();
                                boolean checkUpdate = updateCir(listCircles, indexUpdate);
                                if (checkUpdate) {
                                    System.out.println("Update success");
                                }else{
                                    System.out.println("Not found");
                                }
                                break;
                            case 5:
                                System.out.println("Chu vi tăng dần");
                                sortPerimeterCir(listCircles);
                                break;
                            case 6:
                                System.out.println("Dien tich giảm dần");
                                sortAreaCir(listCircles);
                                break;
                            case 7:
                                checkMenu2 = false;
                                break;
                            default:
                                System.out.println("Your choose is invalid.");
                                break;
                        }
                    }
                    checkMenu2 = true;
                    break;
                case 2:
                    while (checkMenu2) { 
                        menu2(choiceMenu1);
                        System.out.print("Your choice: ");
                        int choiceMenu2 = sc.nextInt();
                        switch(choiceMenu2){
                            case 1:
                                showAllRectangle(listRectangles);
                                break;
                            case 2:
                                System.out.print("Vi tri muon them: ");
                                int index = sc.nextInt();
                                Rectangle newRectangle = new Rectangle(6.5, 6.5);
                                Rectangle[] newListRectangles = addNewRec(listRectangles, newRectangle, index);
                                listRectangles = new Rectangle[newListRectangles.length];
                                for (int i = 0; i < newListRectangles.length; i++) {
                                    listRectangles[i] = newListRectangles[i];
                                }
                                System.out.println("Add success!!!");
                                break;
                            case 3:
                                System.out.print("Vi tri muon xoa: ");
                                int indexRemove = sc.nextInt();
                                Rectangle[] removeListRectangles = removeRec(listRectangles, indexRemove);
                                listRectangles = new Rectangle[removeListRectangles.length];
                                for (int i = 0; i < removeListRectangles.length; i++) {
                                    listRectangles[i] = removeListRectangles[i];
                                }
                                System.out.println("Remove success!!!");
                                break;
                            case 4:
                                System.out.print("Vi tri muon cap nhat: ");
                                int indexUpdate = sc.nextInt();
                                boolean checkUpdate = updateRec(listRectangles, indexUpdate);
                                if (checkUpdate) {
                                    System.out.println("Update success");
                                }else{
                                    System.out.println("Not found");
                                }
                                break;
                            case 5:
                                System.out.println("Chu vi tăng dần");
                                sortPerimeterRec(listRectangles);
                                break;
                            case 6:
                                System.out.println("Dien tich giảm dần");
                                sortAreaRec(listRectangles);
                                break;
                            case 7:
                                checkMenu2 = false;
                                break;
                            default:
                                System.out.println("Your choose is invalid.");
                                break;
                        }
                    }
                    checkMenu2 = true;
                    break;
                case 3:
                    checkMenu1 = false;
                    break;  
                default:
                    System.out.println("Your choose is invalid.");
                    break;
            }
        }
    }
    //Rectangle
    public static void showAllRectangle(Rectangle[] listRectangles){
        for (Rectangle rectangle : listRectangles) {
            rectangle.displayInfo();
        }
    }
    
    public static Rectangle[] addNewRec(Rectangle[] listRectangles, Rectangle newRectangle, int index){
        Rectangle[] newList = new Rectangle[listRectangles.length + 1];
        for (int i = 0; i < index; i++) {
            newList[i] = listRectangles[i];
        }
        newList[index] = newRectangle;
        for (int i = index + 1; i < newList.length; i++) {
            newList[i] = listRectangles[i-1]; 
        }
        return newList;
    }
    
    public static Rectangle[] removeRec(Rectangle[] listRectangles, int index){
        Rectangle[] newList = new Rectangle[listRectangles.length-1];
        int indexRemovedArr = 0; 
        for (int i = 0; i < listRectangles.length; i++) {
            if(i == index){
                continue;
            }
            newList[indexRemovedArr] = listRectangles[i];
            indexRemovedArr++;
        }
        return newList;
    }
    
    public static boolean updateRec(Rectangle[] listRectangles, int index){
        for (int i = 0; i < listRectangles.length; i++) {
            if( i == index){
                System.out.print("Update length: ");
                listRectangles[i].setLength(sc.nextDouble());
                System.out.print("Update width: ");
                listRectangles[i].setWidth(sc.nextDouble());
                return true;                
            }
        }
        return false;
    }
    
    public static void sortAreaRec(Rectangle[] listRectangles){
        for (int i = 0; i < listRectangles.length - 1; i++) {
            for (int j = i + 1; j < listRectangles.length; j++) {
                if(listRectangles[i].calculateArea() < listRectangles[j].calculateArea()){
                    Rectangle temp = listRectangles[i];
                    listRectangles[i] = listRectangles[j];
                    listRectangles[j] = temp;
                }
            }
        }
        showAllRectangle(listRectangles);
    }
            
    public static void sortPerimeterRec(Rectangle[] listRectangles){
        for (int i = 0; i < listRectangles.length - 1; i++) {
            for (int j = i + 1; j < listRectangles.length; j++) {
                if(listRectangles[i].calculatePerimeter() > listRectangles[j].calculatePerimeter()){
                    Rectangle temp = listRectangles[i];
                    listRectangles[i] = listRectangles[j];
                    listRectangles[j] = temp;
                }
            }
        }
        showAllRectangle(listRectangles);
    }       
    //==========================================================================
    //Circle
    public static void showAllCircle(Circle[] listCircles){
        for (Circle circle : listCircles) {
            circle.displayInfo();
        }
    }
    
    public static Circle[] addNewCir(Circle[] listCircle, Circle newCircle, int index){
        Circle[] newList = new Circle[listCircle.length + 1];
        for (int i = 0; i < index; i++) {
            newList[i] = listCircle[i];
        }
        newList[index] = newCircle;
        for (int i = index + 1; i < newList.length; i++) {
            newList[i] = listCircle[i-1]; 
        }
        return newList;
    }
    
    public static Circle[] removeCir(Circle[] listCircle,int index){
        Circle[] newList = new Circle[listCircle.length-1];
        int indexRemovedArr = 0; 
        for (int i = 0; i < listCircle.length; i++) {
            if(i == index){
                continue;
            }
            newList[indexRemovedArr] = listCircle[i];
            indexRemovedArr++;
        }
        return newList;
    }
 
     public static boolean updateCir(Circle[] listCircle, int index){
        for (int i = 0; i < listCircle.length; i++) {
            if( i == index){
                System.out.print("Update Radius: ");
                listCircle[i].setRadius(sc.nextDouble());
                return true;                
            }
        }
        return false;
    }
    
    public static void sortAreaCir(Circle[] listCircle){
        for (int i = 0; i < listCircle.length - 1; i++) {
            for (int j = i + 1; j < listCircle.length; j++) {
                if(listCircle[i].calculateArea() < listCircle[j].calculateArea()){
                    Circle temp = listCircle[i];
                    listCircle[i] = listCircle[j];
                    listCircle[j] = temp;
                }
            }
        }
        showAllCircle(listCircle);
    }
            
    public static void sortPerimeterCir(Circle[] listCircle){
        for (int i = 0; i < listCircle.length - 1; i++) {
            for (int j = i + 1; j < listCircle.length; j++) {
                if(listCircle[i].calculatePerimeter() > listCircle[j].calculatePerimeter()){
                    Circle temp = listCircle[i];
                    listCircle[i] = listCircle[j];
                    listCircle[j] = temp;
                }
            }
        }
        showAllCircle(listCircle);
    }
        
    //==========================================================================
    //Menu
    public static void menu1() {
        System.out.println("-----Shape Management-----");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Exit");
    }

    public static void menu2(int choice) {
        if (choice == 1) {
            System.out.println("-----Circle Management-----");
            System.out.println("1. Xuất thông tin tất cả Circle đã chọn");
            System.out.println("2. Thêm mới 1 Circle đã chọn tại ví trí index");
            System.out.println("3. Xóa 1 Circle đã chọn theo index");
            System.out.println("4. Update 1 Circle đã chọn theo index");
            System.out.println("5. Sắp xếp Circle đã chọn theo chu vi tăng dần");
            System.out.println("6. Sắp xếp Circle đã chọn theo diện tích giảm dần");
            System.out.println("7. Exit");
        } else {
            System.out.println("-----Rectangle Management-----");
            System.out.println("1. Xuất thông tin tất cả Rectangle đã chọn");
            System.out.println("2. Thêm mới 1 Rectangle đã chọn tại ví trí index");
            System.out.println("3. Xóa 1 Rectangle đã chọn theo index");
            System.out.println("4. Update 1 Rectangle đã chọn theo index");
            System.out.println("5. Sắp xếp Rectangle đã chọn theo chu vi tăng dần");
            System.out.println("6. Sắp xếp Rectangle đã chọn theo diện tích giảm dần");
            System.out.println("7. Exit");
        }
    }
}
