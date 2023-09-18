package pageobject;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Readxlsx;




public class SignUpPagePO extends BaseClass {
	Readxlsx Readxlsx2=new Readxlsx();
	HashMap<String,String> m1;
	WebElement e;
	By loginbutton= By.xpath("//button[@class=\"login\"]");
	By ragisternow=By.xpath("//a[contains(.,'Register Now')]");
	By emailfield=By.xpath("//input[@name=\"email\"]");
	By confirmemailfield=By.xpath("//input[@name=\"emaill\"]");
	By passwordfield=By.xpath("//input[@name=\"password\"]");
	By confirmpasswordfield=By.xpath("//input[@name=\"ConfirmPassword\"]");
	By signupbtn=By.xpath("//input[@id=\"btnSignUp\"]");
	By confirmmsgokbtn=By.xpath("(//button[@data-dismiss=\"modal\"])[1]");
	By yopmailemailfield=By.xpath("//input[@placeholder=\"Enter your inbox here\"]");
	By arrowsign=By.xpath("//button[@class=\"md\"]");
	By activationlink=By.xpath("//a[contains(.,\"http://marketgoalqa.takeout7.com\")]");
	By signinbutton=By.xpath("//input[@value=\"Sign In\"]");
	By welcomecustomerlabel=By.xpath("(//div[@class=\"_loginSection\"])[2]");
	By errormsg=By.xpath("//div[@id=\"msg\"]");
	By mendotoryfields=By.xpath("//div[@class=\"invalid-feedback\"]");
	By emailvalidation = By.xpath("(//div[@class=\"invalid-feedback\"])[1]");
	By confirmemailvalidation = By.xpath("(//div[@class=\"invalid-feedback\"])[2]");
	By passwordvalidation = By.xpath("(//div[@class=\"invalid-feedback\"])[3]");
	By confirmpasswordvalidation =  By.xpath("(//div[@class=\"invalid-feedback\"])[4]");
	HashMap<String,String>hm=new HashMap<String,String>();
	
	public void signupfunctionality() throws InterruptedException {
		thread();
		click(loginbutton);
		explicitweight(ragisternow);
		click(ragisternow);
		fillvalues(emailfield,obj.getdata("emailfield"));
		fillvalues(confirmemailfield,obj.getdata("emailfield"));
		fillvalues(passwordfield,obj.getdata("passwordfield"));
		fillvalues(confirmpasswordfield,obj.getdata("passwordfield"));
		click(signupbtn);
		thread();
		click(confirmmsgokbtn);

	}
	public void windowswitch() throws InterruptedException {
		driver.get("https://yopmail.com/");
		String parent=driver.getWindowHandle();
		fillvalues(yopmailemailfield,obj.getdata("emailfield"));
		click(arrowsign);
		driver.switchTo().frame("ifmail");
		thread();
		click(activationlink);
		HashSet<String>s=(HashSet<String>) driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
		{
        String child_window=I1.next();
        if(!parent.equals(child_window))
		{
			thread();
		driver.switchTo().window(child_window);
		thread();
		driver.switchTo().alert().accept();
		thread();
		}}}
	
         public void login() throws InterruptedException {
        	 thread();
        	 click(loginbutton);
        	 fillvalues(emailfield,obj.getdata("emailfield"));
        	 fillvalues(passwordfield,obj.getdata("passwordfield"));
        	 click(signinbutton);


}
         public boolean customerlabel() {
        return	 Iselementdisplay(welcomecustomerlabel);
        	 
        	 }
         public void signupwithexistcredentials() throws InterruptedException {
        	 thread();
        	 click(loginbutton);
        		click(ragisternow);
        		fillvalues(emailfield,obj.getdata("emailfield1"));
        		fillvalues(confirmemailfield,obj.getdata("emailfield1"));
        		fillvalues(passwordfield,obj.getdata("passwordfield1"));
        		fillvalues(confirmpasswordfield,obj.getdata("passwordfield1"));
        		click(signupbtn);
         }
         
         public String errormsgdisplay() {
        	e= driver.findElement(errormsg);
        	String s1=e.getText();
        	return s1;
         }
         
         public void signupfunctionalitywithexcelsheet(int y) throws InterruptedException, IOException {
        	 thread();
     		click(loginbutton);
     		explicitweight(ragisternow);
     		click(ragisternow);
     		 m1=	Readxlsx2.datafromexcelsheet(y);
     		fillvalues(emailfield,m1.get("username"));
     		fillvalues(confirmemailfield,m1.get("username"));
     		fillvalues(passwordfield,m1.get("password"));
     		fillvalues(confirmpasswordfield,m1.get("password"));
     		click(signupbtn);
         }
         public void windowswitchforexcelsheet() throws InterruptedException {
     		driver.get("https://yopmail.com/");
     		String parent=driver.getWindowHandle();
     		fillvalues(yopmailemailfield,m1.get("username"));
     		click(arrowsign);
     		driver.switchTo().frame("ifmail");
     		click(activationlink);
     		HashSet<String>s=(HashSet<String>) driver.getWindowHandles();
             Iterator<String> I1= s.iterator();
             while(I1.hasNext())
     		{
             String child_window=I1.next();
             if(!parent.equals(child_window))
     		{
     			thread();
     		driver.switchTo().window(child_window);
     		driver.switchTo().alert().accept();
     		thread();
     		}}}
         
         public void loginforexcelsheet() throws InterruptedException {
        	 thread();
        	 click(loginbutton);
        	 fillvalues(emailfield,m1.get("username"));
        	 fillvalues(passwordfield,m1.get("password"));
        	 click(signinbutton);


}
         
         public void mendotoryfields() throws InterruptedException {
        	 thread();
        	 click(loginbutton);
        	 thread();
        	 click(ragisternow);
        WebElement w1=	 driver.findElement(By.xpath("(//div[@class=\"invalid-feedback\"])[1]"));
        WebElement w2= driver.findElement(By.xpath("(//div[@class=\"invalid-feedback\"])[2]"));
        		WebElement w3= driver.findElement(By.xpath("(//div[@class=\"invalid-feedback\"])[3]"));
        		WebElement w4= driver.findElement(By.xpath("(//div[@class=\"invalid-feedback\"])[4]"));
        		String s1=w1.getText();
        		String s2=w2.getText();
        		String s3=w3.getText();
        		String s4=w4.getText();
        	 
//        	 click(signupbtn);
//        	 List<WebElement>list=driver.findElements(By.xpath("//div[@class=\"invalid-feedback\"]"));
//        	
//        	 hm.put("(//div[@class=\"invalid-feedback\"])[1]", "Please enter your email");
//        	 hm.put("(//div[@class=\"invalid-feedback\"])[2]", "Please enter your email");
//        	 hm.put("(//div[@class=\"invalid-feedback\"])[3]", "Please enter your password");
//        	 hm.put("(//div[@class=\"invalid-feedback\"])[4]", "Please enter your password");
//        	
//        	
//        	 for(Map.Entry<String, String>m:hm.entrySet()) {
//        		 for(WebElement w:list)
//        		 if(w.getText()==m.getValue()) {
//        			 return true;
//        		 }
//        	 }
//			return false;
        		
        	 
         }}
