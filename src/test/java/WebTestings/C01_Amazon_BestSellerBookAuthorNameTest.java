package WebTestings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Amazon_BestSellerBookAuthorNameTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Go to   https://www.amazon.co.uk/ and accept cookies

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();

        //2. Locate "best sellers tab" and click on it
        WebElement bestSellerButton = driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]"));
        bestSellerButton.click();

        //3. Best sellerlardan Books' a gidip tikla
        driver.findElement(By.xpath("(//a[text()='Books'])[2]")).click();

        Thread.sleep(2000);
        //4.Ikinci kitabin yazarinin Suzanne Collins oldugunu test et

        driver.findElement(By.xpath("//div[@id='1915780004']")).click();
        WebElement authorName = driver.findElement(By.xpath("//a[text()='Jessie Inchauspé']"));
        String expectedAuthorName = "Suzan Collins";
        String returnedAuthorName = authorName.getText();

        if (expectedAuthorName.equals(returnedAuthorName)) {
            System.out.println("Author Name Test Passed");
        } else {
            System.out.println("Author Name Test Failed");
        }

    }
}
