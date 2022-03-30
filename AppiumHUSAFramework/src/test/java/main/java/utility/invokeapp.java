package main.java.utility;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.commonComponents.Commoncomponents;
import main.java.testcase.Testcase;
import main.java.utility.Projectcommonmethodes;

public class invokeapp extends Projectcommonmethodes{
	
	
	@BeforeClass
	public void getbrowser() throws IOException {
		String Testtypebrowser= Commoncomponents.getdata("BrowserType", "Browser");
		browser = Testtypebrowser;
	}
	
	@Test 
	(dataProvider = "fetchData")	
	public void TestCase(String Testcasenumber, String Description,String Execute,String ExecutionTime,String Status) throws Exception {
		Testcase.getsetData(Testcasenumber,Description,Execute);
}
}
