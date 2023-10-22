package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkOut {
    WebDriver driver;
    String  baseUrl = "https://www.saucedemo.com/";

    @Given("user in cart page")
    public void user_in_cart_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @When("click checkout button")
    public void click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("user in on checkout page")
    public void user_in_on_checkout_page() {
        String homePageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(homePageAssert,"Checkout: Your Information");
    }
}
