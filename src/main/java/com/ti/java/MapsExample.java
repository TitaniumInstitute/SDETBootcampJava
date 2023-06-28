package com.ti.java;

import java.util.*;

public class MapsExample {
    public static void main(String[] args) {
        /*Map<String,Integer> numsMap = new HashMap<>();

        numsMap.put("a", 100);
        numsMap.put("b",200);
        numsMap.put("c", 300);
        numsMap.put("d",400);


        System.out.println(numsMap.size());

        for (Map.Entry<String,Integer> subMapNum:numsMap.entrySet()) {
            System.out.println(subMapNum.getKey() + ": " + subMapNum.getValue() );
        }*/

        /*Map<String,String> users = new HashMap<>();
        users.put("Admin", "Señor Barriga");
        users.put("NormalUser", "Kiko");
        users.put("SuperUser", "Don Ramón");
        users.put("Guest", "Doña Florinda");
        users.put("Guest", "Doña Florinda");

        System.out.println(users.size());

        for (Map.Entry<String,String> user: users.entrySet()) {
            if (user.getKey().equals("Admin")){
                System.out.println("The Admin value is: " + user.getValue());
            }
            System.out.println(user.getKey());
        }*/

       /* Map<Integer,Double> gamePrices = new LinkedHashMap<>();

        gamePrices.put(1,30.00);
        gamePrices.put(2,43.50);
        gamePrices.put(3,55.99);
        gamePrices.put(4,12.25);
        gamePrices.put(5,0.00);
        gamePrices.put(6, 100.00);
        gamePrices.put(6, 100.00);

        System.out.println(gamePrices.size());

        for (Map.Entry<Integer,Double> gamePrice: gamePrices.entrySet()) {
            System.out.println("The primary key in the DB is: " + gamePrice.getKey() + " and the price is $"+ gamePrice.getValue());
        }*/

        Map<String, List<String>> dropDownInfo = new LinkedHashMap<>();
        List<String> lstFruit = new ArrayList<>();
        lstFruit.add("Pineapple");
        lstFruit.add("Banana");
        lstFruit.add("Apple");
        lstFruit.add("BlueBerry");

        dropDownInfo.put("Fruits", lstFruit);

        for (Map.Entry<String, List<String>> fruit : dropDownInfo.entrySet()) {
            System.out.println("My " + fruit.getKey() + " contains " + fruit.getValue());
            //fruit.getValue().forEach(System.out::println);
            Iterator<String> i = fruit.getValue().iterator();

            while (i.hasNext())
                if (i.next().equals("Banana")) {
                    System.out.println("I found the Banana");
                }
            //System.out.println(i.next());

            /*fruit.getValue().forEach(x-> {
                if (x.equals("Banana")){
                    System.out.println("I found the Banana");
                }
            });*/
        }


    }
}
