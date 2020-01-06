package com.example.adopet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adopet.Request.LoginRequest;
import com.example.adopet.SharedPreferences.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity  {
    Button btnLogin;
    TextView txtDaftar;
    private EditText txtkatasandi, txtnamapengguna;
    private Context context;
    ProgressDialog pDialog;
    Intent intent;

    int success;
    ConnectivityManager conMgr;

    private String url = Server.URL + "login.php";

    private static final String TAG = Login.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    public final static String TAG_NAMA = "nama";
    public final static String TAG_EMAIL = "email";
    public final static String TAG_NOWHATSAPP = "nowhatsapp";
    public final static String TAG_KATASANDI = "katasandi";
    public final static String TAG_NAMAPENGGUNA = "namapengguna";
    public final static String TAG_PROVINSI = "provinsi";
    public final static String TAG_KABUPATEN = "kabupaten";

    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedpreferences;
    Boolean session = false;
    String nama, email, nowhatsapp,namapengguna, katasandi, provinsi, kabupaten;
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }

        txtnamapengguna = findViewById(R.id.txtnamapengguna);
        txtkatasandi = findViewById(R.id.txtkatasandi);
        txtDaftar = findViewById(R.id.txtdaftar);
        btnLogin = findViewById(R.id.btnLogin);

        // Cek session login jika TRUE maka langsung buka MainActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        nama = sharedpreferences.getString(TAG_NAMA, null);
        email = sharedpreferences.getString(TAG_EMAIL, null);
        nowhatsapp = sharedpreferences.getString(TAG_NOWHATSAPP, null);
        namapengguna = sharedpreferences.getString(TAG_NAMAPENGGUNA, null);
        katasandi = sharedpreferences.getString(TAG_KATASANDI, null);
        provinsi = sharedpreferences.getString(TAG_PROVINSI, null);
        kabupaten = sharedpreferences.getString(TAG_KABUPATEN, null);


        if (session) {
            Intent intent = new Intent(Login.this, Menu_utama.class);
            intent.putExtra(TAG_NAMA, nama);
            intent.putExtra(TAG_EMAIL, email);
            intent.putExtra(TAG_NOWHATSAPP, nowhatsapp);
            intent.putExtra(TAG_NAMAPENGGUNA, namapengguna);
            intent.putExtra(TAG_KATASANDI, katasandi);
            intent.putExtra(TAG_PROVINSI, provinsi);
            intent.putExtra(TAG_KABUPATEN, kabupaten);
            finish();
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String namapengguna = txtnamapengguna.getText().toString();
                String katasandi = txtkatasandi.getText().toString();

                // mengecek kolom yang kosong
                if (namapengguna.trim().length() > 0 && katasandi.trim().length() > 0) {
                    if (conMgr.getActiveNetworkInfo() != null
                            && conMgr.getActiveNetworkInfo().isAvailable()
                            && conMgr.getActiveNetworkInfo().isConnected()) {
                        checkLogin(namapengguna, katasandi);
                    } else {
                        Toast.makeText(getApplicationContext() ,"Koneksi internet anda terputus", Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext() ,"Isi seluruh kolom terlebih dahulu", Toast.LENGTH_LONG).show();
                }
            }
        });

        txtDaftar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*TODO Auto-generated method stub*/
                intent = new Intent(Login.this, Register.class);
                finish();
                startActivity(intent);
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void checkLogin(final String namapengguna, final String katasandi) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Periksa akun...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {
                        String nama = jObj.getString(TAG_NAMA);
                        String email = jObj.getString(TAG_EMAIL);
                        String nowhatsapp = jObj.getString(TAG_NOWHATSAPP);
                        String namapengguna = jObj.getString(TAG_NAMAPENGGUNA);
                        String katasandi = jObj.getString(TAG_KATASANDI);
                        String provinsi = jObj.getString(TAG_PROVINSI);
                        String kabupaten = jObj.getString(TAG_KABUPATEN);
                        Log.e("Berhasil Masuk!", jObj.toString());

                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        // menyimpan login ke session
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean(session_status, true);
                        editor.putString(TAG_NAMA, nama);
                        editor.putString(TAG_EMAIL, email);
                        editor.putString(TAG_NOWHATSAPP, nowhatsapp);
                        editor.putString(TAG_NAMAPENGGUNA, namapengguna);
                        editor.putString(TAG_KATASANDI, katasandi);
                        editor.putString(TAG_PROVINSI, provinsi);
                        editor.putString(TAG_KABUPATEN, kabupaten);
                        editor.commit();

                        // Memanggil main activity
                        intent = new Intent(Login.this, Menu_utama.class);
                        intent.putExtra(TAG_NAMA, nama);
                        intent.putExtra(TAG_EMAIL, email);
                        intent.putExtra(TAG_NOWHATSAPP, nowhatsapp);
                        intent.putExtra(TAG_NAMAPENGGUNA, namapengguna);
                        intent.putExtra(TAG_KATASANDI, katasandi);
                        intent.putExtra(TAG_PROVINSI, provinsi);
                        intent.putExtra(TAG_KABUPATEN, kabupaten);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                /*params.put("nama", nama);
                params.put("email", email);
                params.put("nowhatsapp", nowhatsapp);*/
                params.put("namapengguna", namapengguna);
                params.put("katasandi", katasandi);
                /*params.put("provinsi", provinsi);
                params.put("kabupaten", kabupaten);*/

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    /*@Override
    public void onClick(View v) {
        if(v == txtDaftar) {
            daftar();
        } else if(v == btnLogin) {
            login();
        }
    }*/
}
