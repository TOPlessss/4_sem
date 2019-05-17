package com.example.lab3;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database (entities = {Student.class}, version = 1)
public abstract class mDatabase extends RoomDatabase
{
    public abstract StudentDao studentDao();
}

