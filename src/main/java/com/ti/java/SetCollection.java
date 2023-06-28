package com.ti.java;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String[] args) {
        Set<String> country = new LinkedHashSet<>();

        country.add("México");
        country.add("Canada");
        country.add("Australia");
        country.add("Argentina");

        country.add("México");
        System.out.println(country);
        System.out.println(country.size());

        country.remove("Australia");
        System.out.println("Set after removing Australia" + country);
        System.out.println(country.size());

        Iterator<String> i = country.iterator();

        while (i.hasNext())
            System.out.println(i.next());

    }
}
