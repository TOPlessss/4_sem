package com.example.lab3;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@android.arch.persistence.room.Dao
public interface StudentDao
{
    @Query("SELECT * FROM Student")
    List<Student> getAll();

    @Query("SELECT * FROM Student WHERE id = :id")
    Student getById(long id);

    @Query("DELETE FROM Student")
    void clearAll();

    @Query("SELECT * FROM Student WHERE ID = (SELECT MAX(id) FROM Student)")
    Student getLastRecord();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Student... students);

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);
}
