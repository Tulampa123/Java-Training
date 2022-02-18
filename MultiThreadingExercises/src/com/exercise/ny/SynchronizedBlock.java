package com.exercise.ny;

import java.util.ArrayList;
import java.util.List;

class Employee {
	String name = " ";
	public int count = 0;
	
	public void employeeName(String name, List<String> list) {
		
		//synchronized block
		synchronized (this) {
			this.name = name;
			count++; 
		}
		list.add(name);
	}	
}

public class SynchronizedBlock{
	public static void  main(String[] args) {
		Employee emp = new Employee();
		List<String> list = new ArrayList<String> ();
		emp.employeeName("Peter", list);
		System.out.println(emp.name);
	}
}
