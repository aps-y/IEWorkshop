package com.example.halwa.ieworkshop;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Mydatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydatabase = Room.databaseBuilder(this,Mydatabase.class,"Contacts").allowMainThreadQueries().build();



    }

    public void clicked(View view) {

        Contacts contacts = new Contacts();
        EditText edt;
        edt = findViewById(R.id.Main_name);
        contacts.setName(edt.getText().toString());
        edt.setText("");

        edt = findViewById(R.id.Main_mail);
        contacts.setEmail(edt.getText().toString());
        edt.setText("");

        edt = findViewById(R.id.Main_phone);
        contacts.setPhone(Long.parseLong(edt.getText().toString()));
        edt.setText("");

        RadioGroup rg = findViewById(R.id.Main_RG);
        RadioButton rb =findViewById(rg.getCheckedRadioButtonId());

        contacts.setGender(rb.getText().toString());
        rg.clearCheck();

        mydatabase.myDao().addContacts(contacts);


    }

    public void clicked1(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        List<Contacts> contacts = mydatabase.myDao().readcontacts();
        String message = "";
        for (Contacts co : contacts)
        {
            message = message+"Name - "+ co.getName()+"\nE-mail - "+
                    co.getEmail()+"\nPhone - "+
                    co.getPhone()+"\nGender - "+co.getGender()+
                    "\n_____________________________\n";

        }
        intent.putExtra("MESSAGE",message);
        startActivity(intent);
    }
}
