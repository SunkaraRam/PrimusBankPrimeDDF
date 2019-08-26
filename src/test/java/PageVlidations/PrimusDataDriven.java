package PageVlidations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.DataPass;
import CommonFun.EmployeeReg;

public class PrimusDataDriven extends CommonFun.EmployeeReg{
	
	public EmployeeReg er = new EmployeeReg();
	
	ExtentReports report;
	
	ExtentTest test;
	
	@BeforeMethod
	public void start() {
		
		report = new ExtentReports("./Reports/empTC.html");
		
		test = report.startTest("Verify Employee Creation");
		
		er.initialization("Admin", "Admin");		
	}
	
	@Test
	public void reg() throws Throwable {
		
		DataPass dt = new DataPass();
		
		int rc = dt.rowCount("Sheet1");
		
		for (int i = 1; i <=rc; i++) {
		
			String ename = dt.getData("Sheet1", i, 0);	
			
			test.log(LogStatus.INFO, "Entering EmployeeName-- " + ename);
					
			String epwd = DataPass.getData("Sheet1", i, 1);
			
			test.log(LogStatus.INFO, "Entering EmployeePassword--  " + epwd);
			
			String role = dt.getData("Sheet1", i, 2);
			
			test.log(LogStatus.INFO, "Entering Role Of the Employee--  " + role);
			
			String brch = dt.getData("Sheet1", i, 3);
			
			test.log(LogStatus.INFO, "Entering Branch of the Employee--  " + brch);
						
			
			boolean ram=er.registeR(ename, epwd, role, brch);
			
			if (ram==true) 
			{
				
				Assert.assertTrue(ram);
				dt.setData("Sheet1", i, 4, "Pass");
				test.log(LogStatus.PASS, "Test Case Pass");
				
			}
			
			if (ram==false) {
				
				Assert.assertFalse(ram);
				dt.setData("Sheet1", i, 4, "Fail");
				test.log(LogStatus.FAIL, "Test Case Fail");
				
				} 
				
			}
		
		}
	
		
	
	
	@AfterMethod
	public void stop() {
		
		report.flush();
		report.endTest(test);
		 
		er.end();
	}
	
	

}
