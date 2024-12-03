package com.example.seminar4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AutomobilDAO {

    @Insert
    void insertAutomobil(Automobil automobil);

    @Query("Select * from Automobile")
    List<Automobil> getAutomobile();

    @Delete
    void delete(Automobil automobil);
}
