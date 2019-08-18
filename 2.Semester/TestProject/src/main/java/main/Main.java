package main;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Main...");
    }
    
    public int someMethod(int a, int b)
    {
        if(a < b)
        {
            return a + b;
        }
        else
        {
            return a - b;
        }
    }
}