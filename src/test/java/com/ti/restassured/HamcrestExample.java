package com.ti.restassured;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExample {

    String favoriteCar;
    List<String> list;

    //Text Matchers
    @Test
    void stringIsEmpty() {
        favoriteCar = "";//null;
        assertThat(favoriteCar, emptyString());
    }

    @Test
    void stringIsEmptySuggar() {
        favoriteCar = "";//null;
        assertThat(favoriteCar, is(emptyString()));
    }

    @Test
    void stringIsEmptyOrNull() {
        favoriteCar = null;
        assertThat(favoriteCar, nullValue());
    }

    @Test
    void stringEqualsTo() {
        favoriteCar = "BMW";
        assertThat(favoriteCar, equalTo("BMW"));
    }

    @Test
    void stringEqualsToIgnoreCase() {
        favoriteCar = "HONDA";
        assertThat(favoriteCar, equalToIgnoringCase("honda"));
    }

    @Test
    void equalsToIgnoringWhitespaces() {
        favoriteCar = "   Nissan        ";
        assertThat(favoriteCar, equalToCompressingWhiteSpace("Nissan"));
    }

    @Test
    void stringContains() {
        favoriteCar = "Mercedez Benz";
        assertThat(favoriteCar, containsString("Ben"));
    }

    @Test
    void stringEndsWith() {
        favoriteCar = "Lamborgini";
        assertThat(favoriteCar, endsWith("gini"));
    }

    @Test
    void stringStartsWith() {
        favoriteCar = "Lamborgini";
        assertThat(favoriteCar, startsWith("Lamb"));
    }

    @Test
    void stringHasOrder() {
        favoriteCar = "Masserati Lamborgini Mercedez BMW";
        assertThat(favoriteCar,
                stringContainsInOrder(Lists.newArrayList("Masserati", "Lamborgini", "Mercedez", "BMW")));
    }

    // Number Matchers
    @Test
    void greaterThanInteger() {
        assertThat(2, greaterThan(1));
    }

    @Test
    void greaterThanOrEqualInteger() {
        assertThat(10, greaterThanOrEqualTo(9));
    }

    @Test
    void lessThanInteger() {
        assertThat(-1, lessThan(1));
    }

    @Test
    void lessThanOrEqualsTo() {
        assertThat(-1, lessThanOrEqualTo(-1));
    }

    @Test
    void closeToDoubleNumber() {
        // 1.0 (+/-) 0.8 to 1.2
        assertThat(0.8, closeTo(1.0, 0.2));
    }

    @Test
    void givenBigDecimalCloseTo() {
        //2.0 (+/-) 1.2 to 2.8
        assertThat(new BigDecimal("4.6"), is(closeTo(new BigDecimal("2.0"), new BigDecimal("0.8"))));
    }

    // Collections Matchers
    @Test
    void ListEmpty() {
        list = new ArrayList<>();
        assertThat(list, empty());
    }

    @Test
    void ListSizeMatch() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        System.out.println(list.size());
        assertThat(list, hasSize(4));
        assertThat(list, iterableWithSize(4));
    }

    @Test
    void listContainsAllValuesInSameOrder() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, contains("Superman", "Batman", "Wonder-Woman", "Zatana"));
    }

    @Test
    void listContainsAllValuesInAnyOrder() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, containsInAnyOrder("Zatana", "Wonder-Woman", "Batman", "Superman"));
    }

    @Test
    void listCotainsValuesInRelativeOrder() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, containsInRelativeOrder("Batman", "Wonder-Woman"));
    }

    @Test
    void listWhenContainsGivenValue() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, hasItem(equalTo("Wonder-Woman")));
        assertThat(list, hasItem(startsWith("Sup")));
        assertThat(list, hasItem(endsWith("ana")));
    }

    @Test
    void listWhenContainsOneOrMoreValues() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, hasItems(startsWith("Won"), endsWith("man"), equalTo("Zatana")));

    }

    @Test
    void mapEmpty() {
        Map<String, String> myMap = new HashMap<>();
        assertThat(myMap, is(anEmptyMap()));
    }
}
