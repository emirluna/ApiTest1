package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.common.Constantes;
import com.example.myapplication.common.SharedPreferencesManager;
import com.example.myapplication.retrofit.MiniClient;
import com.example.myapplication.retrofit.MiniService;
import com.example.myapplication.retrofit.request.RequestLogin;
import com.example.myapplication.retrofit.response.ResponseAuth;
import com.example.myapplication.ui.DashboardActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    EditText ETemail, ETpassword;
    MiniClient miniClient;
    MiniService miniService;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        miniClient = MiniClient.getInstance();
        miniService = miniClient.getMiniService();
    }


    private void findViews() {
        btn1 = findViewById(R.id.button);
        ETemail = findViewById(R.id.editTextEmail);
        ETpassword = findViewById(R.id.editTextPassword);
    }

    private void events() {
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button:
                goToLogin();
                break;
        }

    }

    private void goToLogin() {
        String email = ETemail.getText().toString();
        String password = ETpassword.getText().toString();

        if(email.isEmpty()){
            ETemail.setError("Email es requerido");
        } else if(password.isEmpty()){
            ETpassword.setError("Password es requerido");
        } else{

            RequestLogin requestLogin = new RequestLogin(email, password);
            Call<ResponseAuth> call = miniService.doLogin(requestLogin);
            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Todo ok", Toast.LENGTH_SHORT).show();
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_TOKEN, response.body().getToken());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_NAME, response.body().getUsername());
                        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(i);

                        //Destruir el activity
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Algo salio mal, revise sus datos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Problema de conexión", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
