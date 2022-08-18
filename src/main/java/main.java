import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class main
{
    public static void main(String[] args) throws InterruptedException {
        /*
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
        webDriver.findElement(By.name("q")).sendKeys("Selenium Java");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        webDriver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
         */
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver wD = new ChromeDriver();
        wD.get("https://www.facebook.com/");
        wD.manage().window().maximize();
        //registrationFB(wD);
        loginFB(wD);

    }
    public static void registrationFB(WebDriver wD){
        wD.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        WebElement element = (new WebDriverWait(wD, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_8ien"))));
        wD.findElement(By.name("firstname")).click();
        wD.findElement(By.name("firstname")).sendKeys("Narek");
        wD.findElement(By.name("lastname")).click();
        wD.findElement(By.name("lastname")).sendKeys("Asatryan");
        wD.findElement(By.name("reg_email__")).sendKeys("blv23090@jeoce.com");
        wD.findElement(By.name("reg_email_confirmation__")).sendKeys("blv23090@jeoce.com");
        wD.findElement(By.name("reg_passwd__")).sendKeys("Bara1234567");
        Select birthday_day = new Select(wD.findElement(By.name("birthday_day")));
        birthday_day.selectByIndex(0);
        Select birthday_month = new Select(wD.findElement(By.name("birthday_month")));
        birthday_month.selectByIndex(0);
        Select birthday_year = new Select(wD.findElement(By.name("birthday_year")));
        birthday_year.selectByValue("2003");
        wD.findElement(By.xpath("//input[@value='2']")).click();
        wD.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    public static void loginFB(WebDriver wD) {
        wD.findElement(By.id("email")).sendKeys("blv23090@jeoce.com");
        wD.findElement(By.id("pass")).sendKeys("Bara1234567");
        wD.findElement(By.name("login")).click();
    }
}
