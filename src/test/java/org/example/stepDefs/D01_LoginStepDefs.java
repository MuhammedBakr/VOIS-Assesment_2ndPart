package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Login;

import java.time.Duration;

public class D01_LoginStepDefs {
    P01_Login login = new P01_Login();

    @When("user go to shop page then go back to main page")
    public void userGoToShopPageThenGoBackToMainPage() {
        login.cookies().click();
        login.backMainPage().click();
        login.change().click();
    }

    @And("select product to add to cart")
    public void selectProductToAddToCart() {
        login.selectItem();
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.Cart().click();
    }

    @And("go to login page and login successfully with MobileNum {string} and Password {string}")
    public void goToLoginPageAndLoginSuccessfullyWithMobileNumAndPassword(String arg0, String arg1) {
        login.username().sendKeys(arg0);
        login.password().sendKeys(arg1);
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.clickLogin().click();
    }

    @And("select another product to add them to cart")
    public void selectAnotherProductToAddThemToCart() {
        login.backToMP().click();
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.anotherItem();
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.Cart().click();
        login.backToMP().click();
    }


    @Then("another product from search bar")
    public void anotherProductFromSearchBar() {
        login.search();
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.Cart().click();

    }


}
