package br.com.estudo.model;

public class RetornoServidor {

    private String token;
    private boolean success;
    private String timezone;
    private Usuario uder;
    private String msg;

    public RetornoServidor(String token, boolean success, String timezone, Usuario uder, String msg) {
        this.token = token;
        this.success = success;
        this.timezone = timezone;
        this.uder = uder;
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Usuario getUder() {
        return uder;
    }

    public void setUder(Usuario uder) {
        this.uder = uder;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
