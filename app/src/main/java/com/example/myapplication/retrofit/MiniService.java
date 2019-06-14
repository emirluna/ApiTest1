package com.example.myapplication.retrofit;

import com.example.myapplication.retrofit.request.RequestLogin;
import com.example.myapplication.retrofit.request.RequestMensaje;
import com.example.myapplication.retrofit.request.RequestSignup;
import com.example.myapplication.retrofit.response.ResponseAuth;
import com.example.myapplication.retrofit.response.ResponseMensaje;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MiniService {

    @POST("auth/login")
    Call<ResponseAuth> doLogin(@Body RequestLogin requestLogin);

    @POST("auth/signup")
    Call<ResponseAuth> doSignUp(@Body RequestSignup requestSignup);

    @POST("mensajes")
    Call<ResponseMensaje> doMensaje(@Body RequestMensaje requestMensaje);



}
