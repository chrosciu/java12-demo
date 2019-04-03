package com.chrosciu.java12demo;

import java.io.IOException;

public class SupportedFeatures {

    public static void main(String[] args) {
        var text = "AAA";
        System.out.println(text);

        for (var i = 0; i < 5; ++i) {
            System.out.println(i);
        }

        try (var inputStream = SupportedFeatures.class.getResourceAsStream("/remarks1.txt")) {
            var fileAsBytes = inputStream.readAllBytes();
            var fileAsString = new String(fileAsBytes);
            System.out.println(fileAsString);
        } catch (IOException e) {
            System.out.println("Ooops! " + e);
        }
    }

}
