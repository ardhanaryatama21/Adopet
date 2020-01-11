package com.example.adopet;

public class appvar {
    //URL to our login.php file, url bisa diganti sesuai dengan alamat server kita
    public static final String LOGIN_URL = "https://ardhan21.000webhostapp.com/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_NAMAPENGGUNA = "namapengguna";
    public static final String KEY_KATASANDI = "katasandi";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";
}
