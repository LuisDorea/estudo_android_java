package br.com.estudo.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestHelper {

    private static String URL_BASE = "https://app.onciencias.org/api/";

    public static Retrofit apiConnect() {

        //inicializando o conversor
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //Inicializando o retrofit, com url base, configurações de client, e conversor
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
