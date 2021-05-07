package com.example.exercise2_d;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText nama,notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this);
        nama = findViewById(R.id.nama);
        notelp = findViewById(R.id.notelp);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO mahasiswa(nama,notelp)VALUES('" +
                        nama.getText().toString() +"','" +
                        notelp.getText().toString() +"')");
                Toast.makeText(CreateActivity.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}