package com.ti.testng.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    @Test
    @Parameters("browser")
    void executeCrossBrowser(String browser) {
        String navigatorStarted;
        navigatorStarted = switch (browser.toLowerCase()) {
            case "chrome" -> "Chrome Browser Started!" + Thread.currentThread().threadId();
            case "firefox" -> "FireFox Browser Started!" + Thread.currentThread().threadId();
            case "edge" -> "Edge Browser Started!" + Thread.currentThread().threadId();
            case "safari" -> "Safari Browser Started!" + Thread.currentThread().threadId();
            default -> "Option not included!" + Thread.currentThread().threadId();
        };

        System.out.println(navigatorStarted);
    }
}
