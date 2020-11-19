package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	//ctrl+shift+o to import the dependencies
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage cotactsPage;
	
	public HomePageTest() {
		super();
	}
	//Test cases should be separated that is independent of each other
	//Before each test case--Launch the browser and login
	//@test--execute the test and 
	//after each test case close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
		
	}
	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserNameLabel());
		
	}
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		cotactsPage=homePage.clickOnContactsLink();
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}
