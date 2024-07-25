import java.util.*;

public class CharacterFrequency {

    public static void main(String[] args) {
        String input = "a bB ;cb";
        String result = getCharacterFrequency(input);
        System.out.println(result);
    }

    public static String getCharacterFrequency(String input) {
        // Remove non-alphabetical characters and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequencies of each character
        for (char c : cleanedInput.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a list of Map entries
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list based on frequency in descending order
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            result.append(entry.getValue()).append(entry.getKey());
        }

        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
