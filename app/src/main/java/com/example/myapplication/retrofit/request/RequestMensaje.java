
package com.example.myapplication.retrofit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestMensaje {

    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestMensaje() {
    }

    /**
     * 
     * @param nick
     * @param mensaje
     */
    public RequestMensaje(String nick, String mensaje) {
        super();
        this.nick = nick;
        this.mensaje = mensaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
