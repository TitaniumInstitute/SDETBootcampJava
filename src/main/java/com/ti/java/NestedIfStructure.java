package com.ti.java;

public class NestedIfStructure {
    public static void main(String[] args) {
        String hero = "Spider-Man";
        String multiverseHero = "Miles Morales";
        String loki = "";

        if (hero.equals("Iron-Man")) {
            loki = "Mandarín";
        } else if (hero.equals("Spider-Man")) {
            if (multiverseHero.equals("Miles Morales")) {
                loki = "The Spot";
            } else {
                loki = "Venom";
            }
        } else if (hero.equals("Hulk")) {
            loki = "Abomination";
        } else if (hero.equals("DareDevil")) {
            loki = "KingPin";
        } else {
            loki = "Loki";
        }

        System.out.println(loki);
    }
}
