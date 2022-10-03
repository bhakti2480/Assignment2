package Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserManager 
{
		public static WebDriver getDriver(String type)
		{
			WebDriver driver=null;
			if(type.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
			//	System.setProperty("webdriver.chrome.driver","C:\\BrowerDriver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(type.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			return driver;
		}
		
}
