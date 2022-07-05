package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageDownloader {
    public static void PageDownloader(String[] hashtags, String[] urls, int urlNumber) throws IOException, InterruptedException {
        System.out.println("Downloading pages...");
        Thread.sleep(300);
        for(int i = 0; i < urlNumber; i++){
            URL url = new URL(urls[i]);
            try(
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(hashtags[i] + ".json"));
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
                System.out.println(urls[i] + " downloaded.");
            }
        }
    }
}