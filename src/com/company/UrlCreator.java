package com.company;

public class UrlCreator {
    public String[] createUrl (String hashtags[], int hashtagCount) throws InterruptedException {
        String[] urlArray = new String[hashtagCount];
        System.out.println("Generating URLs...");
        for(int i = 0; i < hashtagCount; i++){
            urlArray[i] = "https://www.instagram.com/explore/tags/" + hashtags[i] + "/?__a=1";
            System.out.println(urlArray[i]);
            Thread.sleep(300);
        }
        return urlArray;
    }
}