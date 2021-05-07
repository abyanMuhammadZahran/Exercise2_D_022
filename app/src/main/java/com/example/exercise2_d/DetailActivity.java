package com.example.exercise2_d;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView nama,notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nama = findViewById(R.id.nama);
        notelp = findViewById(R.id.notelp);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery(" SELECT * FROM mahasiswa WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()> 0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            notelp.setText(cursor.getString(1).toString());
        }
    }
}