package seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.concurrent.TimeUnit;

public class checkDateType {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl;
//    DateFormat dateFormat;



    By closeModalWindow = By.xpath(".//a[@class = 'at-cv-button at-cv-lightbox-yesno at-cm-no-button']");
    By dataPickersDropDow = By.xpath(".//a[contains(text(),\"Date pickers\")]");
    By getBootStrapDatePicker = By.xpath(".//a[@href='./bootstrap-date-picker-demo.html']");
    By selectDateButton = By.xpath(".//span[@class = \"input-group-addon\"]//i[@class=\"glyphicon glyphicon-th\"]");
    By selectTodayDay = By.xpath(".//th[@class=\"today\"]");
    By checkTheCurrentData = By.xpath(".//div[@class=\"input-group date\"]");



    @BeforeTest
    public void dateTypeMethod()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait =  new WebDriverWait(driver, 5);
        baseUrl = "https://www.seleniumeasy.com/test/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = new Date();
//        String findCurrentDate = dateFormat.format(date);
    }

    @Test
    public void checkTheCorrectDateType(){
        driver.findElement(closeModalWindow).click();
        driver.findElement(dataPickersDropDow).click();
        driver.findElement(getBootStrapDatePicker).click();
        driver.findElement(selectDateButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateButton)).click();
        driver.findElement(selectTodayDay).click();
        WebElement selectedDateDay = driver.findElement(checkTheCurrentData);
        String currentDate = selectedDateDay.getText();
        Assert.assertEquals(currentDate,"10/11/2020");



    }
    @AfterTest
    public void closeTest(){
        driver.quit();
    }

}