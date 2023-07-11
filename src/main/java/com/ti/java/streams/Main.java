package com.ti.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static boolean isPair(Integer n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> results = new ArrayList<>();

        //Programación Imperativa, ¿Cómo se hace?
        /*for (int i=0; i<numbers.size();i++)
            if (numbers.get(i)%2 == 0)
                results.add(numbers.get(i));*/

        //Programación Funcional, Declarativa, ¿Qué hace?
        /*results = numbers.stream()
                        .filter(Main::isPair)
                        .collect(Collectors.toList());*/

        results = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        //.filter((Integer n)->{return n % 2 == 0;})


        System.out.println(results);


    }
}
