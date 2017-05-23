package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/*
Используй Files,
чтобы в конструкторе класса Solution правильно инициализировать поле fileData
объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile,
то инициализируй поле объектом NullFileData.
*/
public class Solution
{
    private FileData fileData;

    public Solution(String pathToFile)
    {
        try
        {
            Path path = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path),
                                            Files.isDirectory(path), Files.isWritable(path));
        }
        catch (Exception e)
        {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData()
    {
        return fileData;
    }

    public static void main(String[] args) throws IOException
    {
        Solution solution=new Solution("C:/greed/678.txt");
        System.out.println("Directory="+solution.fileData.isDirectory());
        System.out.println("Executable="+solution.fileData.isExecutable());
        System.out.println("Hidden="+solution.fileData.isHidden());
        System.out.println("Writable="+solution.fileData.isWritable());
        if (solution.fileData instanceof NullFileData) System.out.println(((NullFileData) solution.fileData).getException().getClass().getSimpleName());
    }
}
