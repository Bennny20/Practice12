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
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double calculateArea() {
        return radius * 2 * 3.14;
    }

    @Override
    public double calculatePerimeter() {
        return radius * radius * 3.14;
    }

    public void displayInfo(){
        System.out.printf("A circle with radius: %5.2f\n", radius);
    }
}
