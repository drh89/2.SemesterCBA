package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain
{
    @Test
    public void testSomeMethod()
    {
        Main main = new Main();
        
        int result = main.someMethod(7, 33);
        int expected = 40;
                
        assertEquals(expected, result);
    }
}