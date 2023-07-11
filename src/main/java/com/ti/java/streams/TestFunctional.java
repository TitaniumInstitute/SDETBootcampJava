package com.ti.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestFunctional {
    public static void main(String[] args) {
        List<Person> people = getSuperPeople();

        // List<Person> females = new ArrayList<>();

        //Imperative ❌
        /*for (Person person:people) {
            if (person.getGender().equals(Gender.FEMALE))
                females.add(person);
        }

        females.forEach(System.out::println);*/

        //Declarative ✅
        //Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //females.forEach(System.out::println);

        //Sort
        List<Person> sorteSuperPeople = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        //sorteSuperPeople.forEach(System.out::println);

        //All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() < 10);

        //System.out.println(allMatch);

        //Any Match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() < 12);
        //System.out.println(anyMatch);

        //None Match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Spider-Man"));

        //System.out.println(noneMatch);

        //Max
        people.stream()
                .max(Comparator.comparing(Person::getAge));
        //.ifPresent(person -> System.out.println(person));
        //.ifPresent(System.out::println);

        people.stream()
                .min(Comparator.comparing(Person::getAge));
        //.ifPresent(System.out::println);

        Map<Gender, List<Person>> groupGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        /*groupGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));*/

        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getAge)
                .ifPresent(System.out::println);
    }

    private static List<Person> getSuperPeople() {
        return List.of(
                new Person("Batman", 35, Gender.MALE),
                new Person("Superman", 33, Gender.MALE),
                new Person("Wonder Woman", 30, Gender.FEMALE),
                new Person("Flash", 26, Gender.MALE),
                new Person("Black Canary", 22, Gender.FEMALE),
                new Person("Batgirl", 21, Gender.FEMALE),
                new Person("Shazam", 12, Gender.MALE)
        );
    }
}
