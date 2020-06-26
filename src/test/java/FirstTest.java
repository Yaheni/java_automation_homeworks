import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class FirstTest {
    @Test
    public void GoogleMailTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Authorization through StackOverFlow

        driver.get("https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent%27");
        WebElement googleButton = driver.findElement(By.xpath("//*[@id=\"openid-buttons\"]/button[1]"));
        googleButton.click();
        WebElement googleEmailInputField = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        googleEmailInputField.sendKeys("Boris");
        WebElement nextButtonEmail = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div"));
        nextButtonEmail.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement googlePasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        googlePasswordInputField.sendKeys("Boris123)");
        WebElement nextButtonPassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div"));
        nextButtonPassword.click();
        WebElement loginButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]"));

        //Delete first email in inbox

        driver.get("https://mail.google.com/mail/u/0/#inbox");
        WebElement firstCheckBoxMail = driver.findElement(By.xpath("//tbody//tr[@class='zA yO'][1]/td[2]/div"));
        firstCheckBoxMail.click();
        WebElement deleteMailButton = driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]"));
        deleteMailButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Go to spam folder, clear it or/and exit

        driver.get("https://mail.google.com/mail/u/0/#spam");

        if (driver.findElements(By.xpath("//*[@id=\":1\"]/div/div[2]/div[3]/div[3]/table/tbody/tr/td")).size() != 0) {
            System.out.println("Folder 'Spam' is empty!");
        }
        else {
            WebElement deleteSpamButton = driver.findElement(By.xpath("//div//span[@class='x2']"));
            deleteSpamButton.click();
            WebElement confirmDeleteSpamButton = driver.findElement(By.xpath("//button[@name='ok'][@class='J-at1-auR J-at1-atl']"));
            confirmDeleteSpamButton.click();
        }

        driver.close();
    }

    public void main(String[] args) {

        GoogleMailTest();

    }
}
