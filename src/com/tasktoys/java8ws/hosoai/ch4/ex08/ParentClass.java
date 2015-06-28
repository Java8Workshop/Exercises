package com.tasktoys.java8ws.hosoai.ch4.ex08;

import java.util.ArrayList;
import java.util.List;

public class ParentClass {
	private String name;
	private List<ChildClass> children;

	public ParentClass(){
		children = new ArrayList<ChildClass>();
	}
	public List<ChildClass> getChildren(){
		return this.children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
