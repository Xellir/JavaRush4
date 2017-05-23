package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;

/* 
Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter,
содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {
        try
        {
            byte[] buff = new byte[is.available()];
            is.read(buff);
            StringWriter result = new StringWriter();
            result.write(new String(buff));
            return result;
        } catch (Exception e)
        {
            return new StringWriter();
        }
    }
}