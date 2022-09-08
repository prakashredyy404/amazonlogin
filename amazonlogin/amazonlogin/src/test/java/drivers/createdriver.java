package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selectors.xpath;

import java.util.HashMap;
import java.util.Map;

public class createdriver extends xpath {

    public static WebDriver intializeDriver() {




        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32 (4)\\chromedriver.exe" );

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();

        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL );
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        options.setExperimentalOption("prefs", prefs);


        return driver;


}}
