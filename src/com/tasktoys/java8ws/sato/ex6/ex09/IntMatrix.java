package com.tasktoys.java8ws.sato.ex6.ex09;

public class IntMatrix {

	private int[][] elements;
	private int width;
	private int hight;
	
	public IntMatrix(int width, int hight) {
		this.width = width;
		this.hight = hight;
		elements = new int[width][hight];
	}
	
	public int get(int n, int m) {
		return elements[n][m];
	}
	
	public int[] getColom(int x) {
		int[] colom = new int[hight];
		for (int i = 0; i < hight; i++) {
			colom[i] = elements[x][i];
		}
		return colom;
	}
	
	public int[] getRow(int y) {
		int[] row = new int[width];
		for (int i = 0; i < width; i++) {
			row[i] = elements[i][y];
		}
		return row;
	}
	
	public IntMatrix add(IntMatrix m) {
		if (width != m.getWidth() || hight != m.getHight()) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				elements[i][j] += m.get(i, j);
			}
		}
		return this;
	}
	
	public IntMatrix mlt(IntMatrix m) {
		if (width != m.getHight()) {
			throw new IndexOutOfBoundsException();
		}
		IntMatrix result = new IntMatrix(m.getWidth(), hight);
		for (int i = 0; i < hight; i++) {
			int[] a = this.getRow(i);
			for (int j = 0; j < m.getWidth(); j++) {
				int[] b = m.getColom(j);
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
	
	public IntMatrix fill(int v) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				elements[i][j] = v;
			}
		}
		return this;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHight() {
		return hight;
	}
	
	@Override 
	public String toString() {
		String str = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				str += elements[i][j] + " ";
			}
			str = str.substring(0, str.length() - 1);
			str += "\n";
		}
		return str;
	}
}
