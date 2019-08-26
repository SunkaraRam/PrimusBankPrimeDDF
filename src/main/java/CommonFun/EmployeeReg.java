package CommonFun;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class EmployeeReg {
	
	public WebDriver driver;
	
	public void initialization(String uid,String pwd) {	
	
		System.setProperty("webdriver.chrome.driver","D:\\PrimuBankPrimeDDF\\CommonJars\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://primusbank.qedgetech.com");
		
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		
		driver.findElement(By.id("login")).click();
		
		String act = driver.getCurrentUrl();
		
		String exp = "adminflow";
		
		if (act.toLowerCase().contains(exp.toLowerCase())) {
			
			System.out.println("Login Success");
			
		}
		
		else {
			System.out.println("Login Fail");
		}
	}
	
	
	public boolean registeR(String ename,String epwd,String role,String brch) throws InterruptedException, Throwable {
		
		driver.findElement(By.xpath("//tr[8]//td[1]//a[1]//img[1]")).click();
		
		driver.findElement(By.xpath("//input[@id='BtnNew']")).click();

		
		try {
			
				driver.findElement(By.id("txtUname")).sendKeys(ename);
				

				Thread.sleep(5000);				
			
				
				driver.findElement(By.id("txtLpwd")).sendKeys(epwd);
				
		}
		catch (Exception e) {
			
			if (ename.length()==3||ename.length()>3&&ename==null) {
				
				BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				ImageIO.write(image, "png", new File(".\\FailedTCScreen\\EmpNameWrongOrNull.png"));
				
			}
			
			Alert alt  = driver.switchTo().alert();
			alt.accept();
			
			return false;
				 
		}
	

		try {
		
				Select sl = new Select(driver.findElement(By.id("lst_Roles")));
				
				sl.selectByVisibleText(role);
				
				//return false;
				
		} 
		catch (Exception e) {
		
			System.out.println(role + " Element not available in Role Dropdown List");
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(srcFile, new File("./FailedTCScreen/"+"FailedSelect_role"+".png"));
			
			return false;
		
		}
		
		try {
			
		
		Select slc = new Select(driver.findElement(By.id("lst_Branch")));
		
		slc.selectByVisibleText(brch);
		
		} catch (Exception e) {
		
			System.out.println(brch + " Element not available in Branch Dropdown List");
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(srcFile, new File("./FailedTCScreen/FailedSelect_branch"+".png"));
			
			return false;
			}
		
		driver.findElement(By.id("BtnSubmit")).click();
		
		Alert al = driver.switchTo().alert();
	
		Thread.sleep(2000);
		
		String act=al.getText();
		
		String exp = "Successfully";
		
		String exp1 = "Password";
		al.accept();
		
		if (act.toLowerCase().contains(exp.toLowerCase())) {
			
			System.out.println("Employee Registration Success");
			return true;
			
		}
		
		else if (act.toLowerCase().contains(exp1.toLowerCase())) {
			
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(".\\FailedTCScreen\\PassWordWrongOrNull.png"));
			
			return false;
			
		}
		
		else {
			
			System.out.println("Employee Registration Unsuccess");
			
			return false;
			
		
		}
		
		
	}
	
	
	public void end() {
		
		driver.quit();
	}

		
}
