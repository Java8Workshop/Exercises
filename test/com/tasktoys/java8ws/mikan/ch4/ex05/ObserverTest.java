/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex05;

import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class ObserverTest {

    @Test
    public void testObserve_dualNormalInput() {
        Rectangle gauge = new Rectangle();
        gauge.setWidth(50);
        ObservableValue<Boolean> obsvalue = Observer.observe(t -> t.doubleValue() >= 100, gauge.widthProperty());
        assertNotNull(obsvalue);
        Boolean value1 = obsvalue.getValue();
        assertFalse(value1);
        gauge.setWidth(100);
        Boolean value2 = obsvalue.getValue();
        assertTrue(value2);
    }
}
