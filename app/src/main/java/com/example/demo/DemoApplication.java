package com.example.demo;

import java.util.stream.IntStream;

import com.google.common.collect.Streams;

public class DemoApplication {

    public static void main(String[] args) {
        Streams.findLast(IntStream.range(0, 1));
    }

}
