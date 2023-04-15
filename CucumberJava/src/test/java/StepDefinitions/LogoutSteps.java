package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
    WebDriver driver;

    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver","D:\\Kuliah\\Semester 6\\APPL2\\CucumberJava\\src\\test\\Resources\\drivers\\chromedriver.exe");
        ChromeOptions  options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public void user_is_on_login_page() {
        driver.navigate().to("http://103.172.204.236:5173");
    }

    public void user_enters_username_and_password() {
        driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("aziztaufiq");
        driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys("1234567890Aziz");
    }

    public void user_enters_username_and_password(String username, String password) {
        if (!username.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys(username);
        if (!password.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys(password);
    }

    public void clicks_on_login_button() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
    }

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



    @Given("user is login on page")
    public void user_is_logged_on_page() {
        this.browser_is_open();
        this.user_is_on_login_page();
        this.user_enters_username_and_password();
        this.clicks_on_login_button();
        this.user_is_navigated_to_the_home_page();
    }

    @When("user click profile")
    public void user_clicks_on_profile_icon() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div")).click();
    }

    @And ("click on logout icon")
    public void user_clicks_on_logout_icon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"v-list-item-title button-Logout\"]"))).click();
    }
    @Then("user is navigated to the login page")
    public void user_is_navigated_to_the_login_page() {
        WebElement loginPageElement = driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[1]/div/form/h2"));
        driver.quit();
    }
}

