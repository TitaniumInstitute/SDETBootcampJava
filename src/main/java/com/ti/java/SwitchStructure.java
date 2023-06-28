package com.ti.java;

public class SwitchStructure {
    static String hero = "Spider-Man";
    static String loki = "";

    public static void main(String[] args) {
        /*switch (hero){
            case "Iron-Man":
                loki = "Mandarín";
                break;
            case "Spider-Man":
                loki = "Venom";
                break;
            case "Hulk":
                loki = "Abomination";
                break;
            case "DareDevil":
                loki = "Kingpin";
                break;
            default:
                loki = "Loki";
        }*/

        /*switch (hero){
            case "Iron-Man" -> { loki = "Mandarín";}
            case "Spider-Man" -> {loki = "Venom";}
            case "Hulk" -> {loki = "Abomination";}
            case "DareDevil" -> {loki = "Kingpin";}
            default -> {loki = "Loki";}
        }*/

        loki = switch (hero) {
            case "Iron-Man" -> "Mandarín";
            case "Spider-Man" -> "Venom";
            case "Hulk" -> "Abomination";
            case "DareDevil" -> "Kingpin";
            default -> "Loki";
        };

        System.out.println(loki);
    }
}
