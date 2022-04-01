package homepage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Bigbasket {

	public class jiomart {
		@Test	
		public void home() throws IOException, InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\karthick\\Downloads\\chromedriver_win32 (2).exe");
			WebDriver driver = new ChromeDriver();
			driver.get(
					"https://www.bigbasket.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand-CHN&gclid=EAIaIQobChMIzOnC14-p9QIVg3wrCh3WrA1PEAAYASAAEgKJEvD_BwE");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div/ul/li[2]/div/a/span/span[3]"))
					.click();
			driver.findElement(By.xpath(
					"/html/body/div[1]/div[1]/header/div/div/div/div/ul/li[2]/div/div/div[2]/form/div[1]/div/div/span"))
					.click();
			driver.findElement(By.xpath(
					"//*[@id=\"headerControllerId\"]/header/div/div/div/div/ul/li[2]/div/div/div[2]/form/div[1]/div/input[1]"))
					.sendKeys("chennai");
			driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-1-0\"]/a")).click();
			driver.findElement(By.xpath(
					"//*[@id=\"headerControllerId\"]/header/div/div/div/div/ul/li[2]/div/div/div[2]/form/div[3]/button"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"navBarMegaNav\"]/li[1]/a")).click();
			try {
				Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

				while (true) {
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
					Thread.sleep(2000);

					Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
					if (newHeight.equals(lastHeight)) {
						
						break;
					}
					lastHeight = newHeight;
					Thread.sleep(3000);

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<WebElement> Links = driver.findElements(By.xpath("//*[@qa=\"product_name\"]/a"));
			List<WebElement> variation = driver.findElements(By.xpath("//*[@ng-bind=\"vm.selectedProduct.w\"]"));
			List<WebElement> price = driver.findElements(By.xpath("//*[@class=\"discnt-price\"]"));

			System.out.println(Links.size());
			System.out.println(variation.size());
			FileWriter w = new FileWriter("C:\\\\Users\\\\karthick\\\\Documents\\\\data\\\\ord.txt");
			BufferedWriter bf = new BufferedWriter(w);

			for (int i = 0; i < Links.size(); i++) {
				String lin1 = Links.get(i).getText();
				String lin2 = variation.get(i).getText();
				String lin3 = price.get(i).getText();
				String t = lin1 + ", " + lin2 + ", " + lin3;
				System.out.println(t);
				bf.write(t);
				bf.append('\n');

			}
			bf.flush();

		}
	}
}
