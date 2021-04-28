package org.testing;

import org.utility.Utility;

public class Flipkart{
	public static void main(String[] args) throws InterruptedException {
		Utility u = new Utility();
		u.getChromeDriver();
		u.enterUrl("https://www.flipkart.com/");
		u.title();
		u.getUrl();
		Thread.sleep(3000);
		u.btnClk(u.byXpath("//button[@class='_2KpZ6l _2doB4z']"));
		u.moveToElement(u.byXpath("//div[text()='Appliances']"));
		u.moveToElement(u.byXpath("//a[@class='_6WOcW9 _2-k99T']"));
		u.btnClk(u.byXpath("(//a[@class='_6WOcW9 _3YpNQe'])[1]"));
		Thread.sleep(3000);
		u.sendText(u.byName("q"), "iphone");
		u.twoClick(u.byName("q"));
//		(u.byXpath("(//a[@class='s1Q9rs'])[1]"));
		
		
			
	}


}
