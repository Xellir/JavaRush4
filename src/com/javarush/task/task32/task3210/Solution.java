package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution
{
    public static void main(String... args) throws IOException
    {

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] bt = new byte[text.length()];
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(number);

        randomAccessFile.read(bt, 0, text.length());
        String check = convertByteToString(bt);
        System.out.println(check);
        randomAccessFile.seek(randomAccessFile.length());
        if (check.equals(text))
        {
            randomAccessFile.write("true".getBytes());
        }
        else
        {
            randomAccessFile.write("false".getBytes());
        }
        randomAccessFile.close();
    }

    private static String convertByteToString(byte[] bt)
    {
        return new String(bt);
    }
}
