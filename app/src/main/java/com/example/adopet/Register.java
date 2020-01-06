package com.example.adopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;

public class Register extends AppCompatActivity implements View.OnClickListener{
    TextView txtMasuk;
    AutoCompleteTextView acttext_prov, acttext_kab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtMasuk = findViewById(R.id.txtmasuk);
        txtMasuk.setOnClickListener(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        acttext_prov =  findViewById(R.id.acttext_prov);
        acttext_kab =  findViewById(R.id.acttext_kab);
    }


    private void masuk(){
        startActivity(new Intent(getApplicationContext(),Login.class));
    }

    @Override
    public void onClick(View v) {
        if(v == txtMasuk) {
            masuk();
        }
    }
}
