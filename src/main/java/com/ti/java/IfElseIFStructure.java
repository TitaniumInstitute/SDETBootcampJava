package com.ti.java;

public class IfElseIFStructure {
    public static void main(String[] args) {
        String hero = "Spider-Man";
        String loki = "";

        if (hero.equals("Iron-Man")) {
            loki = "Mandarín";
        } else if (hero.equals("Spider-Man")) {
            loki = "Venom";
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
