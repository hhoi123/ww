package testsuite;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.loginpagePO;

public class loginpageTest extends loginpagePO{
	String  s1="The email or password you entered is incorrect1";
	@Test(description="Verify Login Functionality with valid credentials with properties file", enabled=false)
	public void test1() throws InterruptedException {
		loginfunctionalitywithvaliddata();
		welcomecustomerlabel();
		Assert.assertTrue(welcomecustomerlabel());
		}
	@Test(description="Verify Login Functionality with invalid credentials with properties file",enabled=false)
	public void test2() throws InterruptedException {
		 loginfunctionalitywithinvaliddata();
		emailwrongmsg();
		Assert.assertEquals(emailwrongmsg(), s1);
		}
	@Test(description="Verify login Functionality with email correct and wrong password with properties file", enabled=false)
public void test3() throws InterruptedException {
		emailcorrectwrongpassword();
		emailwrongmsg();
		Assert.assertEquals(emailwrongmsg(), s1);
	}
	@Test(description="Verify login Functionality with email wrong and correct password with properties file",enabled=false)
	public void test4() throws InterruptedException {
		emailwrongpasswordcorrect();
		emailwrongmsg();
		Assert.assertEquals(emailwrongmsg(), s1);
		
	}
	@Test(description="Verify Login Functionality with valid credentials with excel sheet",priority=1,enabled=true)
	public void test5() throws IOException, InterruptedException {
		test=reports.createTest("Verify Login Functionality with valid credentials with excel sheet");
		verifyloginfunctionalitythroughexcelsheet(1);
		welcomecustomerlabel();
		Assert.assertTrue(welcomecustomerlabel());
	}
	@Test(description="Verify Login Functionality with invalid credentials with excel sheet", priority=2, enabled=true)
	public void test6() throws IOException, InterruptedException {
		test=reports.createTest("Verify Login Functionality with invalid credentials with excel sheet");
		verifyloginfunctionalitythroughexcelsheet(2);
		emailwrongmsg();
		Assert.assertEquals(emailwrongmsg(), s1);
		
	}
	@Test(description="Verify login Functionality with email correct and wrong password with excel sheet",priority=3,enabled=true)
	public void test7() throws IOException, InterruptedException {
		test=reports.createTest("Verify login Functionality with email correct and wrong password with excel sheet");
		verifyloginfunctionalitythroughexcelsheet(3);
		emailwrongmsg();
		Assert.assertEquals(emailwrongmsg(), s1);
	}
	@Test(description="Verify login Functionality with email wrong and correct password with excel sheet",priority=4, enabled=true)
	public void test8() throws IOException, InterruptedException {
		test=reports.createTest("Verify login Functionality with email wrong and correct password with excel sheet");
		verifyloginfunctionalitythroughexcelsheet(4);
		emailwrongmsg();
		 Assert.assertEquals(emailwrongmsg(), s1);
	}
		
	
}
