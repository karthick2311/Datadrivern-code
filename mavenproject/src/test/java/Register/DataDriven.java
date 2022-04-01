package Register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\karthick\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		WebDriver driver = new ChromeDriver();
		driver.get("https://pwa.orgfarm.store/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div/button")).click();

        File file = new File("C:\\Users\\karthick\\Documents\\data\\PWA Register.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        int rowCount=sheet.getLastRowNum();//-sheet.getFirstRowNum();
        for(int i=1;i<=rowCount;i++) {
            String First_Name= new DataFormatter().formatCellValue(sheet.getRow(i).getCell(0));
            String Phone_Number= new DataFormatter().formatCellValue(sheet.getRow(i).getCell(1));
            String Email_id= new DataFormatter().formatCellValue(sheet.getRow(i).getCell(2));
            String Password= new DataFormatter().formatCellValue(sheet.getRow(i).getCell(3));
           
			System.out.println(First_Name);
			System.out.println(Phone_Number);
			System.out.println(Email_id);
			System.out.println(Password);
		
			driver.findElement(By.id("fullname")).sendKeys(First_Name);
			driver.findElement(By.name("tel")).sendKeys(Phone_Number);
			driver.findElement(By.id("email")).sendKeys(Email_id);
			driver.findElement(By.id("password")).sendKeys(Password);
			driver.findElement(By.xpath("//*[@id=\"nav-profile\"]/div/div/form/div[5]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"nav-profile\"]/div/div/form/button")).click();
		//Verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"nav-profile\"]/div/div/h2"));
            //create a new cell in the row at index 6
            XSSFCell cell = sheet.getRow(i).createCell(6);
            //check if confirmation message is displayed
            if (confirmationMessage.isDisplayed()) { 
             
                cell.setCellValue("pass");
                
            } else {		
                //if the message is not displayed , write FAIL in the excel sheet
                cell.setCellValue("PASS");
            }
             // Write the data back in the Excel file
            FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\karthick\\\\Documents\\\\data\\\\PWA Register.xlsx");
            wb.write(outputStream);
           driver.findElement(By.xpath("//*[@id=\"nav-tab\"]/a/h1/i")).click();
			driver.findElement(By.xpath("//*[@id=\"main_app_id\"]/div/div[1]/div[2]/nav/div[2]/a[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div/button")).click();

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        }
			System.out.println("exicted");
			Thread.sleep(2000);
		}
}

	
	

