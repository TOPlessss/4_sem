package com.example.laba2;

import com.example.laba2.JsonPojoClass;

import java.util.ArrayList;

public class ClassList
{
    private static ArrayList<JsonPojoClass> techList = new ArrayList<>();
//    public static void create()
//    {
//        techList = new ArrayList<>();
//    }
    public static void fill(ArrayList<JsonPojoClass> arrayList)
    {
        techList.addAll(arrayList);
        techList.remove(0);
    }
    public static JsonPojoClass get(int index)
    {
        return techList.get(index);
    }
    public static int getSize()
    {
        return techList.size();
    }
}
