package com.github.aabssmc.api;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Ranking Class
 */
@SuppressWarnings("unused")
public class Ranking {

    /**
     * @param json The json object.
     */
    public Ranking(JSONObject json) {
        this.json = json;
    }

    private final JSONObject json;

    /**
     * @param rank The rank type.
     * @return The current tier of the player's rank.
     */
    @Nullable
    public Integer getTier(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("tier");
        } catch (JSONException ignored){
            return null;
        }
    }
    /**
     * @param rank The rank type.
     * @return The current position of the player's rank.
     */

    @Nullable
    public Integer getPosition(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("pos");
        } catch (JSONException ignored){
            return null;
        }
    }

    /**
     * @param rank The rank type.
     * @return The peak tier of the player's rank.
     */
    @Nullable
    public Integer getPeakTier(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("peak_tier");
        } catch (JSONException ignored){
            return null;
        }
    }

    /**
     * @param rank The rank type.
     * @return The peak position of the player's rank.
     */
    @Nullable
    public Integer getPeakPosition(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("peak_position");
        } catch (JSONException ignored){
            return null;
        }
    }

    /**
     * @param rank The rank type.
     * @return The attained of the player's rank.
     */
    @Nullable
    public Integer getAttained(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getInt("attained");
        } catch (JSONException ignored){
            return null;
        }
    }

    /**
     * @param rank The rank type.
     * @return True if the player has retired from the specified rank.
     */
    @Nullable
    public Boolean isRetired(RankType rank){
        try {
            return json.getJSONObject(rank.getName()).getBoolean("retired");
        } catch (JSONException ignored){
            return null;
        }
    }

}

