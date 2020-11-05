package seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputForm {
    WebDriver driver;
    WebDriverWait wait;


    By inputFormOptionBy = By.xpath("//a[text()='Input Forms']");
    By waitSimpleFormDemo= By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By userMessageBy = By.xpath("//input[@id='user-message']");
    By showButtonBy = By.xpath("//button[text()='Show Message']");
    By actualResualtBy = By.xpath("//span[@id='display']");



    @Before
    public void beforeEachTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='No, thanks!']"))).click();



    }

    @Test
    public void test_1(){
        String userMes = "Hello, my name is Osana";
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSimpleFormDemo)).click();
        WebElement userMessage = driver.findElement(userMessageBy);
        userMessage.sendKeys(userMes);
        WebElement showButton = driver.findElement(showButtonBy);
        showButton.click();
        String actualResualt = driver.findElement(actualResualtBy).getText();
        Assert.assertEquals(userMes,actualResualt);


    }
    @After
    public void afterEachTest(){
        driver.quit();
    }

}
