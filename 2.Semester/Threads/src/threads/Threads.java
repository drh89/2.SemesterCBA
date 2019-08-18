/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static threads.ThreadColor.ANSI_GREEN;
import static threads.ThreadColor.ANSI_PURPLE;

/**
 *
 * @author Dennis
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello from the main thread");
        
        Thread anotherThread = new AnotherThread();
        anotherThread.start();
        
        new Thread(){
        
            @Override
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
        }
    }.start();
        
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run(){
                System.out.println(ANSI_PURPLE + "Hello from anonymous class's implementation of run()");
                
            }
        });
        myRunnableThread.start();
        
        System.out.println("Hello again from the main thread");
        
    }
    
}
