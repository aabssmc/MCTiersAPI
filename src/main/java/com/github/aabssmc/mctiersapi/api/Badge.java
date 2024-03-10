package com.github.aabssmc.mctiersapi.api;

import org.json.JSONObject;

/**
 * Badge Class
 */
@SuppressWarnings("unused")
public class Badge {
    /**
     * @param json The json element.
     */
    public Badge(JSONObject json) {
        this.json = json;
    }

    private final JSONObject json;

    /**
     * @return The title of the badge.
     */
    public String getTitle(){
        return json.getString("title");
    }

    /**
     * @return The description of the badge.
     */
    public String getDescription(){
        return json.getString("desc");
    }
}
