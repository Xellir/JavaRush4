package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution
{

    public static void main(String[] args) throws IOException
    {
        Path passwords = downloadFile("http://tesera.ru/images/items/91387/Roll%20Through%20the%20Ages-Rus-v1.0.pdf", Paths.get("C:/MyDownloads"));

        for (String line : Files.readAllLines(passwords, Charset.defaultCharset()))
        {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException
    {
        URL url=new URL(urlString);

        Path tempFile=Files.createTempFile("tp",".tm");
        InputStream inputStream=url.openStream();
        Files.copy(inputStream, tempFile);
        String fileName = urlString.substring(urlString.lastIndexOf("/")+1);
        Path resultFile = Paths.get(downloadDirectory + "/" + fileName);
        return Files.move(tempFile,resultFile);
    }
}
