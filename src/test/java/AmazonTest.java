import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Opens Chrome browser
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        // Open Amazon India
        driver.get("https://www.amazon.in");
    }

    @Test
    public void searchKindle() {
        // Find search box and type Kindle
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Kindle");

        // Click search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Verify page title contains Kindle
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        Assert.assertTrue(title.contains("Kindle"), "Title does not contain Kindle!");
    }

    @AfterMethod
    public void teardown() {
        // Close browser after test
        driver.quit();
    }
}