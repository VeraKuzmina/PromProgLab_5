package com.example.circle;

/**
 * Created by Вера on 30.03.2016.
 */
import org.junit.Assert;
import org.junit.Test;

public class CircleTest {
    @Test
    public void testArea() {
        Circle circle = new Circle(1d);
        Assert.assertEquals(3.1415, circle.getArea(), 0.0001);
    }
}