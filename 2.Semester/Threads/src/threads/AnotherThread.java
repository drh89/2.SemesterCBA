/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static threads.ThreadColor.ANSI_CYAN;

/**
 *
 * @author Dennis
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from another thread");
        
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(ANSI_CYAN + "Another thread woke me up");
        }
        System.out.println(ANSI_CYAN + "Three seconds have passed and I'm awake");
    }
    
}
