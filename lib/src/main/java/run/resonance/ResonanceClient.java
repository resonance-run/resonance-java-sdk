/*
 * This source file was generated by the Gradle 'init' task
 */
package run.resonance;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import run.resonance.customization.*;
import run.resonance.customization.network.PostBody;

public class ResonanceClient<K> {
    private String baseUrl;
    private String apiKey;
    private String clientId;

    final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.get("application/json");

    public ResonanceClient(String baseUrl, String apiKey, String clientId) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.clientId = clientId;
    }

    public <T extends Object> T getCustomizations(K userData, String customizationType,
            String surfaceId, T defaultValue, Class<T> classOfT) {
        Gson gson = new Gson();
        Type apiResponseType = TypeToken.getParameterized(APIResponse.class, classOfT).getType();
        String jsonResponse = getCustomizationDataFromAmplifierStore(userData, customizationType, surfaceId);
        try {
            APIResponse<T> response = gson.fromJson(jsonResponse, apiResponseType);
            if (response.values != null) {
                return response.values;
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private String getCustomizationDataFromAmplifierStore(K userData, String customizationType, String surfaceId) {
        Gson gson = new Gson();
        String json = gson.toJson(new PostBody<K>(userData, apiKey, clientId, customizationType, surfaceId));
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(baseUrl + "/customizations?valuesOnly=true")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException exception) {
            return "{\"userData\": null, \"customizations\": {}}";
        }
    }
}
