package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Replacer {
    public static void Replacer(int hashtagNumber, String[] hashtags) throws IOException, InterruptedException {
        System.out.println("Extracting shortcodes...");
        Thread.sleep(300);
        for(int i = 0; i < hashtagNumber; i++){
            String fileToRead = hashtags[i] + ".json";
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            String content = stringBuilder.toString();
            String keyword = "shortcode";
            int index = content.indexOf(keyword);
            int shortcodeIndex1;
            int shortcodeIndex2;
            String shortcode = new String();
            while (index >= 0){
                index = content.indexOf(keyword, index+keyword.length());
                shortcodeIndex1 = index + 12;
                shortcodeIndex2 = shortcodeIndex1 + 11;
                shortcode = shortcode + content.substring(shortcodeIndex1,shortcodeIndex2) + "\n";
            }
            PrintWriter writer = new PrintWriter(hashtags[i] + ".json");
            writer.print("");
            writer.print(shortcode);
            writer.close();
            System.out.println("Shortcodes for #" + hashtags[i] + " are extracted.");
            Thread.sleep(300);
        }
    }
}