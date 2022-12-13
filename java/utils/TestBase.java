package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	public TestBase(){
	
	  try {
		  prop= new Properties(); FileInputStream fis = new
		  FileInputStream(System.getProperty("user.dir")+"/config.properties");
		  prop.load(fis); System.out.println(prop.getProperty("browser")); extent = new
		  ExtentReports(); spark = new ExtentSparkReporter("target/Spark.html");
		  extent.attachReporter(spark);
		  test = extent.createTest("Validations");
	  } catch(IOException e) {
		  e.getMessage();
	  } 
	}
	 
	public static void initialization() throws IOException {

		String browserType = prop.getProperty("browser");
		System.out.println(browserType);
		if (browserType.equals("chrome")) {

			driver = new ChromeDriver();
		}
		
		driver.get("https://ngsmt.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

}
