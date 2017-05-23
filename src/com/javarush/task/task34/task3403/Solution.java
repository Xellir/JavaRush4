package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        solution.recursion(132);
    }
    public void recursion(int n)
    {
        if (n>1)
        {
            int mem=n;
            inner: for (int i = 2; i <n ; i++)
            {
                if (n%i==0)
                {
                    mem=i;
                    break inner;
                }

            }
            System.out.print(mem+" ");
            recursion(n/mem);
        }
    }
}
