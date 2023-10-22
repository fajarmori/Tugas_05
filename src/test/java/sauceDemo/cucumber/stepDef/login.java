package sauceDemo.cucumber.stepDef;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String  baseUrl = "https://www.saucedemo.com/";

    @Given("login page sauce demo")
    public void login_page_sauce_demo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("input valid username")
    public void input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input valid password")
    public void input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in on home page")
    public void user_in_on_home_page() {
        String homePageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(homePageAssert,"Products");
    }

    @And("input invalid password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("password123");
    }

    @Then("user get error message")
    public void user_get_error_message() {
        String errorMessageLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorMessageLogin,"Epic sadface: Username and password do not match any user in this service");
    }
}
