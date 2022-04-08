/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author phien
 */
public abstract class Shape {
    protected String color = "Green";

    public Shape() {
    }
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void displayInfo(){
        System.out.printf("A shape with color: %-10s\n", color);
    }
    
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
