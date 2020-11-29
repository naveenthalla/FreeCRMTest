package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
	Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	
	@Test(priority = 2)
	public void singleSelectContactList() {
		contactsPage.selectContactsByName("abcd efgh");
		System.out.println("clicked on checkbox");
	}
	
	@Test(priority = 3)
	public void multipleSelectContactList() {
		contactsPage.selectContactsByName("abcd efgh");
		contactsPage.selectContactsByName("selenium user");
		System.out.println("clicked on checkbox");
	}
	
	@DataProvider
	public void getTestData() {
		
	}
	
	@Test(priority = 4)
	
	public void validateCreateNewContact() {
		homePage.clickOnNewContactLink();
		
		contactsPage.createNewContact("Mr.","John", "M", "AWS");
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
