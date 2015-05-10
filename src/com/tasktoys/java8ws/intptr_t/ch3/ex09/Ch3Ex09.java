package com.tasktoys.java8ws.intptr_t.ch3.ex09;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person
{
	private String firstname;
	private String lastname;
	
	public Person(String firstName, String lastName) {
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
}

class BadPerson
{
	private String fname;
	private String lname;
	
	public BadPerson(String firstName, String lastName) {
		this.fname = firstName;
		this.lname = lastName;
	}
	
	@Override
	public String toString() {
		return fname + " " + lname;
	}
}

class ExtPerson extends Person
{
	public ExtPerson(String firstName, String lastName) {
		super(firstName, lastName);
	}
}

public class Ch3Ex09 {

	public static void main(String[] args) {
		Comparator<Person> cmp = lexicographicComparator("lastname", "firstname");
		Comparator<BadPerson> cmpBad = lexicographicComparator("lastname", "firstname");
		
		List<Person> test1 = Arrays.asList(
			new Person("AAA", "AAA"),
			new Person("BBB", "BBB"),
			new Person("AAA", "BBB"),
			new Person("BBB", "AAA")
		);
		List<BadPerson> test2 = Arrays.asList(
			new BadPerson("AAA", "AAA"),
			new BadPerson("BBB", "BBB")
		);
		List<ExtPerson> test3 = Arrays.asList(
			new ExtPerson("AAA", "AAA"),
			new ExtPerson("BBB", "BBB"),
			new ExtPerson("AAA", "BBB"),
			new ExtPerson("BBB", "AAA")
		);
		
		System.out.println(test1);
		test1.sort(cmp);
		System.out.println(test1);
		System.out.println();
		
		try {
			test2.sort(cmpBad);
		} catch (Exception e) {
			System.out.println("Bad Person throw Exception.");
		}
		System.out.println();
		
		System.out.println(test3);
		test3.sort(cmp);
		System.out.println(test3);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
		return (T a, T b) -> {
			Class<?> clazzA = a.getClass();
			Class<?> clazzB = b.getClass();

			for(String fieldName : fieldNames) {				
				try {
					Field fieldA = getField(clazzA, fieldName);
					Field fieldB = getField(clazzB, fieldName);				
					fieldA.setAccessible(true);	// privateでもアクセス可能にする
					fieldB.setAccessible(true);
					
					Comparable objA = (Comparable)fieldA.get(a);
					Comparable objB = (Comparable)fieldB.get(b);
					
					return objA.compareTo(objB);
				} catch (NoSuchFieldException | SecurityException |
						 IllegalArgumentException | IllegalAccessException e)
				{
					throw new RuntimeException(e);
				}
			}
			
			return 0;
		};		
	}
	
	@SuppressWarnings("unused")
	private static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
		Field field = null;
		NoSuchFieldException lastExcept = null;

		while(field == null) {
			try {
				field = clazz.getDeclaredField(fieldName);
			} catch(NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
				lastExcept = e;
			}
		}
		if((field == null) && (lastExcept != null)) {
			throw lastExcept;
		}
		return field;
	}	
}
