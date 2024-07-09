package task21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {

	public static void main(String[] args) {

		// open the Chrome driver using the web driver

		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.manage().window().maximize();

		// navigate to the URL

		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// Locating the top frame and switching to top frame
 
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));

		driver.switchTo().frame(topFrame);

		// verifying the size of the top frame

		if (driver.findElements(By.tagName("frame")).size() == 3) {

			System.out.println("Top frame as three Frames");
		}

		// Locating the left frame and switching to left frame

		WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));

		driver.switchTo().frame(leftFrame);

		// Locating the left frame text and verifying the text

		WebElement leftText = driver.findElement(By.xpath("(/html/body)[1]"));

		if (leftText.getText().equals("LEFT")) {

			System.out.println("Frame is switched to LEFT");

		} else {
			System.out.println("Not Switched");
		}

		// Switching back to top frame

		driver.switchTo().parentFrame();

		// Locating the middle frame adn switching to middle frame

		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));

		driver.switchTo().frame(middleFrame);

		// locating thee middle frame text and verifying the text

		WebElement middleText = driver.findElement(By.xpath("//div[@id='content']"));

		if (middleText.getText().equals("MIDDLE")) {

			System.out.println("Frame is switched to MIDDLE");

		} else {
			System.out.println("Not Switched");
		}

		// switching back to the top frame

		driver.switchTo().parentFrame();

		// Locating the right frame and switching to right frame

		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));

		driver.switchTo().frame(rightFrame);

		// locating the right frame text and verifying the text

		WebElement rightText = driver.findElement(By.xpath("/html/body"));

		if (rightText.getText().equals("RIGHT")) {

			System.out.println("Frame is switched to RIGHT");
		} else {
			System.out.println("Not Switched");
		}

		// switching back 

		driver.switchTo().defaultContent();

		// locating the bottom frame and switching to bottom frame

		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));

		driver.switchTo().frame(bottomFrame);

		// locating the boottom frame and verifying the bottom frame text

		WebElement bottomText = driver.findElement(By.xpath("/html/body"));

		if (bottomText.getText().equals("BOTTOM")) {

			System.out.println("Frame is switched to Bottom ");
		} else {
			System.out.println("Not Switched");
		}

		// switching back to top frame

		driver.switchTo().defaultContent();

		// printing the page source

		System.out.println(driver.getPageSource());
		
		System.out.println(driver.getCurrentUrl());

		// close & quit the browser

		driver.close();
		driver.quit();

	}

}

//Output:

/* Top frame as three Frames
Frame is switched to LEFT
Frame is switched to MIDDLE
Frame is switched to RIGHT
Frame is switched to Bottom 

https://the-internet.herokuapp.com/nested_frames
Page Title is not Frames */
