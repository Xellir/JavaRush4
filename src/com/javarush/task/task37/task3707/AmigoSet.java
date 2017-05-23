package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Somehow on 17.05.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Set<E>,Serializable,Cloneable
{
    private static final Object PRESENT=new Object();
    private transient HashMap<E,Object>map;

    public AmigoSet()
    {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int)Math.max(16,collection.size()/.75f+1));
        this.addAll(collection);

    }


    public boolean add(E e)
    {

        return  map.put(e, PRESENT)==null;

    }

    @Override
    public Iterator<E> iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.keySet().contains(o);
    }

    @Override
    public void clear()
    {
        map.clear();
    }

    @Override
    public boolean remove(Object o)
    {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {

        try {
            AmigoSet amigoSet = new AmigoSet<>();
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
            return amigoSet;
        }
        catch (Exception e){
            throw new InternalError();
        }


    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {

        out.defaultWriteObject();
        //out.writeObject(map.keySet());
        out.writeFloat((Float)HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt((int)HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        //Set keys = (Set)in.readObject();
        float loadFactor = in.readFloat();
        int capacity = in.readInt();
        map = new HashMap(capacity, loadFactor);
        //addAll(keys);
    }
}
