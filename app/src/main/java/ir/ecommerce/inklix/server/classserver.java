package ir.ecommerce.inklix.server;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class classserver {
    Context context;
    public classserver(final Context context, final String username, final String password,final String method) {
        this.context = context;
        String keyconnecturl = "http://google.com";
        if(method.equals("1")) {
            keyconnecturl = "http://178.63.50.62:1104/signup";
        }
        if(method.equals("2")){
            keyconnecturl = "http://178.63.50.62:1104/login";
        }
        final String keyusername = "username";
        final String keypassword = "password";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, keyconnecturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> hashmap = new HashMap<>();
                hashmap.put(keypassword, password);
                hashmap.put(keyusername, username);

                return hashmap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
