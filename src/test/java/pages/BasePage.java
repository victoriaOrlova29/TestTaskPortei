package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String URL = "C:\\Users\\OrlovaVictoria\\TestTaskPortei\\src\\test\\resources\\qa-test.html";
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }


}
