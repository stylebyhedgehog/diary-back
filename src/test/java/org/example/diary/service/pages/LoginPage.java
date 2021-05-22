package org.example.diary.service.pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage  {

    private   WebDriver driver;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+'\\'+"chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void setMyProject(){
        this.driver.get("http://localhost:8081/login");
    }
    public void enterLogin(String login){
        this.driver.findElement(By.name("username")).sendKeys(login);
    }
    public void enterPassword(String password){
        this.driver.findElement(By.name("password")).sendKeys(password);
    }
    public void clickBtn(){
        this.driver.findElement(By.id("auth")).click();
    }
    public void check() {
        Assert.assertEquals(this.driver.getCurrentUrl(),"http://localhost:8081/profile");
    }
}
