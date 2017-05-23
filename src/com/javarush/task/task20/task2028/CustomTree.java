package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable
{
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public static void main(String[] args)
    {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        ((CustomTree)list).remove("4");
        ((CustomTree) list).add("16");
        ((CustomTree) list).add("17");
        ((CustomTree) list).add("18");
        ((CustomTree) list).add("19");
        System.out.println(((CustomTree) list).getParent("19"));
        /*
       ((CustomTree)list).print();
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        ((CustomTree)list).remove("2");
        ((CustomTree)list).remove("9");
        ((CustomTree)list).print();
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        ((CustomTree)list).print();
        System.out.println("\n===== REMOVE 18 and 20 =====");
        ((CustomTree)list).remove("18");
        ((CustomTree)list).remove("20");
        ((CustomTree)list).print();
        System.out.println("\n===== ADD 21 - 32 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        ((CustomTree)list).print();
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((CustomTree) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((CustomTree) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((CustomTree) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((CustomTree) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((CustomTree) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((CustomTree) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((CustomTree) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((CustomTree) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((CustomTree) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((CustomTree) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((CustomTree) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((CustomTree) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((CustomTree) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((CustomTree) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((CustomTree) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((CustomTree) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((CustomTree) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((CustomTree) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((CustomTree) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((CustomTree) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + ((CustomTree) list).size() + " expected = 22");

        System.out.println();
        /*System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println(((CustomTree)list).size());*/
       // System.out.println();
       // ((CustomTree)list).remove("1");

        //System.out.println(((CustomTree)list).size());
        //((CustomTree)list).print();
        /*
        ((CustomTree)list).remove("2");
        System.out.println(((CustomTree)list).size());
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));*/
    }

    Entry<String> root = new Entry<>("0");

    public void print()
    {
        ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);
        Entry<String> check;
        while ((check=arrayDeque.pollFirst())!=null)
        {
            System.out.print(check.elementName+" ");
            if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
            if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
        }
        System.out.println();
    }
    @Override
    public boolean add(String s)
    {


        ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);
        while (true)
        {
            Entry<String> check = arrayDeque.pollFirst();
            if (check.addChild(s))
            {
                return true;
            }
            else
            {
                if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
                if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
            }
        }

    }

    public String getParent(String s)
    {
        if (root.elementName.equals(s))
        {
            return "";
        }
        else
        {
            ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
            arrayDeque.addLast(root);
            Entry<String> check;
            while ((check=arrayDeque.pollFirst())!=null)
            {

                if (check.elementName.equals(s))
                {
                    return check.parent.elementName;
                }
                else
                {
                    if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
                    if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
                }
            }
            return null;
        }
    }

    public void remove(String s)
    {
        ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);

            Entry<String> check;
                    while ((check= arrayDeque.pollFirst())!=null)
                    {

                        if (check.elementName.equals(s))
                        {
                            Entry<String> parent = check.parent;
                            if (parent.leftChild==check)
                            {
                                parent.leftChild = null;
                                removeTree(check);
                                check = null;

                            }
                            else if (parent.rightChild==check)
                            {
                                parent.rightChild = null;
                                removeTree(check);
                                check = null;

                            }
                        }
                        else
                        {
                            if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
                            if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
                        }

                    }

    }

    private void removeTree(Entry<String> entry)
    {
        ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(entry);

        Entry<String>check;

        while ((check=arrayDeque.pollFirst())!=null)
        {
            if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
            if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
            if (check.parent.leftChild == check) check.parent.leftChild = null;
            if (check.parent.rightChild == check) check.parent.rightChild = null;
            check = null;
        }
    }

    public int size()
    {
        ArrayDeque<Entry<String>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);
        Entry<String> check;
        int size=-1;
        while ((check=arrayDeque.pollFirst())!=null)
        {
            size++;
            if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
            if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
        }
        return size;
    }

    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    public String remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable
    {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;


        public Entry(String elementName)
        {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren()
        {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren()
        {

            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public boolean addChild(String s)
        {
            checkChildren();
            if (isAvailableToAddChildren())
            {
                Entry<T> entry = new Entry<>(s);
                entry.parent = this;
                entry.lineNumber = this.lineNumber + 1;
                if (availableToAddLeftChildren)
                {
                    leftChild = entry;
                    return true;
                }
                if (availableToAddRightChildren)
                {
                    rightChild = entry;
                    return true;
                }
            }
            return false;

        }
    }


}
