/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static threads.ThreadColor.ANSI_PURPLE;

/**
 *
 * @author Dennis
 */
public class MyRunnable  implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from MyRunnable's implementation of runnable");
    }
    
}
