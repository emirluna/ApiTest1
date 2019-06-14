
package com.example.myapplication.retrofit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestSignup {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("rol")
    @Expose
    private String rol;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestSignup() {
    }

    /**
     * 
     * @param nombre
     * @param email
     * @param token
     * @param rol
     * @param password
     */
    public RequestSignup(String token, String nombre, String email, String password, String rol) {
        super();
        this.token = token;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RequestSignup withToken(String token) {
        this.token = token;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RequestSignup withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RequestSignup withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RequestSignup withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public RequestSignup withRol(String rol) {
        this.rol = rol;
        return this;
    }

}
