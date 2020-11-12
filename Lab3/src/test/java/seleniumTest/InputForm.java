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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputForm{;
    WebDriver driver;
    WebDriverWait wait;


    By inputFormOptionBy = By.xpath("//a[text()='Input Forms']");
    By waitSimpleFormDemo= By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By userMessageBy = By.xpath("//input[@id='user-message']");
    By showButtonBy = By.xpath("//button[text()='Show Message']");
    By actualResualtTest_1By = By.xpath("//span[@id='display']");
    By sum1By = By.xpath("//input[@id='sum1']");
    By sum2By = By.xpath("//input[@id='sum2']");
    By getTotalBy = By.xpath("//button[text()='Get Total']");
    By actualResualtTest_2By = By.xpath("//span[@id='displayvalue']");
    By waitCheckboxDemo= By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
    By option_1By = By.xpath("//label[ text()='Option 1']");
    By option_3By = By.xpath("//label[ text()='Option 3']");
    By option = By.xpath("//label[ text()='Option 1' and text()='Option 3']");
    By waitRadioButtonsDemo = By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']");
    By buttonMaleBy = By.xpath("//div//label[@class='radio-inline']//input[@value='Male' and @name='gender']");
    By value_15_50By = By.xpath("//div//label[@class='radio-inline']//input[@value = '15 - 50']");
    By getValueBy = By.xpath("//button[text()='Get values']");
    By male_15_50By = By.xpath("//p[@class='groupradiobutton']");
    By waitSelectDropdownListBy = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    By dropdownBy = By.xpath("//select[@id='select-demo']//option[@value='Friday']");
    By daySelectedBy = By.xpath("//p[text()='Day selected :- Friday']");
    By multiSelectBy = By.xpath("//select[@id='multi-select']");
    By getAllSelectedBy = By.xpath("//button[text()='Get All Selected']");
    By optionSelectedAreBy = By.xpath("//p[text()='Options selected are : Florida,New York']");
    By waitAjaxFormSubmitBy = By.xpath("//li[@class='tree-branch']//a[text()='Ajax Form Submit']");
    By buttonSubmitBy = By.xpath("//input[@id='btn-submit']");
    By colorValueBy = By.xpath("//input[@style='border: 1px solid rgb(255, 0, 0);']");
    By waitDatePickersBy = By.xpath("//li[@class='tree-branch']//a[text()='Date pickers']");
    By bootstrapDatePickerBy = By.xpath("//li[@class='tree-branch']//a[text()='Bootstrap Date Picker']");
    By inputGroupAddonBy = By.xpath("//span[@class='input-group-addon']//i[@class='glyphicon glyphicon-th']");



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
        String actualResualt = driver.findElement(actualResualtTest_1By).getText();
        Assert.assertEquals(userMes,actualResualt);


    }
   @Test
    public void test_2(){
        String sum = "15";
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSimpleFormDemo)).click();
        WebElement value_1 = driver.findElement(sum1By);
        value_1.sendKeys("10");
        WebElement value_2 = driver.findElement(sum2By);
        value_2.sendKeys("5");
        WebElement getTotal = driver.findElement(getTotalBy);
        getTotal.click();
        String actualResualt = driver.findElement(actualResualtTest_2By).getText();
        Assert.assertEquals(sum,actualResualt);

    }
    @Test
    public void test_3(){
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitCheckboxDemo)).click();
        WebElement option_1 = driver.findElement(option_1By);
        option_1.click();
        WebElement option_3 = driver.findElement(option_3By);
        option_3.click();
        Boolean actualResult1 = driver.findElement(option_1By).isSelected();
        Boolean actualResult2 = driver.findElement(option_3By).isSelected();
        Assert.assertTrue(actualResult1==actualResult2);

    }
    @Test
    public void test_4(){

        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitRadioButtonsDemo)).click();
        WebElement buttonMale = driver.findElement(buttonMaleBy);
        buttonMale.click();
        WebElement value_15_50 = driver.findElement(value_15_50By);
        value_15_50.click();
        WebElement getValue = driver.findElement(getValueBy);
        getValue.click();
        String female_5_15 = "Sex : Female" + "Age group: 5 - 15";
        //String Sex = "Sex : Female";
        //String Age = " Age group: 5 - 15";
        String actualResual = driver.findElement(male_15_50By).getText();
        Assert.assertNotEquals(female_5_15,male_15_50By);
    }
    @Test
    public void test_5(){
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelectDropdownListBy)).click();
        //Select dropdown = new Select(driver.findElement(By.xpath("dropdownBy")));
        //dropdown.selectByVisibleText("Friday");
        String daySelect = "Day selected :- Friday";
        WebElement dropdown = driver.findElement(dropdownBy);
        dropdown.click();
        String actualResualt = driver.findElement(daySelectedBy).getText();
        Assert.assertEquals(daySelect,actualResualt);
    }
    @Test
    public void test_6(){
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelectDropdownListBy)).click();
        WebElement multiSelect = driver.findElement(multiSelectBy);
        Select dropdown = new Select(multiSelect);
        dropdown.selectByVisibleText("Florida");
        dropdown.selectByVisibleText("New York");
        WebElement getAllSelected = driver.findElement(getAllSelectedBy);
        getAllSelected.click();
        String optionSelected = "Options selected are : Florida,New York";
        String actualResualt = driver.findElement(optionSelectedAreBy).getText();
        Assert.assertEquals(optionSelected,actualResualt);
    }

    @Test
    public void test_7(){
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitAjaxFormSubmitBy)).click();
        WebElement submitButton = driver.findElement(buttonSubmitBy);
        submitButton.click();
        String expectedColor = "1px solid rgb(255, 0, 0)";
        String actualResualt = driver.findElement(colorValueBy).getCssValue("border");
        Assert.assertEquals(expectedColor,actualResualt);
    }
    @Test
    public void test_8(){
        WebElement datePickers = driver.findElement(waitDatePickersBy);
        datePickers.click();
        WebElement bootstrapDatePicker = driver.findElement(bootstrapDatePickerBy);
        bootstrapDatePicker.click();
        WebElement inputGroupAddon = driver.findElement(inputGroupAddonBy);
        inputGroupAddon.click();
        DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        String expectedResualt = "Sat Nov 07 22:43:19 EET 2020";
        String actualResual = new String(yesterday.toString());
        Assert.assertEquals(expectedResualt,actualResual);


    }
   @After
    public void closeBrowser(){

       // driver.quit();
    }

}
