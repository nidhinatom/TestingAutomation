package basepkgpro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Baseeclass {

public WebDriver driver;
	
	@BeforeTest
	public void set() {
		
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlloadnng() throws Exception {
		
	//	driver.get("https://smallseotools.com/register/");
		driver.get("https://www.grammarly.com/plagiarism-checker");
		//driver.wait(1000);
		driver.manage().window().maximize();
	}
}
