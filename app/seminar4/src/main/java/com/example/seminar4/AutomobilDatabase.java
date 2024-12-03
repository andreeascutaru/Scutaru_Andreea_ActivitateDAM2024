package com.example.seminar4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Automobil.class}, version=1)
public abstract class AutomobilDatabase extends RoomDatabase {
    public abstract AutomobilDAO getDaoObject();
}
