package com.exercise.ny;

class ThreadRunner extends Thread{
	public void run() {
		System.out.println("Task1 started");
		
		for(int i=1; i<3;i++)
			System.out.println(i + " ");
	}
}

public class ThreadBasicsRunner {
	
	public static void main(String[] args) {
		ThreadRunner tr = new ThreadRunner();
		
		//internally, the thread will execute the run method
		tr.start();
	}
}

