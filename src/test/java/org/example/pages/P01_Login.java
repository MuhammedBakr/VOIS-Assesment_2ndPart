package org.example.pages;

import org.openqa.selenium.By;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P01_Login {
    //Elements
    private final By BackToMainPage = By.cssSelector("*[class='link']");
    private final By language = By.cssSelector("div button[class='language']");
    private final By AcceptCookies = By.cssSelector("div button[id='onetrust-accept-btn-handler']");
    private final By SelectProduct = By.cssSelector("*[class='product']");
    private final By AddToCart = By.cssSelector("*[class='add-to-cart']");
    private final By mobileNUM = By.cssSelector("*[name='username']");
    private final By Pass = By.cssSelector("*[id='password']");
    private final By Acc = By.cssSelector("*[name='login']");
    private final By clickLogo = By.cssSelector("*[class='logo-text']");
    private final By searchBar = By.id("searchInput");

    // Actions
    public WebElement cookies() {
        return Hooks.driver.findElement(AcceptCookies);
    }

    public WebElement backMainPage() {
        return Hooks.driver.findElement(BackToMainPage);
    }

    public WebElement change() {
        return Hooks.driver.findElement(language);
    }

    public void selectItem() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        for (int i = 0; i < 8; i++) { // Adjust the number of times to scroll as needed
            js.executeScript("window.scrollBy(0, 1000);");
            try {
                Thread.sleep(1000); // Adding a small delay between scrolls
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> products = Hooks.driver.findElements(SelectProduct);
        WebElement product = products.get(0);
        product.click();
    }

    public WebElement Cart() {
        return Hooks.driver.findElement(AddToCart);
    }

    public WebElement username() {
        return Hooks.driver.findElement(mobileNUM);
    }

    public WebElement password() {
        return Hooks.driver.findElement(Pass);
    }

    public WebElement clickLogin() {
        return Hooks.driver.findElement(Acc);
    }

    public WebElement backToMP() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return Hooks.driver.findElement(clickLogo);
    }

    public void anotherItem() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        for (int i = 0; i < 8; i++) { // Adjust the number of times to scroll as needed
            js.executeScript("window.scrollBy(0, 1000);");
            try {
                Thread.sleep(1000); // Adding a small delay between scrolls
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> products = Hooks.driver.findElements(SelectProduct);
        WebElement product = products.get(1);
        product.click();
    }

    public void search() {
        Hooks.driver.findElement(searchBar).sendKeys("iphone");
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Hooks.driver.findElements(By.cssSelector("*[class='product-result']")).get(1))).click();
    }

}

