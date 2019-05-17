package com.example.lab3;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Student")
public class Student
{
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "addTime")
    public String addTime;

    public Student(String name, String addTime)
    {
        this.name = name;
        this.addTime = addTime;
    }
}
