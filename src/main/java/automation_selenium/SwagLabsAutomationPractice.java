package automation_selenium;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SwagLabsAutomationPractice {

    public static void main(String[] args) throws InterruptedException {


//        1. Navigate to saucedemo.com website
//        2. Verify the title of the site
//        3. Verify SwagLabs header is displayed
//        4. Enter ‘standard_user’ for the username input
//        5. Enter ‘secret_sauce’ for the password input
//        6. Verify login button is enabled
//        7. Click on the login button
//        8. Verify the title of the Products page
//        9. Verify the ‘PRODUCTS’ header is displayed on top left.
//        10. Verify that there are 6 products on the Products page
//        11. Click on filter option and filter the price to ‘low to high’
//        12. Click on the first Product
//        13. It will take you to Product Details Page. Verify the product title,
//        product description and price are displayed
//        14. Verify Add to Cart button is enabled and click it
//        15. Verify Back to Products link is displayed and click it
//        16. Click on Cart button on top right
//        17. Verify Your Cart header is displayed on top Left
//        18. Verify the Product title, Product Description and Price are displayed and the price is $7.99
//        19. Verify the Remove button is enabled
//        20. Verify the Checkout button is enabled and click that
//        21. Verify Checkout: Your Information header is displayed on top left
//        22. Enter random first and last name and zip
//        23. Verify Continue button is enabled and click it
//        24. Verify Checkout: Overview header is displayed on top left
//        25. Verify Payment Information header and below Order number is displayed
//        26. Verify Shipping information header is displayed and Free Pony Express Delivery! is also displayed
//        27. Verify Price Total header is displayed
//        28. Calculate the Item total and Tax are equal to the Total price.
//        29. Verify Finish button is enabled and click it
//        30. Verify Checkout: Complete! header is displayed on top left
//        31. Verify Thank you for your order! and the below message is displayed
//        32. Verify the Back Home button is enabled and click it
//        33. Verify the page is navigate back to Products page
//        34. Click on top left menu
//        35. Click on logout link
//        36. Close the browser.

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        String loginPageTitle = driver.getTitle();

        System.out.println(loginPageTitle);

        WebElement header = driver.findElement(By.className("login_logo"));

        boolean isHeaderDisplayed = header.isDisplayed();

        if (isHeaderDisplayed){

            System.out.println("The header is displayed");
        }else{

            System.out.println("Header is not displayed");
        }

        WebElement username = driver.findElement(By.id("user-name"));

        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");

        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.id("login-button"));

        boolean isLoginButtonEnabled = loginButton.isEnabled();

        if (isLoginButtonEnabled){
            loginButton.click();
            System.out.println("Login button is enabled");
        }else{
            System.out.println("Login button doesn't work");
        }

        String productsPage = driver.getTitle();

        System.out.println(productsPage);

        WebElement productHeader = driver.findElement(By.className("title"));

        boolean isProductHeaderDisplayed = productHeader.isDisplayed();

        if(isProductHeaderDisplayed){

            System.out.println("Product header is displayed");
        }else{

            System.out.println("Product header is not displayed");
        }

        List<WebElement> items = driver.findElements(By.className("inventory_item_desc"));

//        Actions actions = new Actions(driver);
//
//        for (WebElement item: items){
//
//            actions.moveToElement(item).build().perform();
//
//            Thread.sleep(2000);
//
//
//        }

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int i = 0;
//
//        while (i < 100){
//            js.executeScript("window.scrollBy.(0,200)", "");
//            i++;
//        }
//
//        Thread.sleep(2000);

        int productsNumber = items.size();

        if(productsNumber == 6){
            System.out.println("There are 6 items");
        }else{

            System.out.println("Products number doesn't match");
        }

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

        boolean isProductDescriptionDisplayed = productDescription.isDisplayed();

        if (isProductDescriptionDisplayed){

            System.out.println("Product description is displayed");
        }else {
            System.out.println("Product description is not displayed");
        }

        WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));

        boolean isProductPriceDisplayed = productPrice.isDisplayed();

        if (isProductPriceDisplayed){

            System.out.println("Product price is displayed");
        }else {

            System.out.println("Product price is not displayed");
        }
        
        Thread.sleep(2000);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));

        boolean isAddToCartButtonEnabled = addToCartButton.isEnabled();

        if (isAddToCartButtonEnabled){
            addToCartButton.click();
            System.out.println("Add to cart button is enabled");
        }else{
            System.out.println("Add to cart button doesn't work");
        }

        Thread.sleep(1000);

        WebElement backToProductsLink = driver.findElement(By.id("back-to-products"));

        boolean isBackTorProductsLinkDisplayed = backToProductsLink.isDisplayed();

        if (isBackTorProductsLinkDisplayed){
            backToProductsLink.click();

            System.out.println("Back to products link is displayed");
        }else {

            System.out.println("Back to products link is not displayed");
        }

        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));

        cartButton.click();

        Thread.sleep(1000);

        WebElement yourCartHeader = driver.findElement(By.className("title"));

        boolean yourCartHeaderIsDisplayed = yourCartHeader.isSelected();

        if (yourCartHeaderIsDisplayed){

            System.out.println("Your Cart header is displayed");
        }else{

            System.out.println("Your Cart header is not displayed");
        }

        WebElement chosenProductTitle = driver.findElement(By.className("inventory_item_name"));

        boolean chosenProductTitleIsDisplayed = chosenProductTitle.isDisplayed();

        if (chosenProductTitleIsDisplayed){

            System.out.println("Product Title is displayed");
        }else{

            System.out.println("Product Title is not displayed");
        }

        WebElement chosenProductDescription = driver.findElement(By.className("inventory_item_desc"));

        boolean chosenProductDescriptionDesplayed = chosenProductDescription.isDisplayed();

        if (chosenProductDescriptionDesplayed){

            System.out.println("Product description is displayed");
        }else{
            System.out.println("Product description is not displayed");
        }

        WebElement chosenProductPrice = driver.findElement(By.className("inventory_item_price"));

        boolean chosenProductPriceDisplayed = chosenProductPrice.isDisplayed();

        if (chosenProductPriceDisplayed){

            System.out.println("Product price is displayed");
        }else{
            System.out.println("Product price is not displayed");
        }

        String defaultPrice = chosenProductPrice.getText();

        if (defaultPrice.equals("$7.99")){
            System.out.println("The price is correct");
        }else {

            System.out.println("The price is not correct");
        }

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-onesie"));

        boolean removeButtonEnabled = removeButton.isEnabled();

        if (removeButtonEnabled){

            System.out.println("Remove button is enabled");
        }else{

            System.out.println("Remove button doesn't work");
        }

        WebElement checkOutButton = driver.findElement(By.id("checkout"));

        boolean checkOutButtonEnabled = checkOutButton.isEnabled();

        if (checkOutButtonEnabled){
            checkOutButton.click();

            System.out.println("Checkout button is enabled");
        }else{

            System.out.println("Checkout button doesn't work");
        }

        WebElement checkoutYourInfoHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

        boolean checkoutYourInfoHeaderDisplayed = checkoutYourInfoHeader.isDisplayed();

        if (checkoutYourInfoHeaderDisplayed){

            System.out.println("Checkout: Your Information header is displayed");
        }else{

            System.out.println("Checkout: Your Information header is not displayed");
        }

        Faker faker = new Faker();

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

        boolean continueButtonEnabled = continueButton.isEnabled();

        if (continueButtonEnabled){

            continueButton.click();

            System.out.println("Continue button is enabled");
        }else{

            System.out.println("Continue button doesn't work");
        }

        WebElement checkoutOverviewHeader = driver.findElement(By.className("title"));

        boolean checkoutOverviewHeaderDisplayed = checkoutOverviewHeader.isDisplayed();

        if (checkoutOverviewHeaderDisplayed){

            System.out.println("Checkout: Overview header is displayed");
        }else{

            System.out.println("Checkout: Overview header is not displayed");
        }

        WebElement paymentInfoHeader = driver.findElement(By.className("summary_info_label"));

        boolean paymentInfoHeaderDisplayed = paymentInfoHeader.isDisplayed();

        if (paymentInfoHeaderDisplayed){

            System.out.println("Payment Information header is displayed");
        }else{

            System.out.println("Payment Information header is not displayed");
        }

        WebElement orderNumber = driver.findElement(By.className("summary_value_label"));

        boolean orderNumberDisplayed = orderNumber.isDisplayed();

        if (orderNumberDisplayed){

            System.out.println("Order number is displayed");
        }else{

            System.out.println("Order number is not displayed");
        }

        WebElement shippingInfoHeader = driver.findElement(By.className("summary_info_label"));

        boolean shippingInfoHeaderDisplayed = shippingInfoHeader.isDisplayed();

        if (shippingInfoHeaderDisplayed){

            System.out.println("Shipping Information header is displayed");
        }else{
            System.out.println("Shipping Information header is not displayed");
        }

        WebElement freePonyDelivery = driver.findElement(By.className("summary_value_label"));

        boolean freePonyDeliveryDisplayed = freePonyDelivery.isDisplayed();

        if (freePonyDeliveryDisplayed){

            System.out.println("Free Pony Express Delivery! is displayed");
        }else{

            System.out.println("Free Pony Express Delivery! is not displayed");
        }

        WebElement priceTotalHeader = driver.findElement(By.className("summary_info_label"));

        boolean priceTotalHeaderDisplayed = priceTotalHeader.isDisplayed();

        if (priceTotalHeaderDisplayed){
            System.out.println("Price Total header is displayed");
        }else{
            System.out.println("Price Total header is not displayed");
        }

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

        if (projectedTotal == finalTotalDouble){

            System.out.println("The Total price is calculated correctly");
        }else{

            System.out.println("The Total price is calculated incorrectly");
        }

         WebElement finishButton = driver.findElement(By.id("finish"));

        boolean finishButtonEnabled = finishButton.isEnabled();

        if (finishButtonEnabled){
            finishButton.click();

            System.out.println("Finish button is enabled");
        }else{
            System.out.println("Finish button doesn't work");
        }

        WebElement checkoutCompleteHeader = driver.findElement(By.className("title"));

        boolean checkoutCompleteHeaderDisplayed = checkoutCompleteHeader.isDisplayed();

        if (checkoutCompleteHeaderDisplayed){

            System.out.println("Checkout: Complete! header is displayed");
        }else{

            System.out.println("Checkout: Complete! header is not displayed");
        }

        WebElement thankYouForYourOrder = driver.findElement(By.className("complete-header"));

        boolean thankYouForYourOrderDisplayed = thankYouForYourOrder.isDisplayed();

        if (thankYouForYourOrderDisplayed){

            System.out.println("Thank you for your order! is displayed");
        }else{
            System.out.println("Thank you for your order! is not displayed");
        }

        WebElement orderText = driver.findElement(By.className("complete-text"));

        boolean orderTextDisplayed = orderText.isDisplayed();

        if (orderTextDisplayed){

            System.out.println("Order text is displayed");
        }else{

            System.out.println("Order text is not displayed");
        }

        Thread.sleep(2000);

        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));

        boolean backHomeButtonEnabled = backHomeButton.isEnabled();

        if (backHomeButtonEnabled){

            backHomeButton.click();

            System.out.println("Back Home button is enabled");
        }else{

            System.out.println("Back Home button doesn't work");
        }

        Thread.sleep(1000);

        // 33. Verify the page is navigate back to Products page

        WebElement mainMenu = driver.findElement(By.id("react-burger-menu-btn"));

        mainMenu.click();

        Thread.sleep(1000);

        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));

        logoutLink.click();

        Thread.sleep(1000);

        driver.quit();




    }
}
