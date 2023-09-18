package testsuite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.SignUpPagePO;

public class SignUpPageTest extends SignUpPagePO {
	String s1="The email address you have entered is already registered. Please use the same email address and password to login.";
	
	@Test(description="Verify SignUp Functionality with properties file",priority=1,enabled=false)
	public void test1() throws InterruptedException {
		signupfunctionality();
		windowswitch();
		login();
		customerlabel();
		Assert.assertTrue(customerlabel());
		}
@Test(description="Verify SignUp functionality with exist credentials with properties file",priority=2,enabled=false)
public void test2() throws InterruptedException {
	signupwithexistcredentials();
	errormsgdisplay();
	Assert.assertEquals(errormsgdisplay(), s1);
	
}
@Test(description="Verify mendotory fields", priority=3, enabled=false)
public void test33() throws InterruptedException {
	
	mendotoryfields();
	

	
		
	}
@Test(description="Verify SignUp Functionality with excel sheet",priority=1, enabled=true)
public void test3() throws InterruptedException, IOException {
	test=reports.createTest("Verify SignUp Functionality with excel sheet");
	signupfunctionalitywithexcelsheet(5);
	windowswitchforexcelsheet();
	loginforexcelsheet();
	customerlabel();
	Assert.assertTrue(customerlabel());
	
}
@Test(description="Verify SignUp functionality with exist credentials with excel sheet",priority=2,enabled=true)
public void test4() throws InterruptedException, IOException {
	test=reports.createTest("Verify SignUp functionality with exist credentials with excel sheet");
	signupfunctionalitywithexcelsheet(6);
	errormsgdisplay();
	Assert.assertEquals(errormsgdisplay(), s1);
	
}
	
	
}

