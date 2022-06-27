package org.example.StepDefinition;

import org.example.Pages.HomePage;
import org.example.Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D1_Register {
    RegisterPage register;
    HomePage home;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        register = new RegisterPage(Hooks.driver);
        home = new HomePage(Hooks.driver);
        home.Navigate_to_RegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        register.FemaleGender().click();
}

    @And("user enter valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("christine");

        register.lastName().sendKeys("hany");

        Select select = new Select(register.birthDay());
        select.selectByIndex(17);

        select = new Select(register.birthMonth());
        select.selectByVisibleText("March");

        select = new Select(register.birthYear());
        select.selectByValue("1987");


        register.email().sendKeys("eng.christine.hany@gmail.com");

        register.password().sendKeys("CHri01)$");
        register.confirmPassword().sendKeys("CHri01)$");
    }

    @Then("user press on register button")
    public void user_register_successfully(){
        register.registerB().click();
    }

    @And("user could register successfully")
    public void register_successfully() {
        // 1st Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Success Message");
        // 2nd Assertion
        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "color is correct");
        // Assert All
        soft.assertAll();
    }
}
