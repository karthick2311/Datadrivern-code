package homepage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeElements {
	WebDriver driver;

	@Test
	public void home() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\karthick\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://orgfarm.store");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//*[@id=\"sticky-wrapper\"]/div/div[1]/div[3]/div[3]/div/a[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"searchTextField\"]")).sendKeys("600001");
		driver.findElement(By.xpath("//*[@id=\"submit\"]/span")).click();

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id=\"popover942447\"]/h3/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//*[@id=\"bannermodal\"]/div/div/div/div/img")).click();

		driver.findElement(By.xpath("//*[@id=\"sticky-wrapper\"]/div/div[2]/div[2]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		List<WebElement> Links = driver.findElements(By.cssSelector("h3"));
		System.out.println(Links.size());

		String seperator ="";
		FileWriter w = new FileWriter("C:\\\\Users\\\\karthick\\\\Documents\\\\data\\\\elementrst.txt");
		BufferedWriter bf = new BufferedWriter(w);
		
	  
				
		for (int i = 0; i < Links.size(); i++) {
			String text = Links.get(i).getText();

			//String all=Links.get(i).getAttribute("data-item_name"+" "+"data-item_price"+" "+"data-item_unit");
			String unit=Links.get(i).getAttribute("data-item_unit");
			String price = Links.get(i).getAttribute("data-item_price");
		    String exx =text+unit+price;
			String str = exx.replaceAll("[^a-zA-Z0-9]", ",");

		   String ex = str.replace("[","").replace("]",""); 

		    String s = ex.toString();
		    System.out.println(s);
			//String str = exx.replaceAll("[^a-zA-Z0-9]", ",");
		    //String ex =text+seperator+unit+seperator+price;

			//String output = str.replaceAll("(str)","'$1'");

			//System.out.println(	str);
			//separator = ",";
			//System.out.println(text);
			 //w.append(text);
			// bf.append(one);
			bf.write(s);
			bf.append('\n');
			//bf.write(exx);
			//bf.write(exx);

			
			//bf.close();
			//out.write(one);

			bf.flush();
			
		}
		bf.close();

//	System.out.println(Links.size());
//	for (WebElement Link : Links){
//		//System.out.println(Link.getText());
//		System.out.println(Link.getAttribute("data-item_name"  ));
//		System.out.println(Link.getAttribute("data-item_price"));
//		System.out.println(Link.getAttribute("data-item_unit"));
//
//		System.out.println("..........");
//	}

	}
}
//	//orgfarm icon
//	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//	if(driver.findElement(By.xpath("//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/a/img")).getSize()!=0) {
//		System.out.println("orgfarm icon displayed");
//	}else {
//			System.out.println("Missing for orgfarm icon");
//	}
////	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//	}}
/*
 * //serch input box
 * 
 * @Test public void search(){ WebElement
 * ser=driver.findElement(By.xpath("//*[@id=\"inlineFormInputGroupUsername2\"]")
 * ); ser.isDisplayed(); ser.sendKeys("tomato"); driver.findElement(By.xpath(
 * "//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/div[1]/form/div/div")).click(
 * ); if(driver.getPageSource().contains("tomato")){ System.out.
 * println("Tomato product is displayed and search functionality is working");
 * }else{ System.out.println("Text is absent"); }}
 * 
 * @Test public void loc(){ if(
 * driver.findElement(By.className("//*[contains(@class, 'ml-2 mr-1')]")).
 * isDisplayed()){ System.out.println("location icon displayed"); } else{
 * System.out.println("Element is InVisible"); }
 * 
 * } }
 */
