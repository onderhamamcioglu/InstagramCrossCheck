package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("InstaCross v1.1");
        Thread.sleep(1500);
        System.out.println("Developed by: *insert cool name here*" + "\n");
        Thread.sleep(2000);
        System.out.print("Please enter how many hashtags you want to search for (min. 2): ");
        Scanner scanner1 = new Scanner(System.in);
        int hashtagNumber = scanner1.nextInt();
        String[] hashtagArray = new String[hashtagNumber];
        System.out.println("Please enter your hashtags:");
        Scanner scanner2 = new Scanner(System.in);
        for(int i = 0; i < hashtagNumber; i++){
            System.out.print("#");
            hashtagArray[i] = scanner2.nextLine();
        }
        UrlCreator urls = new UrlCreator();
        String[] urlArray = new String[hashtagNumber];
        urlArray = urls.createUrl(hashtagArray, hashtagNumber);
        PageDownloader pageDownloader = new PageDownloader();
        pageDownloader.PageDownloader(hashtagArray,urlArray,hashtagNumber);
        Replacer replacer = new Replacer();
        replacer.Replacer(hashtagNumber, hashtagArray);
        ShortCodeComparer shortCodeComparer = new ShortCodeComparer();
        String commonPosts = shortCodeComparer.ShortCodeComparer(hashtagNumber, hashtagArray);
        PostLinkCreator postLinkCreator = new PostLinkCreator();
        postLinkCreator.PostLinkCreator(commonPosts);
        Thread.sleep(500);
        System.out.println();
        System.out.println("You can remove leftover files if you want");
        scanner1.close();
        scanner2.close();
        Thread.sleep(5000);

        //TODO clean leftovers on first patch
    }
}