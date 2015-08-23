package com.tasktoys.java8ws.sato.ex6.ex09;

public class IntMatrix {

    private int[][] elements;
    private int width;
    private int height;

    public IntMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        elements = new int[width][height];
    }

    public int get(int n, int m) {
        return elements[n][m];
    }

    public int[] getColumn(int x) {
        int[] column = new int[height];
        System.arraycopy(elements[x], 0, column, 0, height);
        return column;
    }

    public int[] getRow(int y) {
        int[] row = new int[width];
        for (int i = 0; i < width; i++) {
            row[i] = elements[i][y];
        }
        return row;
    }

    public IntMatrix add(IntMatrix m) {
        if (width != m.getWidth() || height != m.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                elements[i][j] += m.get(i, j);
            }
        }
        return this;
    }

    public IntMatrix mlt(IntMatrix m) {
        if (width != m.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        IntMatrix result = new IntMatrix(m.getWidth(), height);
        for (int i = 0; i < height; i++) {
            int[] a = this.getRow(i);
            for (int j = 0; j < m.getWidth(); j++) {
                int[] b = m.getColumn(j);
                int v = 0;
                for (int k = 0; k < width; k++) {
                    v += a[k] * b[k];
                }
                result.set(i, j, v);
            }
        }
        return result;
    }

    public IntMatrix set(int n, int m, int v) {
        elements[n][m] = v;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                str += elements[i][j] + " ";
            }
            str = str.substring(0, str.length() - 1);
            str += "\n";
        }
        return str;
    }
}
