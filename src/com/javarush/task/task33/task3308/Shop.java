package com.javarush.task.task33.task3308;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Somehow on 05.05.2017.
 */
public class Shop
{
    public Goods goods=new Goods();
    public int count;
    public double profit;
    public String[] secretData;

    static class Goods
    {
       public List<String> names=new ArrayList<>();
    }
}
