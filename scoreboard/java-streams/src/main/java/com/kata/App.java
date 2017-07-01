package com.kata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        Process
            .process(getConsoleInputStream())
            .forEach(effect -> effect.execute());

    }

    private static Stream<String> getConsoleInputStream() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.lines();
    }


}
