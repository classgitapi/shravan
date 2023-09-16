package BaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BaseClass {
	
	
	public static WebDriver driver;
	public static void initialization() {
	
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\config.properties";
		
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	

}
