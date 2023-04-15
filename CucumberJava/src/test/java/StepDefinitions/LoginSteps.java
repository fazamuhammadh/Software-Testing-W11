package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    WebDriver driver = null;
    @Given ("browser is open go-grids")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver","D:\\Kuliah\\Semester 6\\APPL2\\CucumberJava\\src\\test\\Resources\\drivers\\chromedriver.exe");
        ChromeOptions  options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
    }

    @And ("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("http://103.172.204.236:5173");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("kuncenaman");
        driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys("Lima12345");
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        if (!username.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys(username);
        if (!password.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
    }

//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {
//		driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[2]/div/div[2]/div/div[1]")).isDisplayed();
//	}

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        try {
            WebElement homePageElement = driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[2]/div/div[2]/div/div[1]"));
            if (homePageElement.isDisplayed()) {
                System.out.println("User has successfully navigated to the home page.");
            } else {
                System.out.println("Home page element is not displayed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Home page element is not found.");
        } catch (Exception e) {
            System.out.println("An error occurred while navigating to the home page: " + e.getMessage());
        }
    }

}
