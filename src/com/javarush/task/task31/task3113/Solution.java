package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution
{
    private static int countDirs;
    private static int countFiles;
    private static int countBytes;

    public static void main(String[] args) throws IOException
    {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));)
        {
            Path dir = Paths.get(bufferedReader.readLine());
            if (Files.isDirectory(dir))
            {
                Files.walkFileTree(dir, new MyFileVisitor());
                System.out.println("Всего папок - " + (countDirs-1));
                System.out.println("Всего файлов - " + countFiles);
                System.out.println("Общий размер - " + countBytes);
            }
            else
            {
                System.out.println(dir.toAbsolutePath().toString() + " - не папка");
            }
        }

    }

    static class MyFileVisitor extends SimpleFileVisitor<Path>
    {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
        {
            countFiles++;
            countBytes+=Files.size(file);

            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
        {
            countDirs++;
            return super.preVisitDirectory(dir, attrs);
        }
    }
}
