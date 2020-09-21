package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
        return new FirefoxDriver();
    };

    //add more suppliers here

    //add all the drivers into a map
    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver getDriver(String browserName) {
        WebDriver webDriver = null;
        for (DriverType type : DriverType.values()) {
            if (type.toString().equalsIgnoreCase(browserName.toLowerCase())) {
                webDriver = driverMap.get(type).get();
                break;
            }
        }
        if (webDriver == null)
            System.out.println("Don't support browser: " + browserName);
        return webDriver;
    }


}
