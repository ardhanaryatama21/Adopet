package com.example.adopet.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "https://ardhan21.000webhostapp.com/config.php";
    private Map<String, String> params;

    public LoginRequest(String namapengguna, String katasandi, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("namapengguna",namapengguna);
        params.put("katasandi",katasandi);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
