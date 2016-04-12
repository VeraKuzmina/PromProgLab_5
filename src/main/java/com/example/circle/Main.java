package com.example.circle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Вера on 11.04.2016.
 * Задание выполняется индивидуально​
 * Необходимо создать Gradle­проект согласно варианту, в котором необходимо обеспечить:
 * 1. программную реализацию с GUI
 * 2. модульное  и ​ интеграционное тестирование (JUnit тесты)
 * 3. документацию (javadoc)
 *
 * Рекомендуется использовать Java Time API, введенный в Java 8.
 *
 * Вариант 8
 * Часы со стрелками
 */
public class Main extends JFrame {
    protected final int H = 500;
    protected final int W = 500;

    /**
     * Закрытый конструктор для использования в void main(String[] args)
     */
    private Main() {
        setSize(W, H);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setContentPane(new MyJPanel());
    }

    /**
     * Основная функция, которая рисует окно
     * @param args аргументы из командной строки
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
