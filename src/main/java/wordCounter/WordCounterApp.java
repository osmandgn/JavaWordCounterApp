package wordCounter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/wordCounter/text.txt";
        String str = readerMethod(filePath);
        sortByQuantity(wordCounter(str));


    }


    public static String readerMethod(String filePath) throws IOException {
        String text = "";
        text = new String(Files.readAllBytes(Paths.get(filePath))).replaceAll("\\p{Punct}", "");
        String str = text;
        return str.toLowerCase();
    }

    public static HashMap<String, Integer> wordCounter(String str) {
        HashMap<String, Integer> wordList = new HashMap<>();
        String[] arr = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : arr) {
            Integer counter = map.get(w);
            if (counter == null) {
                map.put(w, 1);
            } else {
                map.put(w, counter + 1);
            }
        }
        return map;
    }

    public static void sortByQuantity(HashMap<String, Integer> map) {
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));


    }
}

