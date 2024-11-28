package Imp;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InvertedIndex {
    private final Map<String, List<Integer>> index = new HashMap<>();
    private JSONArray jsonArray;

    /**
     * Loads the JSON file and builds the inverted index.
     *
     * @param jsonFilePath Path to the JSON file.
     * @throws IOException If the file cannot be read.
     */
    public void buildIndex(String jsonFilePath) throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        jsonArray = new JSONArray(jsonContent);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dataBlock = jsonArray.getJSONObject(i);
            extractWordsFromJson(dataBlock, i);
        }
    }

    /**
     * Extracts words from a JSON object and adds them to the index.
     *
     * @param jsonObject The JSON object to process.
     * @param indexValue The index of the JSON object in the array.
     */
    private void extractWordsFromJson(JSONObject jsonObject, int indexValue) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            if (value instanceof String) {
                String[] words = ((String) value).toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    index.computeIfAbsent(word, k -> new ArrayList<>()).add(indexValue);
                }
            } else if (value instanceof JSONObject) {
                extractWordsFromJson((JSONObject) value, indexValue);
            } else if (value instanceof JSONArray) {
                extractWordsFromJson((JSONArray) value, indexValue);
            }
        }
    }

    /**
     * Extracts words from a JSON array and adds them to the index.
     *
     * @param jsonArray The JSON array to process.
     * @param indexValue The index of the JSON object in the array.
     */
    private void extractWordsFromJson(JSONArray jsonArray, int indexValue) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);

            if (value instanceof String) {
                String[] words = ((String) value).toLowerCase().split("\\W+");
                for (String word : words) {
                    index.computeIfAbsent(word, k -> new ArrayList<>()).add(indexValue);
                }
            } else if (value instanceof JSONObject) {
                extractWordsFromJson((JSONObject) value, indexValue);
            } else if (value instanceof JSONArray) {
                extractWordsFromJson((JSONArray) value, indexValue);
            }
        }
    }

    /**
     * Searches for a word in the index and retrieves matching JSON objects.
     *
     * @param word The word to search for.
     * @return A list of matching JSON objects.
     */
    public List<JSONObject> search(String word) {
        List<JSONObject> results = new ArrayList<>();
        List<Integer> indices = index.getOrDefault(word.toLowerCase(), Collections.emptyList());

        for (int idx : indices) {
            results.add(jsonArray.getJSONObject(idx));
        }

        return results;
    }
}
