package wordCounter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/wordCounter/text.txt";
        String str = readerMethod(filePath).toLowerCase();
        System.out.println(wordCounter(str));




    }


    public static String readerMethod(String filePath) throws IOException {
        String text = "";
        text = new String(Files.readAllBytes(Paths.get(filePath))).replaceAll("\\p{Punct}", "");
        String str = text;
        return str.toLowerCase();
    }

    public static String wordCounter(String str) {
        HashMap<String, Integer> wordList = new HashMap<>();
        String list = "";
        String[] arr = str.split(" ");
        ArrayList<String> brr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int counter = 1;
            String s = arr[i];
            wordList.put(s,i);
            for (int j = i + 1; j < arr.length; j++) {
                if (s.equals(arr[j])) counter++;
            }
            if (!brr.contains(s)) {
                brr.add(s);
                list += s + " = " + counter + "\n*******************\n";

            }

        }
        return list;
    }
}
