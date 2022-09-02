package stepDefination;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setupClass.BaseClass;

public class Blog extends BaseClass {
	static String errorLog;

	@Given("^Go to the Home page$")
	public void go_to_the_Home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
		
	}

	@Then("^check console error for Blog page$")
	public void check_console_error_for_Blog_page() throws Throwable {
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement blog = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("BLOG")));
			blog.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on any of blog and check the console error$")
	public void click_on_any_of_blog_and_check_the_console_error() throws Throwable {

		try {
			Thread.sleep(3000);
			List<WebElement> blogDetails = driver.findElements(
					By.linkText("READ MORE"));
			System.out.println(blogDetails.size() + "  = size");
			blogDetails.get(2).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();
			Thread.sleep(3000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
