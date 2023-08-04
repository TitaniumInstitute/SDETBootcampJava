package com.ti.selenium.commands;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class WindowManageExample extends BaseTestClass {
    @Test
    void manageWindows() {
        driver.navigate().to(demoSiteUrl);
        getSizeAndPosition();
        setSizeAndPositon();
        getSizeAndPosition();
        wait(3);
        driver.manage().window().maximize();
        wait(3);
        driver.manage().window().minimize();
        wait(3);
        driver.manage().window().fullscreen();
        wait(3);

    }

    private void getSizeAndPosition() {
        Dimension size = driver.manage().window().getSize();
        System.out.println(String.format("La altura de la ventana es de: %d píxeles", size.height));
        System.out.println(String.format("El ancho de la ventana es de: %d píxeles", size.width));

        Point position = driver.manage().window().getPosition();
        System.out.println(String.format("La posicion en X de la ventana es: %d píxeles", position.getX()));
        System.out.println(String.format("La posicion en Y de la ventana es: %d píxeles", position.getY()));
    }

    private void setSizeAndPositon() {
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.manage().window().setPosition(new Point(0, 0));
    }
}
