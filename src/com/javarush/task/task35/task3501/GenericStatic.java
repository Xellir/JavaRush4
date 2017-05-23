package com.javarush.task.task35.task3501;

public class GenericStatic
{
    public static <T extends Number> T someStaticMethod(T genericObject)
    {
        System.out.println(genericObject);
        return genericObject;
    }
}
