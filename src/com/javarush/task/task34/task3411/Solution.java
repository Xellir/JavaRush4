package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution
{
    public static void main(String[] args)
    {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char fromA, char toB, char helpC, int count)
    {
        if (count==1)
        {
            System.out.println("from "+fromA+" to "+toB);
            return;
        }
        else
        {
            moveRing(fromA,helpC,toB,count-1);
            System.out.println("from "+fromA+" to "+toB);
            moveRing(helpC,toB,fromA,count-1);
            return;
        }
    }
}