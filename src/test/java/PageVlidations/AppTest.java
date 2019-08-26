package PageVlidations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	PrimusDataDriven pdd = new PrimusDataDriven();
	
	@BeforeTest
	public void opeN() {
		
		pdd.start();
		
	}
	
	@Test
	public void verifyEmpReg() throws Throwable {
		
		pdd.reg();
		
	}
	
	@AfterTest
	public void closE() {
		
		pdd.stop();
	}
	
	

}
