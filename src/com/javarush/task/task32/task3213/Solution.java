package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String mid = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < mid.length(); i++)
            {
                char ch = (char) ((int) mid.charAt(i) + key);
                stringBuilder.append(ch);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (Exception e)
        {
            return "";
        }
    }

}
