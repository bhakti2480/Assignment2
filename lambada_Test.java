package PO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import XlogisticReport.ExtentReport;

public class lambada_Test {
	WebDriver driver;
	public lambada_Test(WebDriver driver)
	{
		this.driver=driver;
	}
	//login
	@FindBy(how=How.ID,using="name")
	WebElement Fullname;

	@FindBy(how=How.ID,using="email")
	WebElement Email;
	
	@FindBy(how=How.ID,using="userpassword")
	WebElement password;
	@FindBy(how=How.ID,using="phone")
	WebElement phn_no;
	//checkbox
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/samp")
	WebElement chkbox;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/button")
	WebElement submit;
	public void fullname(String args)
	{
		Fullname.clear();
		Fullname.sendKeys(args);
		ExtentReport.test.log(LogStatus.INFO, "Full name",args);
	}
	public void email(String args)
	{
		Email.clear();
		Email.sendKeys(args);
		ExtentReport.test.log(LogStatus.INFO, "Enter Confirm mail",args);
	}
	public void password(String args)
	{
		password.clear();
		password.sendKeys(args);
		ExtentReport.test.log(LogStatus.INFO, "Enter Password",args);
	}
	public void phn_no(String args)
	{
		phn_no.clear();
		phn_no.sendKeys(args);
		ExtentReport.test.log(LogStatus.INFO, "Enter phone number",args);
	}
	public void checkbox()
	{
		chkbox.click();
		ExtentReport.test.log(LogStatus.INFO, "Click check box","Clicked checked box");
	}
	public void submit()
	{
		submit.click();
		ExtentReport.test.log(LogStatus.INFO, "click submit button","Clicked check box");
	}
	public void valid_data(String fnm,String email,String password,String phn)
	{
		fullname(fnm);
		email(email);
		password(password);
		phn_no(phn);
		checkbox();
		submit();
		 //JavascriptExecutor js=(JavascriptExecutor) driver;
		
	}
	public void Invalid_data(String fnm,String email,String password,String phn)
	{
		fullname(fnm);
		email(email);
		password(password);
		phn_no(phn);
		checkbox();
		submit();
		// JavascriptExecutor js=(JavascriptExecutor) driver;
	}
	public void Blank_data(String fnm,String email,String password,String phn)
	{
		fullname(fnm);
		email(email);
		password(password);
		phn_no(phn);
		checkbox();
		submit();
		 //JavascriptExecutor js=(JavascriptExecutor) driver;
	}
	
}
