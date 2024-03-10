package com.github.aabssmc.api;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Tier Player class
 */
@SuppressWarnings("unused")
public class TierPlayer {

    /**
     * Constructs a tier player.
     * @param json The json object.
     */
    public TierPlayer(JSONObject json) {
        this.json = json;
    }

    private final JSONObject json;

    /**
     * @return The uuid of the player.
     */
    public String getUUID(){
        return json.getString("uuid");
    }

    /**
     * @return The name of the player.
     */
    public String getName(){
        return json.getString("name");
    }

    /**
     * @return The region of the player.
     */
    public String getRegion(){
        return json.getString("region");
    }

    /**
     * @return The points of the player.
     */
    public Integer getPoints(){
        return json.getInt("points");
    }

    /**
     * @return The overall level of the player.
     */
    public Integer getOverall(){
        return json.getInt("overall");
    }

    /**
     * Will return null if the player has no badges.
     * @return The badges of the player.
     */
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

    /**
     * Will return null if the user has no ranking, which should not happen.
     * @return The rankings of the player.
     */
    @Nullable
    public Ranking getRankings(){
        try {
            return new Ranking(json.getJSONObject("rankings"));
        } catch (JSONException ignored){
            return null;
        }
    }

}
