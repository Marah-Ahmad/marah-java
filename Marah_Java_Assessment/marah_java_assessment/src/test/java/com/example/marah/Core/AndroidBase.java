package com.example.marah.Core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AndroidBase extends BaseClass {

    static ExtentReports extent;
    static ExtentSparkReporter spark;


    @BeforeTest
    public void reportTest() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\Android");
        extent.attachReporter(spark);


    }


    @AfterTest
    public void reportFlush() {
        extent.flush();
    }


    @BeforeMethod
    public void Setup() {
        AndroidSetup();
    }


    @AfterMethod
    public void TearDown(ITestResult result) {
        String tc_name = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            extent.createTest(tc_name)
                    .log(Status.FAIL, tc_name + " FAILED!! ");

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extent.createTest(tc_name)
                    .log(Status.PASS, tc_name + " SUCCESS!! ");

        } else if (result.getStatus() == ITestResult.SKIP) {
            extent.createTest(tc_name)
                    .log(Status.SKIP, tc_name + " SKIPPED!! ");
        }

        AndroidTearDown();
    }
}
