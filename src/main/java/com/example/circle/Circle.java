package com.example.circle;

/**
 * Created by Вера on 30.03.2016.
 */

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * <p>Возвращает площадь круга, который находится в данном объекте</p>
     * @return AreaOfCircle
     */
    public double getArea(){
        return Math.PI * radius*radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(15.7);
        System.out.println(circle.getArea());
    }
}