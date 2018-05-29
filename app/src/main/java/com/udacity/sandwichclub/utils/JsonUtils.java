package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.*;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        if (json != null) {
            String mainName, placeOfOrigin, description, image;
            ArrayList<String> alsoKnownAs, ingredients;

            try {
                JSONObject rootJSON = new JSONObject(json);
                JSONObject nameJSON = rootJSON.getJSONObject("name");

                mainName = nameJSON.getString("mainName");
                placeOfOrigin = rootJSON.getString("placeOfOrigin");
                description = rootJSON.getString("description");
                image = rootJSON.getString("image");

                JSONArray alsoKnownAsJSON = nameJSON.getJSONArray("alsoKnownAs");
                alsoKnownAs = new ArrayList<String>();
                for (int i = 0; i < alsoKnownAsJSON.length(); ++i) {
                    alsoKnownAs.add(alsoKnownAsJSON.getString(i));
                }

                JSONArray ingredientsJSON = rootJSON.getJSONArray("ingredients");
                ingredients = new ArrayList<String>();
                for (int i = 0; i < ingredientsJSON.length(); ++i) {
                    ingredients.add(ingredientsJSON.getString(i));
                }
            } catch (JSONException jsxp) {
                return null;
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

            return sandwich;
        }

        return null;
    }
}
