package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortCodeComparer {
    public static String ShortCodeComparer(int hashtagNumber, String[] hashtags) throws InterruptedException, FileNotFoundException {
        System.out.println("Searching for common posts in given hashtags...");
        Thread.sleep(300);
        String shortcodes = new String();
        for(int i = 0; i < hashtagNumber; i++){
            Scanner fileToRead = new Scanner(new File(hashtags[i] + ".json"));
            while (fileToRead.hasNextLine()) {
                shortcodes = shortcodes + " " + fileToRead.nextLine();
            }
        }
        int count;
        String duplicates = new String();
        String words[] = shortcodes.split(" ");
        for(int i = 0; i < words.length; i++) {
            count = 1;
            for(int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])) {
                    count++;
                    words[j] = "0";
                }
            }
            if(count > 1 && words[i] != "0"){
                duplicates = words[i] + " " +duplicates;
            }
        }
        return duplicates;
    }
}