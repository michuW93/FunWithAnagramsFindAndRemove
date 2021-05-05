import java.util.*;

public class Main {
    public static String[] input = {"code", "aaagmnrs", "anagrams", "doce"};

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList(input));
        for (int i = 0; i < input.length - 1; i++) {
            Map<String, Integer> mapWithFirstWordWord = getWordInMap(input[i]);
            for (int j = i + 1; j < input.length; j++) {
                if (isAnagram(mapWithFirstWordWord, getWordInMap(input[j]))) {
                    strings.remove(j);
                }
            }
        }
        strings.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static Map<String, Integer> getWordInMap(String word) {
        Map<String, Integer> mapWithWord = new HashMap<>();
        for (int a = 0; a < word.length(); a++) {
            String letter = String.valueOf(word.charAt(a));
            if (mapWithWord.containsKey(letter)) {
                mapWithWord.put(letter, mapWithWord.get(letter) + 1);
            } else {
                mapWithWord.put(letter, 1);
            }
        }
        return mapWithWord;
    }

    private static boolean isAnagram(Map<String, Integer> mapWithFirstWord, Map<String, Integer> mapWithSecondWord) {
        if (mapWithFirstWord.equals(mapWithSecondWord)) {
            return true;
        }
        return false;
    }
}
