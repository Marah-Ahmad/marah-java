Marah Assessment Q-Pros

Prerequisites:
I used Testng (maven) in Java using Appium UIAutomator2 for Native Andorid app (Weather App)
make sure you have Android Studio - appium server - Java - Node - Maven are installed
and Env Variables JAVA_HOME (version: 17) and ANDROID_HOME are set propeply and maven is in your PATH env

note: you can use appium-doctor to check everything is set up correctly.

Setting Up:

- Clone the repository
- Install dependencies:

```
mvn clean install
```

- inside test/java/com.example.marah/Core/BaseClass set the capability "appium:deviceName" to your emulator/device name
- run appium server on port : 4723 or modify it in BaseClass to your port

- Run Tests: you can run tests using :

```
mvn test
```

Generated Report can be found in ./Reports/Android/index.html

the apk for the weather app is located under src/test/java/com.example.marah/apps/Weather.apk

test cases can be found in  src/test/java/com.example.marah/testcases

the Pages and locators (Because i Used POM) are located in src/test/java/com.example.marah/weatherPages
