package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class HomePage extends BaseClass {
	static String errorLog;

	@Given("^Go the Home page$")
	public void go_the_Home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^check console error for Home page$")
	public void check_console_error_for_Home_page() throws Throwable {

		Thread.sleep(3000);
		checkConsoleError();
	}

	@Then("^click on Login button and check console errors$")
	public void click_on_Login_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement login = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));
			login.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on Signup button and check console errors$")
	public void click_on_Signup_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_up = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='signupclass']")));
			sign_up.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the console error for the top navigation links$")
	public void check_the_console_error_for_the_top_navigation_links() throws Throwable {
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement pricing = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PRICING")));
			pricing.click();
			Thread.sleep(3000);
			checkConsoleError();
			// driver.navigate().back();

			WebElement visualSearch = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("VISUAL SEARCH")));
			visualSearch.click();
			Thread.sleep(3000);
			checkConsoleError();
			// driver.navigate().back();

			WebElement discussion = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("DISCUSSION")));
			discussion.click();
			checkConsoleError();
			Thread.sleep(3000);
			// driver.navigate().back();

		} catch (NoSuchElementException e) {

		}
	}

}
