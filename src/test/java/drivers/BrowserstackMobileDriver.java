package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.BrowserstackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static tests.TestBase.MAIN_CONFIG;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("browserstack.user", MAIN_CONFIG.browserstackUser());
        capabilities.setCapability("browserstack.key", MAIN_CONFIG.browserstackKey());
        capabilities.setCapability("app", MAIN_CONFIG.browserstackAppUrl());
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android");
        capabilities.setCapability("name", "first_test");

        return new AndroidDriver(BrowserstackHelper.getBrowserstackUrl(), capabilities);
    }

}
