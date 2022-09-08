package drivers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class actions extends  createdriver {
    public static WebDriver driver;
    public static ArrayList<String> tabs;




    static {
        driver = intializeDriver();
    }
    WebDriverWait wait = new WebDriverWait(driver, 5000 );

    public static void openUrl()  throws RuntimeException {
        driver.get  ("https://www.amazon .in/");


    }


      public static void item()   {
           driver.findElement(By.xpath( searchbar)).sendKeys(element) ;

        driver.findElement(By.xpath( itemsearch  )).click();
        driver.findElement(By.xpath(boat)).click();


        tabs= new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs);

         driver.switchTo().window(tabs.get(0));
    }

    public void itemincart(){


        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath(cart)).click();


    }
public static void excel(){

}



    public static void removeitem()   throws InterruptedException {
        driver.findElement(By.xpath(gotocart)).click();
        driver.findElement(By.xpath(deleteitem)).click();
//       String expected = driver.findElement(By.xpath(amount)).getText();
//       String actual = " 0.00";
         String actual = "Your Amazon Cart is empty.";
       Thread.sleep(10000);
        String expe  = driver.findElement(By.xpath(emptycart)).getText();
        System.out.println(expe );
      Assert.assertEquals(actual, expe  );



        driver.switchTo().window(tabs.get(0));

    }

}