package testpkgpro;

import org.testng.annotations.Test;

//import basepkg.Baseclass;
import basepkgpro.Baseeclass;
//import pagepkg.Fbpage;
import pagepkgpro.Functions;
//import utilities.Excelutil;
import utilitiespro.Excelutilpro;

public class Testpro extends Baseeclass  {
	
	@Test
	public void registerdatadriven() throws Exception {
		
		Functions p1=new Functions(driver);
		//Reading data from excel file by specified path
		String x1="D:\\\\Bookpro.xlsx";
		String Sheet="Sheet1";
		int rowCount=Excelutilpro.getRowCount(x1,Sheet);
		
		for(int i=1;i<=rowCount;i++) {
			
			String email=Excelutilpro.getCellValue(x1,Sheet,i,0);
			System.out.println("email "+email);
			String password=Excelutilpro.getCellValue(x1,Sheet,i,1);
			System.out.println("password "+password);
			String name=Excelutilpro.getCellValue(x1,Sheet,i,2);
			System.out.println("name "+name);
			
			p1.login(email, password, name);
	
		}}
	
	@Test
	public void scrnshot() throws Exception {
		Functions p2=new Functions(driver);
		p2.screeenshot();
	}
	
	@Test
	public void scroll() throws Exception {
		Functions p3=new Functions(driver);
		p3.scrolldown();
	}
	@Test
	public void upload() throws Exception {
		Functions p4=new Functions(driver);
		p4.hitest();
	}
	
	@Test
	public void srch() throws Exception {
		Functions p5=new Functions(driver);
		p5.search();
	}
	
	
}
