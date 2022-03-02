package com.solvd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Chap3Orange {

    WebDriver driver;

    @BeforeMethod
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("1. Open chrome & Application");

    }

    @Test
    public void signIn() {
        WebElement textUsername = driver.findElement(By.id("username"));
        textUsername.click();
        // Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.id("txtPassword"));
        textPassword.click();
        // Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
        // Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    @Test
    public void userSearch() {
        WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        // Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
        // Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        // Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("3. Search For User");
    }

    @Test
    public void userSignOut() {
        WebElement linkWelcome = driver.findElement(By.id("welcome"));
        // Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver
                .findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        // Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("4. Sign Out");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("5. Close Chrome & Application");
        driver.quit();
    }
}
