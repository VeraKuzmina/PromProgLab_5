package com.example.circle;

/**
 * Created by Вера on 12.04.2016.
 *
 * Модульное тестирование класса ClockDial
 */

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.time.zone.ZoneRulesException;

public class ClockDialTest {
    @Test
    public void BufferedImageTest() {
        ClockDial clockDial = new ClockDial(25, new Color(243, 136, 27), new Color(243, 136, 27));
        Assert.assertNotNull(clockDial.getClockDial());
    }

    @Test(expected = Exception.class)
    public void setWrongZone(){
        ClockDial clockDial = new ClockDial(-25, new Color(243, 136, 27), new Color(243, 136, 27));

    }
}