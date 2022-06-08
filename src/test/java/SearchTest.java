

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SearchTest {

    @Test
    public void search() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.sendKeys("xcale");

        driver.findElement(By.name("btnK")).click();

        String result = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div[1]/a/h3")).getText();

        Assertions.assertEquals("Xcale Consulting: Inicio", result);
        Assertions.assertEquals(result.contains("Xcale"), true);

        driver.quit();

    }
}