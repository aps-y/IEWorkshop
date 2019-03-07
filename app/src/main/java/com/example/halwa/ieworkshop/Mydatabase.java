package com.example.halwa.ieworkshop;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Contacts.class},version =1)
public abstract class Mydatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
