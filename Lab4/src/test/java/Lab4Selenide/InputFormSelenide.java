package Lab4Selenide;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InputFormSelenide {


    By noThanksButton = By.xpath("//a[text()='No, thanks!']");

    //test_1
    By inputFormOptionBy = By.xpath("//a[text()='Input Forms']");
    By simpleFormDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By userMessageBy = By.xpath("//input[@id='user-message']");
    By showButtonBy = By.xpath("//button[text()='Show Message']");
    By actualResualtTest_1By = By.xpath("//span[@id='display']");

    //test_2
    By sum1By = By.xpath("//input[@id='sum1']");
    By sum2By = By.xpath("//input[@id='sum2']");
    By getTotalBy = By.xpath("//button[text()='Get Total']");
    By actualResualtTest_2By = By.xpath("//span[@id='displayvalue']");

    //test_3
    By checkboxDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
    By option_1By = By.xpath("//label[ text()='Option 1']//input");
    By option_3By = By.xpath("//label[ text()='Option 3']//input");

    //test_4
    By radioButtonsDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']");
    By buttonMaleBy = By.xpath("//div//label[@class='radio-inline']//input[@value='Male' and @name='gender']");
    By value_15_50By = By.xpath("//div//label[@class='radio-inline']//input[@value = '15 - 50']");
    By getValueBy = By.xpath("//button[text()='Get values']");
    By male_15_50By = By.xpath("//p[@class='groupradiobutton']");

    //test_5
    By selectDropdownListBy = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    By dropdownBy = By.xpath("//select[@id='select-demo']");
    By daySelectedBy = By.xpath("//p[text()='Day selected :- Friday']");

    //test_6
    By multiSelectBy = By.xpath("//select[@id='multi-select']");
    By floridaSelecrBy = By.xpath("//select//option[@value=\"Florida\"]");
    By getAllSelectedBy = By.xpath("//button[text()='Get All Selected']");
    By optionSelectedAreBy = By.xpath("//p[text()='Options selected are : Florida']");

    //test_7
    By ajaxFormSubmitBy = By.xpath("//li[@class='tree-branch']//a[text()='Ajax Form Submit']");
    By buttonSubmitBy = By.xpath("//input[@id='btn-submit']");
    By colorValueBy = By.xpath("//input[@style='border: 1px solid rgb(255, 0, 0);']");


    @BeforeClass
    public static void beforeClass() {
        Configuration.baseUrl = "https://www.seleniumeasy.com/";
        Configuration.startMaximized = true;
    }

    @Before
    public void beforeEachTest() {
        open("test");
        try {
            WebDriver webDriver = WebDriverRunner.getWebDriver();
            WebDriverWait wait = new WebDriverWait(webDriver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(noThanksButton)).click();
        } catch (Exception e) {
            System.out.println("Window is not open");
        }
    }

    @Test
    public void test_1() {
        String userMes = "Hello, my name is Osana";
        $(inputFormOptionBy).shouldBe(visible).click();
        $(simpleFormDemoBy).shouldBe(visible).click();
        $(userMessageBy).shouldBe(visible).setValue(userMes);
        $(showButtonBy).shouldBe(visible).click();
        $(actualResualtTest_1By).shouldHave(text(userMes));
    }

    @Test
    public void test_2() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(simpleFormDemoBy).shouldBe(visible).click();
        $(sum1By).shouldBe(visible).setValue("10");
        $(sum2By).shouldBe(visible).setValue("5");
        String sum = "15";
        $(getTotalBy).shouldBe(visible).click();
        $(actualResualtTest_2By).shouldHave(text(sum));
    }

    @Test
    public void test_3() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(checkboxDemoBy).shouldBe(visible).click();
        $(option_1By).shouldBe(visible).setSelected(true);
        $(option_3By).shouldBe(visible).setSelected(true);
        $(option_1By).shouldBe(selected);
        $(option_3By).shouldBe(selected);
    }

    @Test
    public void test_4() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(radioButtonsDemoBy).shouldBe(visible).click();
        $(buttonMaleBy).shouldBe(visible).click();
        $(value_15_50By).shouldBe(visible).click();
        String female_5_15 = "Sex : Female" + "Age group: 5 - 15";
        $(male_15_50By).shouldNotHave(text(female_5_15));
    }

    @Test
    public void test_5() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(selectDropdownListBy).shouldBe(visible).click();
        String daySelect = "Day selected :- Friday";
        $(dropdownBy).shouldBe(visible).selectOption("Friday");
        $(daySelectedBy).shouldHave(text(daySelect));
    }

    @Test
    public void test_6() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(selectDropdownListBy).shouldBe(visible).click();
        $(floridaSelecrBy).shouldBe(visible).click();
        $(getAllSelectedBy).shouldBe(visible).click();
        String optionSelected = "Options selected are : Florida";
        $(optionSelectedAreBy).shouldHave(text(optionSelected));
    }

    @Test
    public void test_7() {
        $(inputFormOptionBy).shouldBe(visible).click();
        $(ajaxFormSubmitBy).shouldBe(visible).click();
        $(buttonSubmitBy).shouldBe(visible).click();
        String expectedColor = "rgb(255, 0, 0)";
        $(colorValueBy).shouldHave(Condition.attributeMatching("outerHTML","expectedColor"));

    }

}
