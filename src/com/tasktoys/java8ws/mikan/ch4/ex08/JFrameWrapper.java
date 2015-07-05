/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex08;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * JavaBean wrapper of the {@code javax.swing.JFrame}.
 *
 * @author mikan
 */
public final class JFrameWrapper extends JFrame {

    private static final long serialVersionUID = 1L;
    private final List<Component> children;

    public JFrameWrapper() {
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
        Container container = getContentPane();
        container.removeAll();
        children.forEach(container::add);
        super.doLayout();
    }
}
