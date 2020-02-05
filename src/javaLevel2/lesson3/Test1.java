package javaLevel2.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String words[] = {
                "word1",
                "word2",
                "word3",
                "word4",
                "word1",
                "word3",
                "word4",
                "word5",
                "word1",
                "word5",
                "word8",
                "word6",
                "word11"
        };
        List<String> strings = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (!strings.contains(words[i])) {
                strings.add(words[i]);
            }
        }
        System.out.println(strings.toString());
        for (String s:strings) {
            for (int i = 0; i < words.length; i++) {
                if (s.equals(words[i])) {
                    counter++;
                }

            }
            System.out.println(s + " " + counter + " раз");
            counter = 0;
        }

    }
}
