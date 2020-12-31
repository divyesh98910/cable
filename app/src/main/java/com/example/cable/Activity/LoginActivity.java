package com.example.cable.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cable.Model.Common;
import com.example.cable.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etMobileNo, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        etMobileNo = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(v -> {
            if (etMobileNo.getText().toString().trim().length() != 10) {
                Toast.makeText(LoginActivity.this, "Enter valid mobile no", Toast.LENGTH_SHORT).show();
            } else if (etPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Enter valid password", Toast.LENGTH_SHORT).show();
            } else {
                JSONObject prams = new JSONObject();
                try {
                    prams.put("mno", etMobileNo.getText().toString());
                    prams.put("pwd", etPassword.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest(Common.LOGIN,prams
                        ,object -> {
                    try {
                        Toast.makeText(this, object.toString(), Toast.LENGTH_SHORT).show();
                        if (object.has("success") && object.getInt("success") == 1) {
                            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            getSharedPreferences(Common.IS_LOGIN, MODE_PRIVATE).edit().putBoolean(Common.IS_LOGIN, true).apply();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(this, "Invalid details", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, error -> Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show()) {
//                    @Override
//                    protected Map<String, String> getParams() {
//                        Map<String, String> map = new HashMap<>();
//                        map.put("mno", etMobileNo.getText().toString());
//                        map.put("pwd", etPassword.getText().toString());
//                        return map;
//                    }
                };
                Volley.newRequestQueue(getApplicationContext()).add(request);
            }
        });


    }
}