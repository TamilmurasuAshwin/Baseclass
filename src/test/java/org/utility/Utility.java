package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static WebDriver driver;
	public static Robot rb;
	static Select sl;
	static Actions ac ;
	static Alert al;
	
	public void getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	public void enterUrl(String Url) {
		driver.get(Url);
			}
	public String title() {
		String title = driver.getTitle();		
		System.out.println(title);
		return title;
	}
	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;

	}
	public WebElement byId(String id) {
		WebElement e = driver.findElement(By.id(id));
		return e;
		}
	public WebElement byName(String name) {
		WebElement e = driver.findElement(By.name(name));
		return e;
		}
	public WebElement byXpath(String xpath) {
		WebElement e = driver.findElement(By.xpath(xpath));
		return e;
		}
	public WebElement byClass(String classname) {
		WebElement e = driver.findElement(By.className(classname));
		return e;
		}
	public WebElement byTagname(String tagName) {
		WebElement e = driver.findElement(By.tagName(tagName));
		return e;
		}
	
	public void sendText(WebElement element, String txt) {
		element.sendKeys(txt);		
	}
	public String getText(WebElement element) {
		String a =element.getText();
		System.out.println(a);
		return a;
	}
	public String getAttribute(WebElement element) {
		String q =element.getAttribute("value");
		System.out.println(q);
		return q;
	}

	public void btnClk(WebElement element) {
		element.click();
	}
	//Action Class
	
	
	public static void moveToElement(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void drag(WebElement src, WebElement dest) {
		ac.dragAndDrop(src, dest).perform();
	}
	
	public void rytClick(WebElement element) {
		ac.contextClick(element).perform();
	}
	
	public void twoClick(WebElement element) {
		ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}
	public void keyUpAndDownByAction(WebElement txtname,String txt) {
		ac = new Actions(driver);
		ac.keyDown(txtname, Keys.SHIFT).sendKeys(txtname,"txt").keyUp(txtname,Keys.SHIFT).perform();
		
	}
	
	//Select Class
	
	
	public WebElement selectByIndex(WebElement element, short i) {
		sl = new Select(element);
		sl.selectByIndex(i);
		return element;
	}
	public WebElement selectByValue(WebElement element, String s) {
		sl = new Select(element);
		sl.selectByValue(s);
		return element;
	}
	public WebElement selectByVisibleText(WebElement element, String s) {
		sl = new Select (element);
		sl.selectByVisibleText(s);
		return element;
	}
	
	public WebElement getfirstSelectedOption(WebElement element) {
		sl=new Select(element);
		WebElement s = sl.getFirstSelectedOption();
		String text = s.getText();
		System.out.println(text);
		return s;
		}
	
	public List<WebElement> getOptions(WebElement element) {
		sl = new Select(element);
		List<WebElement> options = sl.getOptions();
		System.out.println(options);
		return options;
	}
	
	public WebElement getoption(WebElement element) {
		String text = getfirstSelectedOption(element).getText();
		System.out.println(text);
		return element;	
	}
	
	public void deselectByIndex(WebElement element, int index) {
		sl= new Select(element);
		sl.deselectByIndex(index);
		}
	
	public WebElement deselectByValue(WebElement element, String s) {
		sl = new Select(element);
		sl.deselectByValue(s);
		return element;
	}
	
	public WebElement deselectByVisibleText(WebElement element, String s) {
		sl = new Select (element);
		sl.deselectByVisibleText(s);
		return element;
	}
	
	public void deselect(WebElement element) {
		sl= new Select(element);
		sl.deselectAll();
		}
	
	//JavaScriptExecutor
	
	static JavascriptExecutor executor;
	
	public void jsSettxt(WebElement element,String text) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguement[0].setAttribute('value','"+text+"')", element);
	}
	public void jsGettxt(WebElement element) {
		
		executor.executeScript("argument[0].getAttribute('value'", element);
		}
	public void scrollDown(WebElement element) {
		executor.executeScript("arguement[0].ScrollInto(true)", element);
		}
	public void scrollUp(WebElement element) {
		executor.executeScript("arguement[0].ScrollInto(false)", element);
		}
	
	// Robot
	
	
	public static void keyEnter() throws AWTException {
		rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public void keyUp() {
		rb.keyPress(KeyEvent.VK_UP);
		rb.keyRelease(KeyEvent.VK_UP);
	}
	public void keyDown() {
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
	}
	public void keyTab() {
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
	}
	public void keyControl() {
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void keyCopy() {
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);		
	}
	public void keypaste() {
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
			}
	public void keyMove() {
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_X);
		rb.keyRelease(KeyEvent.VK_X);
		rb.keyRelease(KeyEvent.VK_CONTROL);		
	}
	
	//Alert
	public void alertaccept() {
		al = driver.switchTo().alert();
		al.accept();
		}
	public void alertdismiss() {
		al.dismiss();
	}
	 public void promptalert() {
		 al.sendKeys("yes");
		 al.accept();
	}
	 //ScreenShot
	
	}	

