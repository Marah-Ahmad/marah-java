package com.example.marah.testcases;

import com.example.marah.Core.AndroidBase;
import com.example.marah.weatherPages.Homepage;
import com.example.marah.weatherPages.PrivacyPolicy;
import com.example.marah.weatherPages.Settings;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;


public class WeatherTests extends AndroidBase {

    @Test
    public void TC_1(){
        Settings settingsPage = new Settings();
        settingsPage.tempretureDropdown.click();
        settingsPage.selectCelicius();
        settingsPage.doneButton.click();

        PrivacyPolicy policyPage = new PrivacyPolicy();
        policyPage.gotItButton.click();

        Homepage homepage = new Homepage();
        String tempUnit = homepage.tempretureUnit.getText();

        Assert.assertEquals(tempUnit, "°C");
    }

    @Test
    public void TC_2(){
        Settings settingsPage = new Settings();
        settingsPage.timeDropdown.click();
        settingsPage.select24Format();
        settingsPage.doneButton.click();
        PrivacyPolicy policyPage = new PrivacyPolicy();
        policyPage.gotItButton.click();

        Homepage homepage = new Homepage();
        Pattern regex = Pattern.compile("^([0-1][0-9]|2[0-3]):([0-5][0-9])$");

        String text = homepage.timeFormat.getText();
        String time = text.split(",")[0];

        Assert.assertTrue(regex.matcher(time).matches());

        for(WebElement oneTime : homepage.getTimesList())
        {
            String timeText = oneTime.getText();
            Assert.assertTrue(regex.matcher(timeText).matches());

        }
    }

    @Test
    public void TC_3()
    {
        Settings settingsPage = new Settings();
        settingsPage.timeDropdown.click();
        settingsPage.select24Format();
        settingsPage.doneButton.click();
        PrivacyPolicy policyPage = new PrivacyPolicy();
        policyPage.gotItButton.click();

        Homepage homepage = new Homepage();
        List<WebElement> rainNumbers = homepage.getRainingList();
        List<WebElement> humidityNumbers = homepage.getHumidityList();

        for (int i=0; i<5; i++)
        {
            Assert.assertTrue(rainNumbers.get(i).isDisplayed());
            Assert.assertTrue(humidityNumbers.get(i).isDisplayed());
        }

    }
}
