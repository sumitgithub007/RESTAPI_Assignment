package stepDefinations;

 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Expediaclass {
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		/*
		 * driver.findElement(By.xpath("//div[text()='Sign in']/parent::button")).click(
		 * ); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		 * driver.findElement(By.xpath("//input[@type='email']")).sendKeys(
		 * "d.nandakishorereddy454@gmail.com");
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//button[@id='passwordButton']")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * "Krish$454");
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 */Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Flights']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='One-way']/parent::a")).click();
		Thread.sleep(5000);
//driver.findElement(By.xpath("//label[text()='Leaving from']/../button")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Leaving from']/../button"))))
				.click();
		Thread.sleep(3000);
//driver.findElement(By.xpath("//label[text()='Leaving from']/../input[contains(@placeholder,'from')]")).sendKeys("delhi");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Leaving from']/../input[contains(@placeholder,'from')]"))).sendKeys("delhi");
		Thread.sleep(30000);
	}

}
