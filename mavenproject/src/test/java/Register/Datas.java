package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datas {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\karthick\\Downloads\\chromedriver_win32\\chromedriver.exe");  
        WebDriver driver = new ChromeDriver();
		driver.get("https://pwa.orgfarm.store/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div/form/p")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("8344307156");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("9944835585");
		driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div/form/button")).click();
		if(driver.findElement(By.xpath("//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/a/img")).isDisplayed()){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}		
	}

}
