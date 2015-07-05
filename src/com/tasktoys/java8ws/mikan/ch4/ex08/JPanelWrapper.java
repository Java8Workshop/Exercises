/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex08;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class JPanelWrapper extends JPanel {

    private static final long serialVersionUID = 1L;

    private final List<Component> children;

    public JPanelWrapper() {
        children = new ArrayList<>();
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void doLayout() {
        if (children == null) {
            return;
        }
        removeAll();
        children.forEach(this::add);
        super.doLayout();
    }
}
