package com.example.seminar4;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class Converters {
    @TypeConverter
    public String fromArrayList(ArrayList<String> list){
        if(list == null){
            return null;
        }
        return String.join(",", list);
    }

    @TypeConverter
    public ArrayList<String> toArrayList(String data){
        if(data==null||data.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(data.split(",")));
    }
}
