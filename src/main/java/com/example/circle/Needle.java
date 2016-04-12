package com.example.circle;
/*
 * Needle.java
 *
 * Created on 3 Октябрь 2004 г., 19:37
 */
import java.awt.*;
import java.awt.geom.*;
/**
 * Этот класс предназначен для создания стрелки часов
 *
 * @author Вера Кузьмина
 */
public class Needle {

    private GeneralPath shape;
    private double length, width;
    public String error;

    /** Создает экземпляры класса <code>Needle</code>.
     *  При создании необходимо указать длину и ширину стрелки.
     *  Длина должна быть больше ширины.
     *
     * @param length длина стрелки
     * @param width длина стрелки
     */
    public Needle(double length, double width){
        // проверяем параметры если длина меньше или равна нулю,
        // если ширина меньше или равна нулю, если длина меньше или равна ширине.
        if(length <= 0 || width <=0 || length <= width) {
            System.out.println("Incorrect sizes of the hand");
            error = "Error";
        }

        this.length = length;
        this.width = width;

        //создаем графический объект
        shape = new GeneralPath();
        shape.moveTo(-0f, (float)width/2);
        shape.lineTo((float)width/2, 0);
        shape.lineTo((float)length, (float)width/2);
        shape.lineTo((float)width/2, (float)width);
        shape.closePath();
    }

    /**
     *  Возвращает стрелку.
     *  @return Shape - фигура, содержащая изображение стрелки
     */
    public Shape getNeedle() {
        return shape;
    }
}