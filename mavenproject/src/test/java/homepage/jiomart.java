package homepage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class jiomart {

	@SuppressWarnings("deprecation")
	@Test
	public void home() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\karthick\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/c/groceries/fruits-vegetables/219");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"nav_link_219\"]")).click();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// JavascriptExecutor js=(JavascriptExecutor) driver;

		driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[5]")).click();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		try {
			Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				Thread.sleep(3000);

				if (newHeight.equals(lastHeight)) {
					Thread.sleep(5000);
					break;

				}
				driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
				Thread.sleep(2000);

				lastHeight = newHeight;
			}
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1000000000)");

		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"searchTextField\"]")).sendKeys("600001");
		// driver.findElement(By.xpath("//*[@id=\"submit\"]/span")).click();

		// driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//*[@id=\"sticky-wrapper\"]/div/div[2]/div[2]/ul/li[2]/a")).click();
		// driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// List<WebElement> Links =
		// driver.findElements(By.xpath("//a[@class=\"category_name prod-name\"]"));

		List<WebElement> Links = driver.findElements(By.xpath("//*[@class=\"clsgetname\"]"));
		List<WebElement> Links1 = driver.findElements(By.xpath("//*[@id=\"final_price\"]"));

		System.out.println(Links.size());
		System.out.println(Links1.size());

		String seperator = "";
		FileWriter w = new FileWriter("C:\\\\Users\\\\karthick\\\\Documents\\\\data\\\\toay.txt");
		BufferedWriter bf = new BufferedWriter(w);

		for (int i = 0; i < Links.size(); i++) {
			String lin1 = Links.get(i).getText();
			// String real = lin1.replaceAll("[^a-zA-Z0-9]", ",");
			// String real1 = lin1.replace("[","").replace("]","");

			// System.out.println(jsonobject.getInt("id"));
			String lin2 = Links1.get(i).getText();
			// tring reall = lin2.replaceAll("[^a-zA-Z0-9]", ",");
			String exx = lin1 + "" + lin2;

			// tring exx =real+lin2;
			// String reall = lin1.replaceAll("[^a-zA-Z0-9]", ",");
			// String ex = str.replace("[","").replace("]","");
			// String s = exx.toString();
			System.out.println(exx);
			bf.write(exx);
			bf.append('\n');
		}

		bf.flush();

	}
}
