package com.example.adopet.SharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.adopet.Login;

import java.util.HashMap;

public class Session {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Email address (make variable public to access from outside)
    public static final String KEY_nama = "nama";
    public static final String KEY_email = "email";
    public static final String KEY_nowhatsapp = "nowhatsapp";
    public static final String KEY_namapengguna = "namapengguna";
    public static final String KEY_katasandi= "katasandi";
    public static final String KEY_provinsi= "provinsi";
    public static final String KEY_kabupaten= "kabupaten";

    // Constructor
    public Session(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     *
     * Create login session
     * */
    public void createLoginSession(String nama, String email, String nowhatsapp, String namapengguna,
                                   String katasandi, String provinsi, String kabupaten){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing email in pref
        editor.putString(KEY_nama, nama);
        editor.putString(KEY_email, email);
        editor.putString(KEY_nowhatsapp,nowhatsapp);
        editor.putString(KEY_namapengguna,namapengguna);
        editor.putString(KEY_katasandi,katasandi);
        editor.putString(KEY_provinsi,provinsi);
        editor.putString(KEY_kabupaten,kabupaten);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If true it will redirect user to UserActivity Page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            // Closing all the Activities
            i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP|i.FLAG_ACTIVITY_CLEAR_TASK|i.FLAG_ACTIVITY_NEW_TASK);

            // Staring Main Activity
            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user email id
        user.put(KEY_nama, pref.getString(KEY_nama, null));
        user.put(KEY_email, pref.getString(KEY_email, null));
        user.put(KEY_nowhatsapp, pref.getString(KEY_nowhatsapp, null));
        user.put(KEY_namapengguna, pref.getString(KEY_namapengguna,null));
        user.put(KEY_katasandi, pref.getString(KEY_katasandi,null));
        user.put(KEY_provinsi, pref.getString(KEY_provinsi,null));
        user.put(KEY_kabupaten, pref.getString(KEY_kabupaten,null));
        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent intent = new Intent(_context, Login.class);
        // Closing all the Activities
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP|intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(intent);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
