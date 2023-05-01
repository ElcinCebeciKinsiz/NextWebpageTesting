package WebTestings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AmazonJUnitTest {

    // Create 3 different test methods
    // First Method- go to Amazon and test you have been there
    // Second Metod- Search for Nutella and test if results contains Nutella
    // Third Metod- Test the amount of Nutella results are more than 50

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("SetUp Metod Worked");  //Just to see this was worked at the beginning
    }
    @AfterClass
    public static void teardown(){
        driver.close();
        System.out.println("teardown Metod Worked"); //Just to see this was worked at the end
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String expectedWord = "Amazon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedWord)) {
            System.out.println("Being on Amazon webpage test PASSED");
        } else {
            System.out.println("Being on Amazon webpage test PASSED");
        }
    }
    @Test
    public void test02() {
        WebElement searhBox = driver.findElement(By.id("twotabsearchtextbox"));
        searhBox.sendKeys("Nutella" + Keys.ENTER);

        String expectedWord = "Nutella";
        WebElement foundNutellaAtResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String foundNutellaAtResultsStr=foundNutellaAtResults.getText(); //Turning webelement into str with getText()
        if (foundNutellaAtResultsStr.contains(expectedWord)) {
            System.out.println("Results contains Nutella test PASSED");
        } else {
            System.out.println("Results contains Nutella test FAILED");
        }
    }
    @Test
    public void test03(){
//// Third Metod- Test the amount of Nutella results are more than 50

        WebElement returnNutellaResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String returnNutellaResultStr= returnNutellaResult.getText();
        System.out.println(returnNutellaResultStr); //'1-48 of 61 results for Nutella'

        String[] returnNutellaArr=returnNutellaResultStr.split(" "); // 1-48,of,61,result,for,Nutella
        String quantityStr=returnNutellaArr[2];                            //"61" is on the second index and we define this to quantityNutella string
        int actualQuantityInt=Integer.parseInt(quantityStr);               //String "61" has been assingned actualQuantityInt as an integer by usuing Integer.pars
                                                                           // so we can use it in if statement for compare

        int expectedQuantity=50;                                          //Because we are looking if it is >50 therefore 50 assigned to expected quantity

        if (actualQuantityInt>expectedQuantity){
            System.out.println("If Found Quantity Bigger than 50 test PASSED");
        }else{
            System.out.println("If Found Quantity Bigger than 50 test FAILED");
        }

    }

}




