package org.example.diary.service;

import org.example.diary.SpringSecurityJwtApplication;
import org.example.diary.service.pages.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.function.Function;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSecurityJwtApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UITest {

        @Test
        public void SignIn1() throws InterruptedException {
            LoginPage loginPage=new LoginPage();
            loginPage.setMyProject();
            loginPage.enterLogin("single");
            loginPage.enterPassword("single");
            loginPage.clickBtn();
            Thread.sleep(900);
            loginPage.check();
        }



}