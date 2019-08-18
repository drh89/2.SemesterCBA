/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Dennis
 */
public class Threads1 {

    
    
    public static void main(String[] args) throws InterruptedException {
        
        
       
        ExecutorService pool = Executors.newFixedThreadPool(4);
        System.out.println("Main starts");
        
        for (int i = 65; i <= 90; i++) {
            Runnable task = new Task(i);
            pool.submit(task);
            
            Thread.sleep(1);
        }
        System.out.println("Main is done!");
        pool.shutdown();
    }
    
}

class Task implements Runnable {

    private int count;
 
    private char temp;
    
    Task (int cnt){
        this.count = cnt;
        temp = (char) cnt;
        
        
    }
    @Override
    public void run() {
        writeLetters();
//            System.out.println(temp + "" + temp + temp);
            
        
        
        
        
        
        
    }
    public synchronized void writeLetters(){
        System.out.println(temp + "" + temp + temp);
    }
    
    
    
    
    
}