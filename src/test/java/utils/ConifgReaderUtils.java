package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConifgReaderUtils {
	Properties pro;
	public Object readdata(String key) throws IOException {
		
		 pro = new Properties();
		FileInputStream fp= new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\newframework\\config.properties");
		pro.load(fp);
		return  pro.get(key);
	}
         public String getdata(String a) {
        	 String data =pro.getProperty(a);
        			 if(data!=null) {
        				 return data;
        			 }else {
       					throw new RuntimeException("data is not specified in config file");
        					}
         }


}
	
//	public String getusername1() {
//		
//		String username1= pro.getProperty("username1");
//		if(username1!=null) {
//			return username1;
//		}
//		else {
//			throw new RuntimeException("usename1 is not specified in config file");
//		}
//	}
//	public String getpassword1() {
//		String password1= pro.getProperty("password1");
//		if(password1!=null) {
//			return password1;
//		}
//		else {
//			throw new RuntimeException("password1 is not specified in config file");
//		}
//	}
//	public String getusername2() {
//		String username2= pro.getProperty("username2");
//		if(username2!=null) {
//			return username2;
//		}
//		else {
//			throw new RuntimeException("usename2 is not specified in config file");
//		}
//
//}
//	public String getpassword2() {
//		String password2= pro.getProperty("password2");
//		if(password2!=null) {
//			return password2;
//		}
//		else {
//			throw new RuntimeException("password2 is not specified in config file");
//		}
//	}
//	public String getusername3() {
//		String username3= pro.getProperty("username3");
//		if(username3!=null) {
//			return username3;
//		}
//		else {
//			throw new RuntimeException("usename3 is not specified in config file");
//		}
//
//}
//	public String getpassword3() {
//		String password3= pro.getProperty("password3");
//		if(password3!=null) {
//			return password3;
//		}
//		else {
//			throw new RuntimeException("password3 is not specified in config file");
//		}
//	}
//	public String getusername4() {
//		String username4= pro.getProperty("username4");
//		if(username4!=null) {
//			return username4;
//		}
//		else {
//			throw new RuntimeException("usename4 is not specified in config file");
//		}
//
//}
//	public String getpassword4() {
//		String password4= pro.getProperty("password4");
//		if(password4!=null) {
//			return password4;
//		}
//		else {
//			throw new RuntimeException("password4 is not specified in config file");
//		}
//	}}
