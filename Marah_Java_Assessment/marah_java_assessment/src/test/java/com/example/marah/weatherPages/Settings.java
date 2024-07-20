package com.example.marah.weatherPages;

import com.example.marah.Core.AndroidBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Settings extends AndroidBase {
    public WebElement tempretureDropdown, celicius, timeDropdown,timeFormat, doneButton;

    public Settings() {
        tempretureDropdown = driver.findElement(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/iv_temp_dropdown\"]"));
        doneButton = driver.findElement((By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_button_done\"]")));
        timeDropdown = driver.findElement(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/iv_timeformat_dropdown\"]"));
    }

    public void selectCelicius() {
        celicius = driver.findElement(By.xpath("//android.widget.TextView[@text=\"C\"]"));
        celicius.click();
    }

    public void select24Format() {
        timeFormat = driver.findElement(By.xpath("//android.widget.TextView[@text=\"24 Hour\"]"));
        timeFormat.click();
    }

}
