package driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return tlDriver.get();
    }

    public static void setChromeDriver(int wait) {
        //Map<String,String> mobileEmulation = Map.of("deviceName","Samsung Galaxy S8+" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-sertificate-errors");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        //options.setExperimentalOption("mobileEmulation", mobileEmulation);
        //options.addArguments("headless=true"); // Не!!!

        WebDriver driver = new ChromeDriver(); //!!!(options)
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        tlDriver.set(driver);
    }
    public static void setFirefoxDriver(int wait) {
        Map<String,String> mobileEmulation = Map.of("deviceName","Samsung Galaxy S8+" );
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--ignore-sertificate-errors");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        tlDriver.set(driver);
    }

    public static void setEdgeDriver(int wait) {
        Map<String,String> mobileEmulation = Map.of("deviceName","Samsung Galaxy S8+" );
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--ignore-sertificate-errors");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        //options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        tlDriver.set(driver);
    }

    public static void quitDriver(){
        if(tlDriver.get() !=null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}