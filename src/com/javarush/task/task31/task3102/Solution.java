package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution
{
    public static File findFile(File folder, String name)
    {

        ArrayDeque<File>array=new ArrayDeque<>();
        array.offerLast(folder);
        while (true)
        {
            File in=array.pollFirst();
            if (in==null) break;
            if (in.isDirectory())
            {
                File[] ins=in.listFiles();
                for (int i = 0; i <ins.length ; i++)
                {
                    array.offerLast(ins[i]);
                }
            }
            else if (in.isFile())
            {
                if (in.getName().equals(name)) return in;
            }
        }
        return null;
    }
}
