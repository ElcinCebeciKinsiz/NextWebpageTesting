package WebTestings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AmazonTesting {
    public static void main(String[] args) throws InterruptedException {

            // 1.Apache Maven is a tool that focuses on making software projects easy to understand and manage.
            // 2.Based on the concept of Project Object Management (POM), Maven can centrally manage, the construction,
            // reporting, and documentation of a project from a central piece of information (dependency).
            // 3.It allows you to work as a team
            // 4.Through the dependencies and plug-ins that we add onto Maven, we can manage our projects effectively
            // 5.We don't need to copy and paste chromedriver path any longer


            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //6. If we want to use any other browser instead of Chrome we just put that browser's name instead Chrome
//1.Go to https://www.amazon.com/
            driver.get("https://www.amazon.com/");
//2. Locate search button
            WebElement searchButton= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//3. Search for "Lenova Laptop"
            searchButton.sendKeys("Lenova Laptop"+ Keys.ENTER);

//4. Write result (how many Levona Laptop result returned)
            WebElement totalQuantityOfLevona= driver.findElement(By.xpath("//span[@class='rush-component'][1]"));
            System.out.println(totalQuantityOfLevona.getText());

//5. Click on the firts item's link
            driver.findElement(By.xpath("//span[@data-component-id='14']")).click();

//6. Navigate back to previous page
            driver.navigate().back();

            //7. List all the titles on the page
            List<WebElement> titleList=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base puis-bold-weight-text']"));

            for (WebElement each:titleList
            ) {
                System.out.println(each.getText());

            }
            Thread.sleep(1000);
            driver.close();


        }
    }








