package com.emirleroglu.stocksproject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;


import java.lang.reflect.Type;
import java.util.List;

public class HisseList {

    public JSONArray getMyArr () throws UnirestException {
        HttpRequest request = Unirest.get("http://bigpara.hurriyet.com.tr/api/v1/hisse/list").
                header("accept", "application/json");

        HttpResponse<JsonNode> response =request.asJson();

        JSONArray myObjJSONArray= response.getBody().getObject().getJSONArray("data");



        return myObjJSONArray;

    }

    public   List parseJson() throws UnirestException {
        Gson gson = new Gson();
        Type type = new TypeToken<List<HisseBasic>>(){}.getType();
        getMyArr().toString();
        List<HisseBasic> contactList = gson.fromJson(getMyArr().toString(), type);

        return contactList;
    }













    public HisseList() throws UnirestException {
    }
}
