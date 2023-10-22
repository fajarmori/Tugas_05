package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class cartPage {
    WebDriver driver;
    String  baseUrl = "https://www.saucedemo.com/";

    @Given("user login")
    public void user_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("click icon cart")
    public void click_icon_cart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("user in on cart page")
    public void user_in_on_cart_page() {
        String homePageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(homePageAssert,"Your Cart");
    }
}
