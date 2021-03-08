package com.namegame.step_definitions;

import com.namegame.pages.BasePage;
import com.namegame.pages.HomePage;
import com.namegame.utils.BrowserUtils;
import com.namegame.utils.ConfigurationReader;
import com.namegame.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage_StepDefinitions {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @Then("verify title is present")
    public void verify_title_is_present() {
        WebElement title = Driver.getDriver().findElement(By.cssSelector("h1")) ;
        Assert.assertTrue(title.getText().equals("name game"));
    }

    @Then("verify clicking first picture increases tries counter")
    public void verify_clicking_first_picture_increases_tries_counter(){
        int count = Integer.parseInt(Driver.getDriver().findElement(By.className("attempts")).getText());

        Driver.getDriver().findElement(By.className("photo")).click();
        BrowserUtils.waitForClickability(By.className("photo"), 10);

        int countAfter = Integer.parseInt(Driver.getDriver().findElement(By.className("attempts")).getText());

        Assert.assertTrue(countAfter > count);
    }

    @Then("verify {string} counter is incrementing on correct selections")
    public void verify_counter_is_incrementing_on_correct_selections(String string) {
        int originalStreakCount = Integer.parseInt(Driver.getDriver().findElement(By.className("streak")).getText());

        BrowserUtils.pickCorrectOrIncorrectPhoto("correct");
        BrowserUtils.waitForClickability(By.className("correct"), 10);

        int newStreakCount = Integer.parseInt(Driver.getDriver().findElement(By.className("streak")).getText());
        Assert.assertTrue(newStreakCount > originalStreakCount);
    }

    @Then("verify the multiple {string} counter resets after getting an incorrect answer")
    public void verify_the_multiple_counter_resets_after_getting_an_incorrect_answer(String string) {
        int preActionStreakCount = Integer.parseInt(Driver.getDriver().findElement(By.className("streak")).getText());

        BrowserUtils.pickCorrectOrIncorrectPhoto("incorrect");
        BrowserUtils.waitForClickability(By.className("streak"), 10);

        int postActionStreakCount = Integer.parseInt(Driver.getDriver().findElement(By.className("streak")).getText());
        try {
            Assert.assertTrue(postActionStreakCount > preActionStreakCount);
            preActionStreakCount = postActionStreakCount;
        } catch(AssertionError e) {
            System.out.println("First streak counter increment test FAILED");
            throw e;
        }

        BrowserUtils.pickCorrectOrIncorrectPhoto("incorrect");
        BrowserUtils.waitForClickability(By.className("incorrect"), 10);

        // Check counter reset on incorrect selection
        postActionStreakCount = Integer.parseInt(Driver.getDriver().findElement(By.className("streak")).getText());

        try {
            Assert.assertEquals(postActionStreakCount, 0);
        } catch(AssertionError e) {
            System.out.println("Streak counter reset test FAILED");
            throw e;
        }
    }

    @Then("Verify name and displayed photos change after selecting the correct answer")
    public void verify_name_and_displayed_photos_change_after_selecting_the_correct_answer() throws InterruptedException {
        List<WebElement> originalPhotos = Driver.getDriver().findElements(By.className("photo"));
        String originalMatchName = Driver.getDriver().findElement(By.id("name")).getText();

        BrowserUtils.pickCorrectOrIncorrectPhoto("correct");
        Thread.sleep(9000);

        List<WebElement> newPhotos = Driver.getDriver().findElements(By.className("photo"));
        String newMatchName = Driver.getDriver().findElement(By.id("name")).getText();

        Assert.assertNotEquals(originalMatchName,newMatchName);
        Assert.assertNotSame(originalPhotos,newPhotos);








    }













}