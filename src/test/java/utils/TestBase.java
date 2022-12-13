package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
			prop.load(fis);
			System.out.println(prop.getProperty("browser"));
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("target/Spark.html");
			extent.attachReporter(spark);
			test = extent.createTest("Validations");
		} catch (IOException e) {
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

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
