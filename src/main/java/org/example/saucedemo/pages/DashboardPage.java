package org.example.saucedemo.pages;


import org.openqa.selenium.WebDriver;


public class DashboardPage {

    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getTitle() {
        return  driver.getTitle();
    }
}
