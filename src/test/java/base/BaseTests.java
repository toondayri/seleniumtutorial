package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().setSize(new Dimension(375,812));


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());


        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement menuElementLink =  driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElementLink.click();


        List<WebElement> shiftingMenu = driver.findElements(By.cssSelector("div ul li"));
        System.out.println(shiftingMenu.size());



        //WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();

        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();

    }
}