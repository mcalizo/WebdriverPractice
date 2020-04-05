package Steps;

import Utils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() {
		driver = getDriver();  
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
		
		}
	}	


