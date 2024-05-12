package ru.myhrlink.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LoginPage {

    private WebDriver webdriver;
    public LoginPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By loginField = xpath(".//input[@data-qa='credential-form-login-input']");

    private static final By passwordField = xpath(".//input[@data-qa='credential-form-password-input']");

    private static final By loginButton = xpath(".//button[@data-qa='credential-form-submit-button']");

    public void loginUser(String email, String password) {
        webdriver.findElement(loginField).sendKeys(email);
        webdriver.findElement(passwordField).sendKeys(password);
        webdriver.findElement(loginButton).click();
    }

}
