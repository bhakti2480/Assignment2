package test_Case;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PO.Pysist_Update;
import PO.lambada_Test;
import Utility.BrowserManager;
import XlogisticReport.ExtentReport;

public class lambada_TestCase {
	WebDriver driver;//to initialize the browser
	JSONObject lambada; //to create json obj to read data
	@BeforeClass
	public void beforClass() throws Exception //test case for class to 
	{
		ExtentReport.startreport();
		  InputStream datais=null;
		  try {
			  String dataFileName="data/lambada.json";
			  datais=getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener=new JSONTokener(datais);
			  lambada=new JSONObject(tokener);
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
			  throw e;
		  }
		  finally {
			  if(datais!=null)
			  {
				  datais.close();
			  }
		  }
		  
	}
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setup(String browser,String url)
	{
		driver=BrowserManager.getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void InValid_data() throws InterruptedException
	{
		String fnm=lambada.getJSONObject("InValid_data").getString("fnm");
		String email=lambada.getJSONObject("InValid_data").getString("email");
		String password=lambada.getJSONObject("InValid_data").getString("password");
		String phn=lambada.getJSONObject("InValid_data").getString("phn");
		ExtentReport.test=ExtentReport.extent.startTest("SignIn with Invalid data");
		
		lambada_Test obj=PageFactory.initElements(driver, lambada_Test.class);
		obj.Invalid_data(fnm, email, password, phn);
		Thread.sleep(3000);
		driver.close();
	}
	@Test(priority=2)
	public void Blank_data() throws InterruptedException
	{
		String fnm=lambada.getJSONObject("Blank_data").getString("fnm");
		String email=lambada.getJSONObject("Blank_data").getString("email");
		String password=lambada.getJSONObject("Blank_data").getString("password");
		String phn=lambada.getJSONObject("Blank_data").getString("phn");
		
		ExtentReport.test=ExtentReport.extent.startTest("SignIn with Blank data");
		lambada_Test obj=PageFactory.initElements(driver, lambada_Test.class);
		obj.Blank_data(fnm, email, password, phn);
		Thread.sleep(3000);
		driver.close();
	}
	@Test(priority=3)
	public void Valid_data() throws InterruptedException
	{
		String fnm=lambada.getJSONObject("Valid_data").getString("fnm");
		String email=lambada.getJSONObject("Valid_data").getString("email");
		String password=lambada.getJSONObject("Valid_data").getString("password");
		String phn=lambada.getJSONObject("Valid_data").getString("phn");
		
		ExtentReport.test=ExtentReport.extent.startTest("SignIn with Valid data");
		lambada_Test obj=PageFactory.initElements(driver, lambada_Test.class);
		obj.valid_data(fnm, email, password, phn);
		Thread.sleep(3000);
		driver.close();
	}
	@AfterClass
	public void endReport()
	{
		ExtentReport.extent.flush();
		
	}
	@AfterMethod
	public void teardown()
	{
		ExtentReport.extent.endTest(ExtentReport.test);;
	}
}
