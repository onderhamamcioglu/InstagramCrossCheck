package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class PostLinkCreator {
    public void PostLinkCreator(String shortcodes) throws InterruptedException, FileNotFoundException {
        String[] shortcodesArray = shortcodes.split(" ");
        int amount = shortcodesArray.length;
        int realAmount = amount - 1;
        System.out.println("Found " + realAmount + " common posts.");
        Thread.sleep(300);
        String[] postLinksArray = new String[amount];
        for(int i = 0; i < amount; i++){
            postLinksArray[i] = "https://www.instagram.com/p/" + shortcodesArray[i];
        }
        String output = "posts_" + ThreadLocalRandom.current().nextInt() % 1000 + ".txt";
        PrintWriter writer = new PrintWriter(output);
        for(int i = 1; i < amount; i++){
            writer.print(postLinksArray[i] + "\n");
            System.out.println(postLinksArray[i]);
            Thread.sleep(100);
        }
        writer.close();
        System.out.println();
        System.out.println();
        Thread.sleep(2000);
        System.out.println("***** Post links are written to " + output + " ******");
    }
}