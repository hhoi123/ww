package pageobject;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ConifgReaderUtils;
import utils.Readxlsx;


public class loginpagePO extends BaseClass {
	Readxlsx Readxlsx1=new Readxlsx();
	String s;
	WebElement e;
	By loginbutton= By.xpath("//button[@class=\"login\"]");
	public By emailfield=By.xpath("//input[@name=\"email\"]");
	public By passwordfield=By.xpath("//input[@name=\"password\"]");
	public By signinbutton=By.xpath("//input[@value=\"Sign In\"]");
	By welcomecustomerlabel=By.xpath("(//div[@class=\"_loginSection\"])[2]");
	By cafelabel=By.xpath("//div[@id=\"CafeName\"]");
	By emailwrongmsg=By.xpath("//div[@id=\"msg\"]");
	
	public void loginfunctionalitywithvaliddata() throws InterruptedException {
		
		thread();
		click(loginbutton);
		
		fillvalues(emailfield,obj.getdata("username1"));
		fillvalues(passwordfield,obj.getdata("password1"));
		click(signinbutton);
	}
	public boolean welcomecustomerlabel() {
		return Iselementdisplay(welcomecustomerlabel);
	}
	
	public void loginfunctionalitywithinvaliddata() throws InterruptedException {
		thread();
		click(loginbutton);
		fillvalues(emailfield,obj.getdata("username2"));
		fillvalues(passwordfield,obj.getdata("password2"));
		click(signinbutton);
	}
	
	public String emailwrongmsg() {
		 e=driver.findElement(emailwrongmsg);
		s=e.getText();
		return s;
	}
	public void emailcorrectwrongpassword() throws InterruptedException {
		thread();
		click(loginbutton);
		fillvalues(emailfield,obj.getdata("username3"));
		fillvalues(passwordfield,obj.getdata("password3"));
		click(signinbutton);
	}
	public void emailwrongpasswordcorrect() throws InterruptedException {
		thread();
		click(loginbutton);
		fillvalues(emailfield,obj.getdata("username4"));
		fillvalues(passwordfield,obj.getdata("password4"));
		click(signinbutton);
	}
	public void verifyloginfunctionalitythroughexcelsheet(int x) throws IOException, InterruptedException {
		thread();
		click(loginbutton);
	HashMap<String,String> m=	Readxlsx1.datafromexcelsheet(x);
		fillvalues(emailfield,m.get("username"));
		fillvalues(passwordfield,m.get("password"));
		click(signinbutton);
	}

}
