package com.example.adopet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.adopet.ui.akun.AkunFragment;
import com.example.adopet.ui.home.HomeFragment;

public class PengaturanAkun extends AppCompatActivity {

    LinearLayout lnubahdatadiri, lnubahkatasandi, lnkeluarakun, lnprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_akun);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        lnprofil = findViewById(R.id.lnprofil);
        lnubahkatasandi = findViewById(R.id.lnubahkatasandi);
        lnubahdatadiri = findViewById(R.id.lnubahdatadiri);
        lnkeluarakun = findViewById(R.id.lnkeluarakun);

        lnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profil();
            }
        });

        lnubahdatadiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahdatadiri();
            }
        });

        lnubahkatasandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahkatasandi();
            }
        });

        lnkeluarakun.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                keluarakun();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void ubahdatadiri() {
        Intent intent = new Intent(PengaturanAkun.this, UbahDataDiri.class);
        startActivity(intent);
        finish();
    }

    private void ubahkatasandi() {
        Intent intent = new Intent(PengaturanAkun.this, UbahKataSandi.class);
        startActivity(intent);
        finish();
    }

    private void profil() {
        Intent intent = new Intent(PengaturanAkun.this, Menu_utama.class);
        startActivity(intent);
        finish();
    }

    private void keluarakun() {
        Intent intent = new Intent(PengaturanAkun.this, Login.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
