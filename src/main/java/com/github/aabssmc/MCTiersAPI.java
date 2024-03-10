package com.github.aabssmc;

import com.github.aabssmc.api.RankType;
import com.github.aabssmc.api.TierPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * McTiersAPI class.
 */
@SuppressWarnings("unused")
public class MCTiersAPI {

    /**
     * @param NameOrUUID The name or uuid of the player.
     * @return The tier player.
     */
    @Nullable
    public static TierPlayer getPlayer(String NameOrUUID){
        String uuid;
        if (NameOrUUID.length() > 16){
            uuid = NameOrUUID;
        } else{
            uuid = getUUID(NameOrUUID);
        }
        String body = request("https://mctiers.com/api/", "profile/"+uuid);
        if (body == null) return null;
        return new TierPlayer(new JSONObject(body));
    }

    /**
     * @param size The amount of players.
     * @return The top players.
     */
    @Nullable
    public static List<TierPlayer> getTopPlayers(Integer size){
        if (size <= 50 && size>= 1) {
            String body = request("https://mctiers.com/api/", "tier/overall?from=0&count=" + size);
            JSONArray json = new JSONObject(body).getJSONArray("rankings");
            List<TierPlayer> tierPlayers = new ArrayList<>();
            for(int i = 0; i < json.length(); ++i) {
                tierPlayers.add(getPlayer(json.getString(i)));
            }
            return tierPlayers;
        } else {
            return null;
        }
    }

    /**
     * @param size Not sure how this works lmao.
     * @param rank The type of ranking you want.
     * @return The top players.
     */
    @Nullable
    public static List<TierPlayer> getTopPlayers(Integer size, RankType rank){
        if (size <= 50 && size>= 1) {
            String body = request("https://mctiers.com/api/", "tier/" + rank.getName() + "?from=0&count=" + size);
            JSONObject json = new JSONObject(body).getJSONObject("players");
            List<TierPlayer> tierPlayers = new ArrayList<>();
            for (String playerId : json.keySet()) {
                tierPlayers.add(getPlayer(playerId));
            }
            return tierPlayers;
        } else {
            return null;
        }
    }

    @Nullable
    static String request(@NotNull String url, @NotNull String endpoint){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create(url + endpoint))
                .build();
        try {
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get().body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param name The name of a player
     * @return The uuid of the player
     */
    static String getUUID(String name) {
        JSONObject json = new JSONObject(request("https://api.mojang.com/users/", "profiles/minecraft/" + name));
        return json.getString("id");
    }
}