
package com.example.myapplication.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMensaje {

    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseMensaje() {
    }

    /**
     * 
     * @param id
     * @param nick
     * @param mensaje
     */
    public ResponseMensaje(String mensaje, String nick, Integer id) {
        super();
        this.mensaje = mensaje;
        this.nick = nick;
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
