package org.testing;

import org.openqa.selenium.By;
import org.utility.Utility;

public class Facebook extends Utility {
	public static void main(String[] args) throws InterruptedException {
		Utility u = new Utility();
		u.getChromeDriver();
		u.enterUrl("https://www.facebook.com/");
		u.title();
		u.getUrl();
		u.sendText(u.byId("email"), "Tamil");
		Thread.sleep(3000);
		u.twoClick(u.byId("email"));
		u.keyCopy();
		u.keypaste();
		
			
	}

}
