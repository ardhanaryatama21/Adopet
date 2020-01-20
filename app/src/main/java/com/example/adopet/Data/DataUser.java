package com.example.adopet.Data;

import androidx.annotation.NonNull;

public class DataUser {
    private String foto;
    private String nama;
    private String email;
    private String nowhatsapp;
    private String namapengguna;
    private String katasandi;
    private String provinsi;
    private String kabupaten;

    public DataUser(String foto, String nama, String email, String nowhatsapp, String username, String password, String provinsi, String kabupaten) {
        this.nama = nama;
        this.email = email;
        this.nowhatsapp = nowhatsapp;
        this.namapengguna = namapengguna;
        this.katasandi = katasandi;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNowhatsapp() {
        return nowhatsapp;
    }

    public String getNamapengguna() {
        return namapengguna;
    }

    public String getKatasandi() {
        return katasandi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public String getFoto() {
        return foto;
    }

    @NonNull
    @Override
    public String toString() {
        return "akun{" +
                "foto='" + foto + '\'' +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", nowhatsapp='" + nowhatsapp + '\'' +
                ", namapengguna='" + namapengguna + '\'' +
                ", katasandi='" + katasandi + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", kabupaten='" + kabupaten + '\'' +
                '}';
    }
}
