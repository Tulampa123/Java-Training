package com.exercise.ny;
class RunRunner implements Runnable {
	public void run() {
		System.out.println("Task1 started");
		
		for(int i=1; i<3;i++) {
			System.out.println(i + " ");
		}
	}
}

public class RunnableBasicsRunner {
	public static void main(String[] args) {
		
		RunRunner tr = new RunRunner();
		
		//passing runnable object as a parameter
		Thread t1 = new Thread(tr);
		t1.start();
	}
}
