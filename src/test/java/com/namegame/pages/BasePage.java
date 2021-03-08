package com.namegame.pages;

import com.namegame.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
        //make a connection between driver and web element
    }

    @FindBy(linkText = "name game")
    public WebElement nameGameAttribute ;

    @FindBy(className = "text-center")
    public WebElement whoIsNameAttribute ;

    @FindBy(id = "gallery")
    public WebElement fivePicturesAttribute ;

    @FindBy(className = "text-center")
    public WebElement counterAttribute ;


















}
