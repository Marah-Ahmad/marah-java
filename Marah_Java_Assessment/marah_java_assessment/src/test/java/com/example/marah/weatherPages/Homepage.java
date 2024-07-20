package com.example.marah.weatherPages;

import com.example.marah.Core.AndroidBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage extends AndroidBase {

    public WebElement tempretureUnit, timeFormat;

    public Homepage() {
        tempretureUnit = driver.findElement(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_current_temper_unit\"]"));
        timeFormat = driver.findElement(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_date\"]"));
    }

    public List<WebElement> getTimesList() {
        return driver.findElements(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_hour_item\"]"));
    }

    public List<WebElement> getRainingList() {
        return driver.findElements(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_rain_chance\"]"));
    }

    public List<WebElement> getHumidityList() {
        return driver.findElements(By.xpath("//*[@resource-id=\"com.info.weather.forecast:id/tv_humidity\"]"));
    }
}
