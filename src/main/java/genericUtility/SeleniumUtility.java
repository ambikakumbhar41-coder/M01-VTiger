package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This is an utility class which stores the Functionality from Selenium Library.
 * @author ambik
 * @version 26-03-26
 */

public class SeleniumUtility {
	/**
	 * This is a generic method to access the Web Application
	 * @param driver
	 * @param URL
	 */
	public void accessApplication(WebDriver driver,String URL) {
		driver.get(URL);
	}
	/**
	 * This is a generic method to refresh the Web Application
	 * @param driver
	 */
	public void refreshWebpage(WebDriver driver) {
		 driver.navigate().refresh();
	}
	
	/**
	 * This is a generic method to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This is generic method to give implicit wait
	 * @param driver
	 * @param maxTime
	 */
	
	public void implicitWait(WebDriver driver,int maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	
	/**
	 * This is generic method to wait for element explicity
	 * @param driver
	 * @param maxTime
	 * @param by
	 */
	
	public void waitForElemnetToBeVisisble(WebDriver driver,int maxTime,By by) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(maxTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	

	/////****** Mouse Action ******//////
	
	
	/**
	 * This is generic method to Scroll a web page
	 * @param driver
	 * @param element
	 */
	
	public void scrollingOpration(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This is a generic method to perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	
	public void mouseHovering(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This is generic method to perform double click operation on webelement
	 * @param driver
	 * @param element
	 */
	
	public void  doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/////***** DropDown *****////// 
	/**
	 * This is generic method to select an option in dropdown using value attribute
	 * @param dropdowmEle
	 * @param value
	 */
	
	public void selectOptionByValue(WebElement dropdownEle ,String value) {
		Select sel=new Select(dropdownEle);
		sel.selectByValue(value);
	}
	
	/**
	 *  This is generic method to select an option in dropdown using index
	 * @param dropdownEle
	 * @param index
	 */
 
	public void selectOptionByIndex(WebElement dropdownEle ,int index) {
		Select sel=new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	
	/**
	 * This is generic method to select an option in dropdown using visible text
	 * @param dropdownEle
	 * @param visibleText
	 */
	
	public void selectOptionByVisibleText(WebElement dropdownEle ,String visibleText) {
		Select sel=new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}
	
	
	///*** Frames ***///
	
	/**
	 * This is generic method to switch the control a frame.
	 * @param driver
	 * @param frameIndex
	 */
	
	public void switchToFrameUsingIndex(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
		
	}
	
	/**
	 * This is generic method to switch the control  inside  a frame.
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrameUsingnameOrId(WebDriver driver,String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This is generic method to switch the control  inside  a frame.
	 * @param driver
	 * @param frameEle
	 */
	
	public void switchToFrameUsingFrameEle(WebDriver driver,WebElement frameEle) {
		driver.switchTo().frame(frameEle);
	}
	
	//////***** Alert popup *****/////
	
	/**
	 * This is generic method to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This is generic method to cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	
	/////***** Multiple Window *****/////
	/**
	 * This is generic method to switch the control to 2nd Tab
	 * @param driver
	 */
	
	public void switchToSecondTab(WebDriver driver) {
		String pid=driver.getWindowHandle();
		Set<String> allIds=driver.getWindowHandles();
		for(String id:allIds) {
			if(!id.equals(pid)) {
				driver.switchTo().window(id);
			}
		}
	}
	
	///////*******  File Upload ********///////
	
	/**
	 * this is generic method to upload a file
	 * @param fileUploadEle
	 * @param filePath
	 */
	public void uploadFile(WebElement fileUploadEle,String filePath) {
		fileUploadEle.sendKeys(filePath);
	}
	
	
	/////***** Take Screenshot ******//////
	
	
	/**
	 * this is generic method to capture webpage screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String webpageScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();          // Used for Listeners
	}
	

}
