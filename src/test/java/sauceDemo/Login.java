package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
//    @Test //Tag untuk running script dibawah ini
//    public void open_browser() {
//        WebDriver driver;
//        String baseUrl = "https://www.saucedemo.com/";
//
//        WebDriverManager.chromedriver().setup();
//
//        //apply chrome driver setup
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(baseUrl);
//
//        driver.close();
//    }

    @Test //Tag untuk running script dibawah ini
    public void get_title() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        //Get form
        WebElement element001 = driver.findElement(By.id("user-name"));
        WebElement element002 = driver.findElement(By.id("password"));
        WebElement element003 = driver.findElement(By.id("login-button"));

        element001.click();
        element001.sendKeys("standard_user");
        element001.getText();

        element002.click();
        element002.sendKeys("secret_sauce");
        element002.getText();

        element003.isDisplayed();
        element003.click();

        //driver.findElement(By.xpath("/*contains")).isDisplayed();
        //driver.findElement(By.cssSelector("#login-button")).isDisplayed();

    }
}
