package com.ti.java.polymorphism.overload;

import com.ti.java.Browsers;

public class Robot {
    public void hello() {
        System.out.println("Hello, I'm a Republic Robot");
    }

    public void hello(String name) {
        System.out.println("Hello, my robot name is " + name);
    }

    public void hello(String name, int age) {
        System.out.println("Hello, my robot name is " + name + " and my age is " + age);
    }

    public String selectBrowser(Browsers b) {
        String broweerSelected = switch (b) {
            case EDGE -> "Opening Edge browser";
            case CHROME -> "Opening Chrome browser";
            case FIREFOX -> "Opening Firefox browser";
            default -> "Bad option";
        };
        return broweerSelected;
    }

}
