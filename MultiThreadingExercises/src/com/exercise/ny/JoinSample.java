package com.exercise.ny;

public class JoinSample {
	 public static void main(String[] args) {
	      Thread tr1 = new Thread(new MyClass(), "tr1");
	      Thread tr2 = new Thread(new MyClass(), "tr2");
	         
	      // Start first thread immediately
	      tr1.start();
	         
	      /* Start second thread(tr2) once first thread(tr1) 
	       * is dead, without join() on thread 1, second thread
	       * doesn't need to wait for thread1 to terminate before it executes
	       */
	      try {
	          tr1.join();
	      } catch (InterruptedException ie) {
	          ie.printStackTrace();
	        }
	      tr2.start();
	   }
	}
	 
	class MyClass implements Runnable{
	 
	    @Override
	    public void run() {
	    	Thread t = Thread.currentThread();
	        System.out.println("Thread started: "+t.getName());
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException ie) {
	            ie.printStackTrace();
	        }
	        System.out.println("Thread ended: "+t.getName());
	        
	    }


}
