package com.example.seminar4;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Automobil.class}, version=1)
@TypeConverters({Converters.class})
public abstract class AutomobilDatabase extends RoomDatabase {
    public abstract AutomobilDAO getDaoObject();
}
