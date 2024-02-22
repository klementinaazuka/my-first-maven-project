package com.academy.techcenture;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SwagLabsPlaceOrderTest {

    private WebDriver driver;
    private Faker faker;

    //this method will run before each test case i.e @Test
    @BeforeMethod
    public void setUp() {
        faker = new Faker();
        //chrome instance configuration
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)
    public void swagLabsPlaceOrderPositiveTest() throws InterruptedException {

        String loginPageTitle = driver.getTitle();

        System.out.println(loginPageTitle);

        WebElement header = driver.findElement(By.className("login_logo"));

        Assert.assertTrue(header.isDisplayed(), "Header is not displayed");

        WebElement username = driver.findElement(By.id("user-name"));

        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");

        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.id("login-button"));

        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");

        loginButton.click();

        String productsPage = driver.getTitle();

        System.out.println(productsPage);

        WebElement productHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(productHeader.isDisplayed(), "Product header is not displayed");

        List<WebElement> items = driver.findElements(By.className("inventory_item_desc"));


        int productsNumber = items.size();

        Assert.assertEquals(productsNumber, 6, "Products number doesn't match");

        WebElement filterDrop = driver.findElement(By.className("product_sort_container"));

        Select filterSelect = new Select(filterDrop);

        filterSelect.selectByValue("lohi");

        Thread.sleep(1000);

        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));

        firstItem.click();

        String titleOfTheFirstProduct = driver.getTitle();

        System.out.println(titleOfTheFirstProduct);

        Thread.sleep(1000);

        WebElement productDescription = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));

        Assert.assertTrue(productDescription.isDisplayed(), "Product description is not displayed");

        WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));

       Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed");

        Thread.sleep(2000);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));

        Assert.assertTrue(addToCartButton.isEnabled(), "Add to cart button is not enabled");

        addToCartButton.click();

        Thread.sleep(1000);

        WebElement backToProductsLink = driver.findElement(By.id("back-to-products"));

        Assert.assertTrue(backToProductsLink.isDisplayed(), "Back to products link is not displayed");

        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));

        cartButton.click();

        Thread.sleep(1000);

        WebElement yourCartHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(yourCartHeader.isDisplayed(), "Your Cart header is not displayed");

        WebElement chosenProductTitle = driver.findElement(By.className("inventory_item_name"));

        Assert.assertTrue(chosenProductTitle.isDisplayed(), "Chosen product title is not displayed");

        WebElement chosenProductDescription = driver.findElement(By.className("inventory_item_desc"));

        Assert.assertTrue(chosenProductDescription.isDisplayed(), "Chosen product description is not displayed");

        WebElement chosenProductPrice = driver.findElement(By.className("inventory_item_price"));

        Assert.assertTrue(chosenProductPrice.isDisplayed(), "Chosen product price is not displayed");

        String defaultPrice = chosenProductPrice.getText();

        Assert.assertEquals(defaultPrice, "$7.99", "Price doesn't match");

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-onesie"));

        Assert.assertTrue(removeButton.isEnabled(), "Remove button is not enabled");

        WebElement checkOutButton = driver.findElement(By.id("checkout"));

        Assert.assertTrue(checkOutButton.isEnabled(), "Checkout button is not enabled");

        checkOutButton.click();

        WebElement checkoutYourInfoHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

        Assert.assertTrue(checkoutYourInfoHeader.isDisplayed(), "Check Your Info header is not displayed");

        Name name = faker.name();

        String firstName = name.firstName();

        String lastName = name.lastName();

        Address address = faker.address();

        String zipCode = address.zipCode();

        Thread.sleep(2000);

        WebElement enterFirstName = driver.findElement(By.id("first-name"));

        enterFirstName.sendKeys(firstName);

        Thread.sleep(1000);

        WebElement enterLastName = driver.findElement(By.id("last-name"));

        enterLastName.sendKeys(lastName);

        Thread.sleep(1000);

        WebElement enterZipCode = driver.findElement(By.id("postal-code"));

        enterZipCode.sendKeys(zipCode);

        Thread.sleep(1000);

        WebElement continueButton = driver.findElement(By.id("continue"));

        Assert.assertTrue(continueButton.isEnabled(), "Continue button is not enabled");

        continueButton.click();

        WebElement checkoutOverviewHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(checkoutOverviewHeader.isDisplayed(), "Checkout overview header is not displayed");

        WebElement paymentInfoHeader = driver.findElement(By.className("summary_info_label"));

        Assert.assertTrue(paymentInfoHeader.isDisplayed(), "Payment info header is not displayed");

        WebElement orderNumber = driver.findElement(By.className("summary_value_label"));

        Assert.assertTrue(orderNumber.isDisplayed(), "Order number is not displayed");

        WebElement shippingInfoHeader = driver.findElement(By.className("summary_info_label"));

       Assert.assertTrue(shippingInfoHeader.isDisplayed(), "Shipping Info header is not displayed");

        WebElement freePonyDelivery = driver.findElement(By.className("summary_value_label"));

       Assert.assertTrue(freePonyDelivery.isDisplayed(), "Free pony delivery is not displayed");

        WebElement priceTotalHeader = driver.findElement(By.className("summary_info_label"));

        Assert.assertTrue(priceTotalHeader.isDisplayed(), "Price Total header is not displayed");

        Thread.sleep(1000);

        //28. Calculate the Item total and Tax are equal to the Total price.

        WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));
        String itemTotalText = itemTotal.getText();
        String itemTextSubstring = itemTotalText.substring(itemTotalText.length() -4);
        double itemTotalDouble = Double.parseDouble(itemTextSubstring);
        System.out.println(itemTotalDouble);

        WebElement taxTotal = driver.findElement(By.className("summary_tax_label"));
        String taxTotalText = taxTotal.getText();
        String taxTextSubstring = taxTotalText.substring(taxTotalText.length() -4);
        double taxTotalDouble = Double.parseDouble(taxTextSubstring);
        System.out.println(taxTotalDouble);

        double projectedTotal = itemTotalDouble + taxTotalDouble;

        WebElement finalTotal = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
        String finalTotalText = finalTotal.getText();
        String finalTotalTextSubstring = finalTotalText.substring(finalTotalText.length() -4);
        double finalTotalDouble = Double.parseDouble(finalTotalTextSubstring);
        System.out.println(finalTotalDouble);

        Assert.assertEquals(projectedTotal, finalTotalDouble, "Totals are not matching");

        WebElement finishButton = driver.findElement(By.id("finish"));

        Assert.assertTrue(finishButton.isEnabled(), "Finish button is not enabled");

        finishButton.click();

        WebElement checkoutCompleteHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(checkoutCompleteHeader.isDisplayed(), "Checkout Complete header is not displayed");

        WebElement thankYouForYourOrder = driver.findElement(By.className("complete-header"));

        Assert.assertTrue(thankYouForYourOrder.isDisplayed(), "Thank you for your order is not displayed");

        WebElement orderText = driver.findElement(By.className("complete-text"));

        Assert.assertTrue(orderText.isDisplayed(), "Order text is not displayed");

        Thread.sleep(2000);

        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));

        Assert.assertTrue(backHomeButton.isDisplayed(), "Back home button is not displayed");

        Thread.sleep(1000);

        WebElement mainMenu = driver.findElement(By.id("react-burger-menu-btn"));

        mainMenu.click();

        Thread.sleep(1000);

        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));

        logoutLink.click();

        Thread.sleep(1000);

    }

    @Test (priority = 1)
    public void swagLabsPlaceOrderNegativeTestNoDataInPersoanlInfo() throws InterruptedException {

        String loginPageTitle = driver.getTitle();

        System.out.println(loginPageTitle);

        WebElement header = driver.findElement(By.className("login_logo"));

        Assert.assertTrue(header.isDisplayed(), "Header is not displayed");

        WebElement username = driver.findElement(By.id("user-name"));

        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");

        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.id("login-button"));

        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");

        loginButton.click();

        String productsPage = driver.getTitle();

        System.out.println(productsPage);

        WebElement productHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(productHeader.isDisplayed(), "Product header is not displayed");

        List<WebElement> items = driver.findElements(By.className("inventory_item_desc"));

        int productsNumber = items.size();

        Assert.assertEquals(productsNumber, 6, "Products number doesn't match");

        WebElement filterDrop = driver.findElement(By.className("product_sort_container"));

        Select filterSelect = new Select(filterDrop);

        filterSelect.selectByValue("lohi");

        Thread.sleep(1000);

        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));

        firstItem.click();

        String titleOfTheFirstProduct = driver.getTitle();

        System.out.println(titleOfTheFirstProduct);

        Thread.sleep(1000);

        WebElement productDescription = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));

        Assert.assertTrue(productDescription.isDisplayed(), "Product description is not displayed");

        WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));

        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed");

        Thread.sleep(1000);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));

        Assert.assertTrue(addToCartButton.isEnabled(), "Add to cart button is not enabled");

        addToCartButton.click();

        Thread.sleep(1000);

        WebElement backToProductsLink = driver.findElement(By.id("back-to-products"));

        Assert.assertTrue(backToProductsLink.isDisplayed(), "Back to products link is not displayed");

        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));

        cartButton.click();

        Thread.sleep(1000);

        WebElement yourCartHeader = driver.findElement(By.className("title"));

        Assert.assertTrue(yourCartHeader.isDisplayed(), "Your Cart header is not displayed");

        WebElement chosenProductTitle = driver.findElement(By.className("inventory_item_name"));

        Assert.assertTrue(chosenProductTitle.isDisplayed(), "Chosen product title is not displayed");

        WebElement chosenProductDescription = driver.findElement(By.className("inventory_item_desc"));

        Assert.assertTrue(chosenProductDescription.isDisplayed(), "Chosen product description is not displayed");

        WebElement chosenProductPrice = driver.findElement(By.className("inventory_item_price"));

        Assert.assertTrue(chosenProductPrice.isDisplayed(), "Chosen product price is not displayed");

        String defaultPrice = chosenProductPrice.getText();

        Assert.assertEquals(defaultPrice, "$7.99", "Price doesn't match");

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-onesie"));

        Assert.assertTrue(removeButton.isEnabled(), "Remove button is not enabled");

        WebElement checkOutButton = driver.findElement(By.id("checkout"));

        Assert.assertTrue(checkOutButton.isEnabled(), "Checkout button is not enabled");

        checkOutButton.click();

        WebElement continueButton = driver.findElement(By.id("continue"));

        Assert.assertTrue(continueButton.isEnabled(), "Continue button is not enabled");

        continueButton.click();

        WebElement errorMessageInCheckOut = driver.findElement(By.tagName("h3"));
        String errorMessageText = errorMessageInCheckOut.getText();
        Assert.assertTrue(errorMessageInCheckOut.isDisplayed(), "Error message in checkout is not displayed");
        Assert.assertEquals(errorMessageText, "Error: First Name is required", "Error message is incorrect");

        Name name = faker.name();

        String firstName = name.firstName();

        WebElement enterFirstName = driver.findElement(By.id("first-name"));

        enterFirstName.sendKeys(firstName);

        Thread.sleep(1000);

        continueButton.click();

        WebElement errorMessageFirstNameInCheckOut = driver.findElement(By.tagName("h3"));
        String errorMessageFirstNameText = errorMessageFirstNameInCheckOut.getText();
        Assert.assertTrue(errorMessageFirstNameInCheckOut.isDisplayed(), "Error message in checkout is not displayed");
        Assert.assertEquals(errorMessageFirstNameText, "Error: Last Name is required", "Error message is incorrect");

        String lastName = name.lastName();

        WebElement enterLastName = driver.findElement(By.id("last-name"));

        enterLastName.sendKeys(lastName);

        Thread.sleep(1000);

        continueButton.click();

        WebElement errorMessageLastNameInCheckOut = driver.findElement(By.tagName("h3"));
        String errorMessageLastNameText = errorMessageLastNameInCheckOut.getText();
        Assert.assertTrue(errorMessageLastNameInCheckOut.isDisplayed(), "Error message in checkout is not displayed");
        Assert.assertEquals(errorMessageLastNameText, "Error: Postal Code is required", "Error message is incorrect");

        Address address = faker.address();

        String zipCode = address.zipCode();

        WebElement enterZipCode = driver.findElement(By.id("postal-code"));

        enterZipCode.sendKeys(zipCode);

        Thread.sleep(1000);

        continueButton.click();

        WebElement mainMenu = driver.findElement(By.id("react-burger-menu-btn"));
        mainMenu.click();
        Thread.sleep(1000);
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();
        Thread.sleep(1000);

    }

}