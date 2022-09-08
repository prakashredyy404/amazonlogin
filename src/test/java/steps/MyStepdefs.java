package steps;

import drivers.actions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;


public class MyStepdefs extends actions {
    @Before
    public void userOpensUrls(){
        openUrl();
    }
    @Given("user opens url")
    public void userOpensUrl()  throws RuntimeException {
        openUrl();
    }

    @When("user searches for item")
    public void userSearchesForItem() {
        item();
    }

    @And("user add item into cart")
    public void userAddItemIntoCart() {
        itemincart();

    }

    @Then("remove added item from cart")
    public void removeAddedItemFromCart() throws InterruptedException {
        removeitem();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String productname) {
        driver.findElement(By.xpath(searchbar)).sendKeys( productname  );
        driver.findElement(By.xpath( itemsearch  )).click();


    }

    @Then("add items detail into excel")
    public void addItemsDetailIntoExcel() throws InterruptedException, IOException {
        List<WebElement> rows = driver.findElements(By.xpath("//h2/a/span[starts-with( .,'Apple iPhone 13')]"));

        System.out.println(rows.size());
        File plates = new File( "E:\\Book1.xlsx");
        FileInputStream plate = new FileInputStream(plates);
        XSSFWorkbook workbook = new XSSFWorkbook(plate);
        Sheet sheet = workbook.getSheetAt(0);
//        Row newRow = sheet.createRow(rows.size() + 1);
        for (int i = 0; i < rows.size(); i++) {
            Row row = sheet.createRow(i);
            String vaLUE = rows.get(i).getText();
            System.out.println(vaLUE);
//            Cell plateNumber;
//            plateNumber = sheet.getRow(i).getCell(0) ;
//            Cell url = sheet.getRow(i).getCell(1);
             sheet.getRow(i).createCell(0).setCellValue(vaLUE);
            FileOutputStream outputStream = new FileOutputStream("E:\\Book1.xlsx");
            workbook.write(outputStream);
//            workbook.close();
        }
       // plate.close();
        workbook.close();
      //  FileOutputStream outputStream = new FileOutputStream("E:\\Book1.xlsx");
       //Workbook.w
    }}
//    //@After
//    //public void teardown(){
//        driver.quit();
//    }

//    public static void addData(int rowNum, String query, String queryDetails, String url, String lookupID) throws IOException {
//        File plates = new File(DATA_XLSX_PATH);
//        FileInputStream plate = new FileInputStream(plates);
//        XSSFWorkbook workbook = new XSSFWorkbook(plate);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        Row row = sheet.createRow(rowNum);
//        sheet.getRow(rowNum).createCell(0).setCellValue(query);
//        sheet.getRow(rowNum).createCell(1).setCellValue(queryDetails);
//        sheet.getRow(rowNum).createCell(2).setCellValue(url);
//        sheet.getRow(rowNum).createCell(3).setCellValue(lookupID);
//        FileOutputStream out = new FileOutputStream(plates);
//        workbook.write(out);
//        workbook.close();
//    }