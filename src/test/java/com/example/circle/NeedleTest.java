package com.example.circle;

/**
 * Created by Вера on 12.04.2016.
 *
 * Модульное тестирование класса Needle
 *
 */

import org.junit.Assert;
import org.junit.Test;

public class NeedleTest {
    @Test
    public void correctVar() {
        Needle needle = new Needle(-1, 5);
        Assert.assertTrue(needle.error.toString().equals("Error"));
    }

    @Test
    public void getNeedleTest() {
        Needle needle = new Needle(5, 5);
        Assert.assertNotNull(needle.getNeedle());
    }
}