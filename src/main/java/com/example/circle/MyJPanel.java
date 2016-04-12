package com.example.circle;

/**
 * Created by Вера on 30.03.2016.
 * Класс который рисует часы со стрелками.
 * Часы ходят и показывают реальное время.
 * Класс обращается к Java 8 Time API
 */

import java.time.LocalTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class MyJPanel extends JPanel implements ActionListener {
    private Needle hNeedle, mNeedle, sNeedle;
    private ClockDial dial;
    private int w, h;

    private Color dialColor = new Color(10, 53, 71);
    private Color hairLineColor = new Color(88, 150, 182);
    private Color hoursColor = new Color(243, 136, 27);
    private Color minutesColor = new Color(243, 186, 108);
    private Color secondsColor = new Color(249, 210, 9);

    /**
     * Функция, которая вызвается автоматически для рисования обновленных данных
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            LocalTime time = LocalTime.now();
            double hour =  time.getHour();
            double min =  time.getMinute();
            double sec = time.getSecond();

            //Создаем объекты и устанавливаем начальные значения.
            Dimension dim = getSize();
            w = dim.width;
            h = dim.height;

            //Создаем стрелки
            int radius = 0;
            if (w < h)
                radius = w / 2;
            else
                radius = h / 2;

            mNeedle = new Needle(radius, radius / 5);     //минутная стрелка
            hNeedle = new Needle(2d / 3d * radius, radius / 4); //часовая стрелка
            sNeedle = new Needle(radius, radius / 10);    //секундная стрелка

            //создаем циферблат
            dial = new ClockDial(radius * 2, dialColor, hairLineColor);

            //Рисуем циферблат
            Point luCorner = new Point(0, 0);
            if (w > h) {
                luCorner.x = (w - h) / 2;
                luCorner.y = 0;
            } else {
                luCorner.x = 0;
                luCorner.y = (h - w) / 2;
            }
            g2d.drawImage(dial.getClockDial(), null, luCorner.x, luCorner.y);

            //Рисуем стрелки
            g2d.setColor(hoursColor);
            AffineTransform hat = new AffineTransform();
            hat.translate(w / 2 - radius / 10, h / 2 - radius / 10);

            /*Рассчитываем угол поворота часовой стелки. Каждый час на
            12-ти часовом циферблате соответствует 30-ти градусам, а 1
            минута - 0.5 градуса. Затем результат переводим в радианы.*/
            if (hour >= 12)
                hour -= 12;
            double theta = (-90 + (30 * hour + 0.5 * min)) * Math.PI / 180;
            hat.rotate(theta, radius / 10, radius / 10);

            g2d.setTransform(hat);
            g2d.fill(hNeedle.getNeedle());

            g2d.setColor(minutesColor);
            AffineTransform mat = new AffineTransform();
            mat.translate(w / 2 - radius / 8, h / 2 - radius / 8);

            /*Рассчитываем угол поворота минутной стелки. Каждая минута на
            12-ти часовом циферблате соответствует 6-ти градусам, а 1
            секунда - 0.1 градуса. Затем результат переводим в радианы.*/
            theta = (-90 + (6 * min + 0.1 * sec)) * Math.PI / 180;
            mat.rotate(theta, radius / 8, radius / 8);

            g2d.setTransform(mat);
            g2d.fill(mNeedle.getNeedle());

            g2d.setColor(secondsColor);
            AffineTransform sat = new AffineTransform();
            sat.translate(w / 2 - radius / 20, h/2 - radius / 20);

            /*Рассчитываем угол поворота сеундной стелки. Каждая секунда на
            12-ти часовом циферблате соответствует 6-ти градусам.
            Затем результат переводим в радианы.*/
            theta = (-90 + (6 * sec)) * Math.PI / 180;
            sat.rotate(theta, radius / 20, radius / 20);

            g2d.setTransform(sat);
            g2d.fill(sNeedle.getNeedle());

            Timer timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }
        catch(Exception error) {
            System.out.println(error.getMessage());
        }
    }

    /**
     * Функция, которая вызвается при взаимодействии с панелью и перерисовывает время
     * @param e генерируется автоматически
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}