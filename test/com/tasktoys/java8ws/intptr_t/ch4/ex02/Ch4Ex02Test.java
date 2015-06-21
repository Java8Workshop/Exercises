package com.tasktoys.java8ws.intptr_t.ch4.ex02;

import javafx.beans.property.SimpleIntegerProperty;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Ch4Ex02Test{	
	@Test
	public void testPreInitializedProperty(){
		final Ch4Ex02 target = new Ch4Ex02();
		
		assertThat(target.getValue(), is(-1));
	}

	@Test
	public void testFirstAccessProperty() {
		final SimpleIntegerProperty target = new Ch4Ex02().valueProperty();
		
		assertThat(target, notNullValue());
		assertThat(target.get(), is(new SimpleIntegerProperty().get()));
	}
	
	@Test
	public void testSetterSetValue() {
		final Ch4Ex02 target = new Ch4Ex02();
		
		target.setValue(Integer.MIN_VALUE);
		
		assertThat(target.valueProperty().get(), is(Integer.MIN_VALUE));
	}
	
	@Test
	public void testGetterGetValue() {
		final Ch4Ex02 target = new Ch4Ex02();
		
		target.valueProperty().set(Integer.MAX_VALUE);

		assertThat(target.getValue(), is(Integer.MAX_VALUE));		
	}	
}
