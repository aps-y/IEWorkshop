package com.example.halwa.ieworkshop;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.content.Context;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addContacts(Contacts contact);

    @Query("select * from Contacts")
    List<Contacts> readcontacts();

}
