package automation_selenium;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class SeleniumPractice2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement addElementBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));

        int i = 0;
        while (i < 10){
            addElementBtn.click();
            Thread.sleep(500);
            i++;
        }

        List<WebElement> deleteBtns = driver.findElements(By.className("added-manually"));
        System.out.println(deleteBtns.size());


        int j = 0;
        while (j < 10){
            WebElement deleteBtn = driver.findElement(By.className("added-manually"));
            deleteBtn.click();
            Thread.sleep(500);
            j++;
        }


        try {
            WebElement deleteBtn = driver.findElement(By.className("added-manually"));
        }catch (Exception e){
            System.out.println("Element does not exist");
        }


        Thread.sleep(2000);
        driver.quit();



    }

}



