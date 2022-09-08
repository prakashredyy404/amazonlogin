package drivers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selectors.xpath;

import java.util.ArrayList;

public class actions extends  createdriver {
    public static WebDriver driver;

    static {
        driver = intializeDriver();
    }
    public static void openUrl()  throws RuntimeException {
        driver.get  ("https://www.amazon.in/");
}
      public static void item()   {
           driver.findElement(By.xpath( searchbar )).sendKeys(element) ;

        driver.findElement(By.xpath( itemsearch  )).click();
        driver.findElement(By.xpath(boat)).click();
    }
    public static void itemincart(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath(cart)).click();


    }
    public static void removeitem() {
        driver.findElement(By.xpath(gotocart)).click();
        driver.findElement(By.xpath(deleteitem)).click();
        String actual = "Shopping Cart";
        String expected = driver.findElement(By.xpath(emptycart)).getText();
        Assert.assertEquals(actual, expected );
    }
}