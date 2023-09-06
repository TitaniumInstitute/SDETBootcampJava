package com.ti.baseuimobile;

import com.ti.baseuimobile.model.DriverOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class MobileDriverFactory {
    private static MobileDriverFactory instance = new MobileDriverFactory();
    private UiAutomator2Options androidOptions;
    private XCUITestOptions iosOptions;

    public static MobileDriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    public AppiumDriver getMobileDriver(){
        return appiumDriver.get();
    }


    public void setMobileDriver(DeviceOSType deviceOS, DriverOptions options){
        switch (deviceOS){
            case ANDROID -> {
                androidOptions = new UiAutomator2Options();
                androidOptions.setPlatformName("Android");
                androidOptions.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
                androidOptions.setDeviceName(options.getDeviceName());
                androidOptions.setApp(options.getAppName());
                androidOptions.setAppWaitActivity(options.getAppActivity());

                try {
                    appiumDriver.set(new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), androidOptions));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
            case IOS -> {
                iosOptions = new XCUITestOptions();
                iosOptions.setAutomationName(AutomationName.IOS_XCUI_TEST);
                iosOptions.setDeviceName(options.getDeviceName());
                iosOptions.setApp(options.getAppName());
                iosOptions.setWdaLaunchTimeout(Duration.ofSeconds(30));

                try {
                    appiumDriver.set(new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), iosOptions));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void removeMobileDriver(){
        appiumDriver.get().quit();
        appiumDriver.remove();
    }
}
