package com.chrosciu.java12demo;

import java.util.stream.IntStream;

public class Contest {
    public static void main(String... args) {
        IntStream.range(1, 7)
            .mapToObj((final var i) -> (switch (i % 3) {
                case 1 -> "*";
                case 2 -> "^";
                default -> "#";
            }).repeat(i))
            .forEach(System.out::println);
    }
}
