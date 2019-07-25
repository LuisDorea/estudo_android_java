package br.com.estudo.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import br.com.estudo.model.RetornoServidor;

public class UserDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement retornoServidor = json.getAsJsonObject();

        if (json.getAsJsonObject().get("retornoServidor") != null) {
            retornoServidor = json.getAsJsonObject().get("retornoServidor");
        }

        return (new Gson().fromJson(retornoServidor, RetornoServidor.class));
    }
}
