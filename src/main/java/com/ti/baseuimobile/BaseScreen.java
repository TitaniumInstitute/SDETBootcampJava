package com.ti.baseuimobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public class BaseScreen {
    public static BaseScreen actualScreen;

    public <TScreen extends BaseScreen> TScreen getInstance(Class<TScreen> screen){
        Object obj = initElements(MobileDriverFactory.getInstance().getMobileDriver(), screen);
        return screen.cast(obj);
    }

    private static <T> T initElements(AppiumDriver appiumDriver, Class<T> screenClass){
        T screen = null;
        try {
            screen = screenClass.getConstructor().newInstance();
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),screen);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return screenClass.cast(screen);
    }

    public <TScreen extends BaseScreen> TScreen as(Class<TScreen> screenInstance){
        try {
            return (TScreen)this;
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }
}
