package br.com.estudo.api;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST("u/login/")
    Call<JsonObject> logar(@Body HashMap<String, String> data);

    /*@POST("u/login/{email}{senha}")
    Call<RetornoServidor> getLogin( @Path("email") String email,
                                    @Path("senha") String senha);*/
}
