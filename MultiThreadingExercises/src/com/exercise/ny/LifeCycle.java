package com.exercise.ny;

	class BasicThread implements Runnable {
		public void run()
		{
			// moving t2 to timed waiting state
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(
				"thread1 while it called join() method on t2: "
				+ LifeCycle.t1.getState());
			try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

	public class LifeCycle implements Runnable {
		public static Thread t1;
		public static LifeCycle obj;

		public static void main(String[] args)
		{
			obj = new LifeCycle();
			t1 = new Thread(obj);

			
			System.out.println(
				"thread1 after creating it: "
				+ t1.getState());
			t1.start();

			// t1 moved to RUNNABLE state
			System.out.println(
				"thread1 after calling .start() method on it: "
				+ t1.getState());
			
		}

		/**
		 *
		 */
		public void run()
		{
			//creating thread2
			BasicThread basicT = new BasicThread();
			Thread t2 = new Thread(basicT);

			t2.start();
			
			try {
				
				Thread.sleep(200);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
				"thread2 after calling .sleep() method on it: "
				+ t2.getState());

			try {
				// waiting for thread2 to terminate
				t2.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
				"thread2 after finishing execution: "
				+ t2.getState());
			
//			// thread2 returns to RUNNABLE state
//			System.out.println(
//					"thread1 after t2 terminated"
//					+ Test.t1.getState());
			
		}

	}