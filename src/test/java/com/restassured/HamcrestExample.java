package com.restassured;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExample {

    String favoriteCar;

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
}
