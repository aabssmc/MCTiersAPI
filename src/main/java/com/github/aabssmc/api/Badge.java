package com.github.aabssmc.api;

import org.json.JSONObject;

@SuppressWarnings("unused")
public class Badge {
    public Badge(JSONObject json) {
    }

    private JSONObject json;

    public String getTitle(){
        return json.getString("title");
    }

    public String getDescription(){
        return json.getString("desc");
    }
}
