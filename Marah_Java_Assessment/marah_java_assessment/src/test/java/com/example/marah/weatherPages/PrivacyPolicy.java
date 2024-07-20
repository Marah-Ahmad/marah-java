package com.example.marah.weatherPages;

import com.example.marah.Core.AndroidBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrivacyPolicy extends AndroidBase {
    public WebElement gotItButton;

    public PrivacyPolicy(){
        gotItButton = driver.findElement(By.xpath("//*[@text=\"GOT IT\"]"));
    }
}
