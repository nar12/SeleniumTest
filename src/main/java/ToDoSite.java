import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;


public class ToDoSite {
    public WebDriver WD;
    Actions actions = new Actions(WD);
    public static void main(String[] args){

    }
    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WD = new ChromeDriver();
        WD.get("https://todomvc-app-for-testing.surge.sh/");
        WD.manage().window().maximize();
        WebElement newTodo =  WD.findElement(By.className("new-todo"));
        newTodo.sendKeys("Selenium Python");
        newTodo.sendKeys(Keys.ENTER);
        newTodo.sendKeys("Selenium Java");
        newTodo.sendKeys(Keys.ENTER);
        newTodo.sendKeys("Selenium C#");
        newTodo.sendKeys(Keys.ENTER);
    }
    //@BeforeMethod
   // public void createToDo(WebDriver WD){

   // }
    @Test
    public void removeToDo(){
        actions.moveToElement(WD.findElement(By.xpath("//*[text()='Selenium Java']"))).perform();
        //WD.findElement(By.xpath("//*[@id='root']/div/section/ul/li[2]/div/button")).click();
        WD.findElement(By.cssSelector("li:nth-child(2)> div>button[class='destroy']")).click();
    }
    @Test
    void  checkCountOfActive(){
        List<WebElement> todoList = WD.findElements(By.cssSelector("ul.todo-list li"));
        List<WebElement> todoCompleted = WD.findElements(By.cssSelector("ul.todo-list li.completed"));
        Integer todoActive = todoList.size() - todoCompleted.size(); // count of Active
        Assert.assertEquals((todoActive + ""),WD.findElement(By.xpath("//*[@id='root']/div/section/footer/span/strong")).getText());
    }
    @Test
    void checkCountOfComplete(){
        List<WebElement> todoList = WD.findElements(By.cssSelector("ul.todo-list li"));
        List<WebElement> todoCompleted = WD.findElements(By.cssSelector("ul.todo-list li.completed"));
        Integer todoActive = todoList.size() - todoCompleted.size(); // count of Active

        Assert.assertEquals(todoCompleted.size(),(todoList.size() - todoActive));
    }
    @Test
    void checkCountOfAll(){
        List<WebElement> todoList = WD.findElements(By.cssSelector("ul.todo-list li"));
        List<WebElement> todoCompleted = WD.findElements(By.cssSelector("ul.todo-list li.completed"));
        Integer todoActive = todoList.size() - todoCompleted.size(); // count of Active

        Assert.assertEquals(todoList.size(),(todoActive + todoCompleted.size()));
    }

    @Test
    public void completeToDo(){
        actions.moveToElement(WD.findElement(By.xpath("//*[text()='Selenium C#']"))).build().perform();
        WD.findElement(By.xpath("//*[@id='root']/div/section/ul/li/div/input")).click();
    }
    @Test
    public void clearCompletedToDo(){
        WD.findElement(By.xpath("//button[@class='clear-completed']")).click();
    }

}
