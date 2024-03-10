package com.github.aabssmc.api;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TierPlayer {
    public TierPlayer(JSONObject json) {
        this.json = json;
    }

    private final JSONObject json;

    public String getUUID(){
        return json.getString("uuid");
    }

    public String getName(){
        return json.getString("name");
    }

    public String getRegion(){
        return json.getString("region");
    }

    public Integer getPoints(){
        return json.getInt("points");
    }

    public Integer getOverall(){
        return json.getInt("overall");
    }

    @Nullable
    public List<Badge> getBadges(){
        JSONArray json;
        try {
            json = this.json.getJSONArray("badges");
        } catch (JSONException ignored){
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for(int i = 0; i < json.length(); ++i) {
            badges.add(new Badge(json.getJSONObject(i)));
        }
        return badges;
    }

    @Nullable
    public Ranking getRankings(){
        try {
            return new Ranking(json.getJSONObject("rankings"), json.getInt("overall"));
        } catch (JSONException ignored){
            return null;
        }
    }

}
