package automation_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumPractice1 {

    public static void main(String[] args) throws InterruptedException {

        /*
    Complete this group project using some of the WebDriver
    methods you have learned:

    1. Launch the browser
    2. Navigate to Website 1
    3. Maximize the window
    4. Wait for 1 second
    5. Grab the title of the page and save it to a list
    6. Navigate to Website 2
    7. Minimize the window
    8. Wait for 1 second
    9. Grab the title of the page and save it a list
    10. Navigate to Website 3
    11. Maximize the window
    12. Wait for 1 second
    13. Grab the title of the page and save it to the list
    14. Go back
    15. Wait for 1 second
    16. Go back
    17. Wait for 1 second
    18. Go back
    19. Wait for 1 second
    20. Go forward
    21. Wait for 1 second
    22. Go forward
    23. Wait for 1 second
    24. Go forward
    25. Wait for 1 second
    26. Minimize the window
    27. Close the browser

 */
        List<String> list = new ArrayList<>();


        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.manage().window().maximize();
        Thread.sleep(1000);

        String pageTitle = driver.getTitle();
        list.add(pageTitle);

        driver.get("https://amazon.com");

        driver.manage().window().minimize();
        Thread.sleep(1000);

        String pageTitle2 = driver.getTitle();
        list.add(pageTitle2);

        driver.get("https://netflix.com");

        driver.manage().window().maximize();
        Thread.sleep(1000);

        String pageTitle3 = driver.getTitle();
        list.add(pageTitle3);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.manage().window().minimize();

        driver.quit();

        System.out.println(list);

    }
}
