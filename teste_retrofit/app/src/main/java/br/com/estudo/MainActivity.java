package br.com.estudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.estudo.api.ServiceApi;
import br.com.estudo.model.RetornoServidor;
import br.com.estudo.util.UserDeserializer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //public static final String API_URL_BASE = "https://app.onciencias.org/api/";
    //public static final String API_LOGIN = "u/login/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();

        Gson gson = new GsonBuilder().registerTypeAdapter(RetornoServidor.class, new UserDeserializer()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create( gson ))
                .build();
        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
    }
}
