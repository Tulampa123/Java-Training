package com.exercise.ny;

public class ThreadDeadlock {
    public static void main(String[] args){
     
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
      
        // first thread tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                //Lock resource 1
                synchronized(resource1){
                    System.out.println("Thread 1: locked resource 1");
                    
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}

                    //Now wait 'till we can get a lock on resource 2
                    synchronized(resource2){
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        //Thread2 tries to lock resource2 then resource1
        Thread t2 = new Thread(){
            public void run(){
                //This thread locks resource 2 right away
                synchronized(resource2){
                    System.out.println("Thread 2: locked resource 2");
                    //Then it pauses, for the same reason as the first 
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e){}
                   
                    synchronized(resource1){
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

      //deadlock will occur when the two threads are started
        t1.start();
        t2.start();
    }
}