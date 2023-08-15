package com.restassured;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.math.BigDecimal;

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
        //2.0 (+/-) 1.5 to 2.5
        assertThat(new BigDecimal("1.8"), is(closeTo(new BigDecimal("2.0"), new BigDecimal("0.5"))));
    }

    // Collections Matchers
    
}
