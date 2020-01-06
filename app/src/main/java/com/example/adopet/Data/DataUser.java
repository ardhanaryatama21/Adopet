package com.example.adopet.Data;

public class DataUser {
    String foto;
    String nama;
    String email;
    String nowhatsapp;
    String namapengguna;
    String katasandi;
    String provinsi;
    String kabupaten;

    public DataUser(String foto, String nama, String email, String nowhatsapp, String username, String password, String provinsi, String kabupaten) {
        this.foto = foto;
        this.nama = nama;
        this.email = email;
        this.nowhatsapp = nowhatsapp;
        this.namapengguna = namapengguna;
        this.katasandi = katasandi;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
    }

    public String getFoto() {
        return foto;
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
}
