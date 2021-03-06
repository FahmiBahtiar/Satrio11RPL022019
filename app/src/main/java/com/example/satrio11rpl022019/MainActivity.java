package com.example.satrio11rpl022019;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView masuk;
    TextView login;
    TextView dft;
    ImageView img;
    TextView pass;
    TextView nama;
    Toast toast;
    Button btn;
    SharedPreferences pref;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masuk =findViewById(R.id.masuk);
        login =findViewById(R.id.login);
        dft =findViewById(R.id.dft);
        img =findViewById(R.id.img);
        pass = findViewById(R.id.pass);
        nama = findViewById(R.id.nama);
        pref = getSharedPreferences("login",MODE_PRIVATE);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama.getText().toString().equalsIgnoreCase("satrio")|| pass.getText().toString().equalsIgnoreCase("satrio")){
                    Toast.makeText(MainActivity.this, "Anda berhasil login", Toast.LENGTH_SHORT).show();
                    editor = pref.edit();
                    editor.putString("userid", nama.getText().toString());
                    editor.apply();
                    Intent in = new Intent(MainActivity.this, menu.class);
                    in.putExtra("name", nama.getText().toString());
                    startActivity(in);
                    finish();

                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("username atau passs anda salah")
                            .setNegativeButton("Retry", null).create().show();
                }


            }
        });

        dft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Daftar akun ", Toast.LENGTH_SHORT).show();
                Intent dtr = new Intent(MainActivity.this, register.class);
                startActivity(dtr);
                finish();
            }
        });




    }
}