package automation_selenium;

import com.github.javafaker.*;
import com.github.javafaker.Number;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomationPrectice2 {

    public static void main(String[] args) throws InterruptedException {

//        1.Navigate to http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx
//        2. Verify the title of the page
//        3. Enter credentials: Tester | test
//        4. Verify the login button is enabled
//        5. Once you log in, verify the title of the page as well as
//        Welcome, Tester! Message on top right
//        Also verify logout link is displayed on top right
//        6. Verify the 'Web Orders' logo is displayed on top left
//        7. Click on 'Order' link on top left menu
//        8. Verify 'Product Information' header is displayed
//        Select a random product from the Product dropdown
//        Enter a random quantity between 1 and 10
//        Verify the 'Calculate' button is enabled and click it
//        9. Verify 'Address Information' header is displayed
//        10. Enter random customer name, street, city, state and zip.
//        11. Verify Payment Information header is displayed
//        12. Randomly click between Visa, MasterCard and American Express
//        Hint: Find Visa, MasterCard and AE input boxes
//        e.g ctl00_MainContent_fmwOrder_cardList_0
//        ctl00_MainContent_fmwOrder_cardList_1
//                ctl00_MainContent_fmwOrder_cardList_2
//        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+randomNumber))
//
//        13. Enter Card Number which should be 16 digits
//        14. Also enter random date which should be in this format:
//        Mm/yy
//        15. Verify 'Process' and 'Reset'button are enabled
//        16. Click on Process button
//        17. Verify 'New order has been successfully added.' Text message is displayed under the process button
//        18. Click on View all orders link on the left menu
//        19. Verify the new order has been added to the orders table. (This step is optional. It would be great if you can figure this out. Use Google to research your problems)
//        20. Click on Logout button
//        21. Quit the browser.


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        String loginPageTitle = driver.getTitle();

        String correctTitle = "Web Orders Login";

        if (loginPageTitle.equals(correctTitle)){
            System.out.println("Title verified");
        }else{
            System.out.println("Title not verified");
        }

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));

        username.sendKeys("Tester");
        password.sendKeys("test");

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        boolean isLoginButtonEnabled = loginButton.isEnabled();

        if (isLoginButtonEnabled){
            System.out.println("Login button is enabled");
            loginButton.click();
        }else{
            System.out.println("Login button is not enabled");
        }

        Thread.sleep(3000);

        String mainPageTitle = driver.getTitle();

        String correctMainTitle = "Web Orders";

        if (mainPageTitle.equals(correctMainTitle)){
            System.out.println("Title verified");
        }else{
            System.out.println("Title not verified");
        }

        WebElement welcomeMessage = driver.findElement(By.className("login_info"));

        String text = welcomeMessage.getText();

        System.out.println(text);

        String correctWelcomeMessage = "Welcome, Tester! | Logout";

        if (text.equals(correctWelcomeMessage)){
            System.out.println("Welcome message verified");
        }else{
            System.out.println("Welcome message not verified");
        }

        WebElement logOutLink = driver.findElement(By.id("ctl00_logout"));

        String logOutText = logOutLink.getText();

        System.out.println(logOutText);

        WebElement webOrdersLogo = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[1]/h1"));

        boolean isLogoDisplayed = webOrdersLogo.isDisplayed();

        if (isLogoDisplayed){
            System.out.println("Web Orders Logo is displayed");
        }else{
            System.out.println("Web Orders Logo is not displayed");
        }

        WebElement orderLink = driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a"));

        orderLink.click();

        WebElement productInfoText = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/h3[1]"));

        boolean isProductInfoDisplayed = productInfoText.isDisplayed();

        if (isProductInfoDisplayed){
            System.out.println("Product Information is displayed");
        }else {
            System.out.println("Product Information is not displayed");
        }

        WebElement filterDropDown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select filterSelect = new Select(filterDropDown);

        filterSelect.selectByValue("FamilyAlbum");

        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

       // int randomQuantity = (int)(Math.random() * 10) + 1;
        int randomQuantity = CommonUtils.generateRandomNumber(1, 10);
        quantity.sendKeys(randomQuantity +"");

        WebElement calculateButton = driver.findElement(By.className("btn_dark"));

        boolean isCalculateButtonEnabled = calculateButton.isEnabled();

        if (isCalculateButtonEnabled){
            System.out.println("Calculate Button is enabled");
            calculateButton.click();
        }else{
            System.out.println("Calculate Button doesn't work");
        }

        WebElement addressInfo = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/h3[2]"));

        boolean isAddressInfoDisplayed = addressInfo.isDisplayed();

        if (isAddressInfoDisplayed){
            System.out.println("Address Information is displayed");
        }else{
            System.out.println("Address Information is not displayed");
        }

        Faker faker = new Faker();

        Name name = faker.name();

        String fullName = name.fullName();

        Address address = faker.address();

        String street = address.streetAddress();

        String city = address.city();

        String state = address.state();

        String zipCode = address.zipCode();

        Business business = faker.business();

        String cardNumber = business.creditCardNumber();

        String cardNumberCorrected = cardNumber.replace("-", "");


        WebElement enterName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));

        enterName.sendKeys(fullName);

        WebElement enterStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));

        enterStreet.sendKeys(street);

        WebElement enterCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));

        enterCity.sendKeys(city);

        WebElement enterState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));

        enterState.sendKeys(state);

        WebElement enterZipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        enterZipCode.sendKeys(zipCode.substring(0, 5));

        WebElement paymentInfo = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/h3[3]"));

        boolean isPaymentInfoDisplayed = paymentInfo.isDisplayed();

        if (isPaymentInfoDisplayed){
            System.out.println("Payment Information is displayed");
        }else{
            System.out.println("Payment Information is not displayed");
        }

        int randomIndex = CommonUtils.generateRandomNumber(0, 2);

        WebElement visaMasterCardAmex = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + randomIndex));
        visaMasterCardAmex.click();

        WebElement enterCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));

        enterCardNumber.sendKeys(CommonUtils.generateRandomCardNumber(randomIndex));

        WebElement date = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));

        String randomDateInMMYY = CommonUtils.getRandomDateInMMYY(7);
        date.sendKeys(randomDateInMMYY);

        WebElement resetButton = driver.findElement(By.className("btn_dark"));

        boolean isResetButtonEnabled = resetButton.isEnabled();

        if (isResetButtonEnabled){
            System.out.println("Reset Button is enabled");
        }else{
            System.out.println("Reset Button doesn't work");
        }

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));

        boolean isProcessButtonEnabled = processButton.isEnabled();

        if (isProcessButtonEnabled){
            System.out.println("Process Button is enabled");
            processButton.click();
        }else{
            System.out.println("Process Button doesn't work");
        }

        WebElement newOrderAddedMessage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));

        boolean isNewOrderAddedMessageDisplayed = newOrderAddedMessage.isDisplayed();

        if (isNewOrderAddedMessageDisplayed){
            System.out.println("New order has been successfully added is displayed");
        }else{
            System.out.println("New order has been successfully added is not displayed");
        }

        Thread.sleep(3000);

        WebElement viewAllOrders = driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a"));

        viewAllOrders.click();

        Thread.sleep(3000);

        WebElement logOut = driver.findElement(By.id("ctl00_logout"));

        logOut.click();

        driver.quit();



    }
}

