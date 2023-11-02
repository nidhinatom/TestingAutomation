package pagepkgpro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Functions {

	WebDriver driver;
	
	
	By email=By.id("email");
	By password=By.id("password");
	By name=By.id("name");
	//By psswdconfirm=By.id("password-confirm");
	
	public Functions(WebDriver driver) {
		this.driver=driver;
	}
	//public void main() throws IOException {
		
		
//}
	public void login(String argemail, String argpassword, String argname) throws Exception {
		
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/nav/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"signinFormContainer\"]/form/div[1]/div/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"signupFormContainer\"]/form/button/span")).click();
		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(argemail);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(argpassword);
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(argname);
		
		driver.findElement(By.xpath("//*[@id=\"signupFormContainer\"]/form/button/span")).click();
		Thread.sleep(5000);

		String ttt=driver.getPageSource();
		if(ttt.contains("Back"))
		{
			System.out.println("register pass");
			
		}
		else
		{
			System.out.println("register fail");
		}
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
	public void screeenshot() throws Exception {
		
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src, new File("D:\\sunday.png"));
		
		WebElement dayelement= driver.findElement(By.xpath("//*[@id=\"sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX\"]/div[1]/div[1]/h1"));
		File srccurrent=dayelement.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srccurrent, new File("./pictures//namepro.png"));
	}
	
	public void scrolldown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(("window.scrollBy(0,1000)"), "");
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[6]/ul/li[2]/a")));
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div/nav/div[2]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	public void hitest() throws AWTException {
		driver.findElement(By.xpath("//*[@id=\"sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX\"]/div[2]/form/div/div[4]/button[2]/span")).click();
		fileUpload("D:\\reflection.docx");
	}
	public void fileUpload(String p) throws AWTException{
		//to copy path to clipboard
		StringSelection strSelection=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		//to paste into systemwindow
		Robot robot=new Robot();
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		//Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	
	public void search() throws Exception {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(("window.scrollBy(0,1000)"), "");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div/nav/div[5]/ul/li[1]/a")).click();
		
		WebElement e=driver.findElement(By.xpath("/html/body/main/section[1]/main/div[8]/form/input[2]"));
		e.sendKeys("desktop");
		e.sendKeys(Keys.ENTER);
		
	}
	

	
	
	
}
