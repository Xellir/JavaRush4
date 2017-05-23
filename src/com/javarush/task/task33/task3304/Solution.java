package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        System.out.println(s.i+" "+s.name);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(f.i+" "+f.name);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException
    {
        ObjectMapper om = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        om.writeValue(stringWriter, one);

        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String resultClassName = resultClassObject.getSimpleName().toLowerCase();
        String jsonStr = stringWriter.toString().replaceFirst(oneClassName, resultClassName);

        StringReader stringReader = new StringReader(jsonStr);
        Object result = om.readValue(stringReader, resultClassObject);
        return result;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First
    {
        public int i=1;
        public String name="a";
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second
    {
        public int i=2;
        public String name="b";
    }
}
