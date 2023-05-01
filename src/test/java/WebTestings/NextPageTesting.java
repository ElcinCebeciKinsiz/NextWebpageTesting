package WebTestings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NextPageTesting {


    public static void main(String[] args) throws InterruptedException {

        // go to https://www.next.co.uk/
        // Accept cookies
        // Locate search button and search for "artifical flowers"
        // Test the name of page is "Artifical Deocorative Plants"
        // From the page click on first picture and:
        // a.Test the if favourite button is enabled
        // b.Test if the price of flower is £32
        // Return to main page and test that you are on the main page
        //Quit the page



        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // go to https://www.next.co.uk/
        driver.get(" https://www.next.co.uk/");
        //driver.navigate().to("https://www.google.com");

        // accept cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        // Locate Search button and search for "artifical flowers"
        WebElement searhButton = driver.findElement(By.xpath("//input[@id='header-big-screen-search-box']"));
        searhButton.sendKeys("artificial flowers" + Keys.ENTER);

        // Test the name of page is "Artifical Deocorative Plants"
        String expectedNoame = "Artifical Deocorative Plants";
        String actualName = driver.getTitle();
        if (expectedNoame.equals(actualName)) {
            System.out.println("Name test PASSED");

        } else {
            System.out.println("Name test FAILED");
        }


        // On the page click on first picture and:
        driver.findElement(By.xpath("//img[@data-testid='product_summary_image_266756']")).click();

        //a.Test the if favourite button is enabled
        WebElement favouriteButton = driver.findElement(By.xpath("//strong[@id='favText']"));
        favouriteButton.isEnabled();
        if (favouriteButton.isEnabled()) {
            System.out.println("Fav Button Test Passed");
        } else {
            System.out.println("Fav Button Test Failed");
        }

        // b.Test if the price of flower is £32

        WebElement flowerPrice = driver.findElement(By.xpath("//div[@class='nowPrice branded-markdown']"));
        System.out.println(flowerPrice.getText());
        String expectedPrice = "£32";
        if (expectedPrice.equals(flowerPrice.getText())) {
            System.out.println("Flower Price Test PASSED");
        } else {
            System.out.println("Flower Price Test FAILED");
        }


        // Return to main page and test that you are on the main page
        driver.navigate().to("https://www.next.co.uk/");
        if (driver.getCurrentUrl().equals("https://www.next.co.uk/")) {
            System.out.println("URL test PASSED");
        } else {
            System.out.println("URL test FAILED");
        }

        //Quit the page

        Thread.sleep(1000);
        driver.quit();

    }
}






