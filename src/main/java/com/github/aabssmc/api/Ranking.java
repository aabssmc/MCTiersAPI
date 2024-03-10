package com.github.aabssmc.api;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class Ranking {

    public Ranking(JSONObject json, int overall) {
        this.json = json;
    }

    private final JSONObject json;

    @Nullable
    public Integer getTier(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("tier");
        } catch (JSONException ignored){
            return null;
        }
    }

    @Nullable
    public Integer getPosition(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("pos");
        } catch (JSONException ignored){
            return null;
        }
    }

    @Nullable
    public Integer getPeakTier(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("peak_tier");
        } catch (JSONException ignored){
            return null;
        }
    }

    @Nullable
    public Integer getPeakPosition(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("peak_position");
        } catch (JSONException ignored){
            return null;
        }
    }

    @Nullable
    public Integer getAttained(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("attained");
        } catch (JSONException ignored){
            return null;
        }
    }

    @Nullable
    public Boolean isRetired(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getBoolean("retired");
        } catch (JSONException ignored){
            return null;
        }
    }

}

