package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverHelper {
    //private variable
    private static WebDriver driver;

    //private constructor to make sure they do not create an object from this class
    private DriverHelper(){}

    public static WebDriver getDriver(){
        //if my driver is not instaniated before
        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){

            switch(ConfigReader.readProperty("browser")){
                case "chromeGrid":
                    File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setBrowserName("chrome");
                    desiredCapabilities.setPlatform(Platform.ANY);
                    String url = "http://54.161.250.153:4444";
                    try {
                        driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    //driver.manage().window().maximize(); instead of repeating this every case its better to add it on line 38
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    //driver.manage().window().maximize();
                    break;
                default://if you forget to initialize which browser make it chrome
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                   // driver.manage().window().maximize();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
    public static WebDriver getDriver(String browser){
        //if my driver is not instaniated before
        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){

            switch(browser){
                case "chromeGrid":
                    File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setBrowserName("chrome");
                    desiredCapabilities.setPlatform(Platform.ANY);
                    String url = "http://54.161.250.153:4444";
                    try {
                        driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    //driver.manage().window().maximize(); instead of repeating this every case its better to add it on line 38
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    //driver.manage().window().maximize();
                    break;
                default://if you forget to initialize which browser make it chrome
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    // driver.manage().window().maximize();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
