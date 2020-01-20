package com.example.adopet;

public class appvar {
    //URL to our login.php file, url bisa diganti sesuai dengan alamat server kita
    public static final String LOGIN_URL = "https://ardhan21.000webhostapp.com/login.php";
    public static final String GET_SELURUH_HEWAN_URL = "https://ardhan21.000webhostapp.com/seluruhdatahewan.php";
    public static final String ISIAKUN_URL = "https://ardhan21.000webhostapp.com/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    //AKUN
    public static final String KEY_NAMAPENGGUNA = "namapengguna";
    public static final String KEY_KATASANDI = "katasandi";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NOWA = "nowhatsapp";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_PROVINSI = "provinsi";
    public static final String KEY_KABUPATEN = "kabupaten";
    public static final String KEY_FOTO = "foto";

    //HEWAN
    public static final String KEY_ID = "id";
    public static final String KEY_NAMAHEWAN = "nama";
    public static final String KEY_JK = "jk";
    public static final String KEY_USIA = "usia";
    public static final String KEY_VAKSIN = "vaksin";
    public static final String KEY_STERIL = "steril";
    public static final String KEY_KATEGORI = "kategori";






    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";
}
