package stepDefination;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setupClass.BaseClass;

public class eBooks extends BaseClass {
	WebElement dropDown;
	WebElement selecteBook;
	Select sortBy;
	WebElement selectValue;
	List<WebElement> selecteBooks;

	@Given("^user is the on home page$")
	public void user_is_the_on_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on eBooks text and check console error$")
	public void click_on_eBooks_text_and_check_console_error() throws Throwable {

		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("EBOOKS")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		selecteBooks = driver.findElements(By.cssSelector(".ebook-container >div >a >img"));
		selecteBooks.get(1).click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();

	}

	@Then("^select option from sort By and check the console error$")
	public void select_option_from_sort_By_and_check_the_console_error() throws Throwable {

		try {

			Thread.sleep(3000);
			dropDown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-sortBooks-container']")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement selectValue = wait.until(ExpectedConditions.elementToBeClickable(By.id("sortBooks")));
			sortBy = new Select(selectValue);

			sortBy.selectByVisibleText("New & Popular");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error selecteBooks =
			driver.findElements(By.cssSelector(".ebook-container >div >a >img"));
			selecteBooks.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			// again select dropdown list

			Thread.sleep(3000);
			dropDown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-sortBooks-container']")));
			dropDown.click();
			Thread.sleep(3000);

			selectValue = wait.until(ExpectedConditions.elementToBeClickable(By.id("sortBooks")));
			sortBy = new Select(selectValue);
			sortBy.selectByVisibleText("Name");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error selecteBooks =
			driver.findElements(By.cssSelector(".ebook-container >div >a >img"));
			selecteBooks.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (WebDriverException e) {
		}

	}

	@Then("click on buy now button and check console error")
	public void click_on_buy_now_button_and_check_console_error() throws InterruptedException, IOException {
		List<WebElement> buyNow = driver.findElements(By.cssSelector(".form_buynow >a"));
		buyNow.get(1).click();
		Thread.sleep(3000);
		checkConsoleError();

		// verify the pop-up
		String pop_UP = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cd-user-modal-container >h4")))
				.getText();
		System.out.println("pop_UP=  " + pop_UP);
	}

	@Then("Enter paid user name {string} and password {string}")
	public void enter_paid_user_name_and_password(String username, String password) throws Throwable {
		try {
			Thread.sleep(3000);
			 ClearBrowserCache1();
			 Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']//i")));
			sign_in.click();
		} catch (NoSuchElementException e) {

		}
		try {

			Thread.sleep(3000);
			WebElement email = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
			email.sendKeys(username);

			WebElement password_field = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			password_field.sendKeys(password);
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
			login_btn.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}

		System.out.println(driver.getTitle() + "Title");
	}

	@Then("verify that user should be on suscription page")
	public void verify_that_user_should_be_on_suscription_page() throws InterruptedException, IOException {
		// System.out.println(driver.getTitle() + "Title");
		String Expected_Title = "Account Dashboard";
		Assert.assertEquals(driver.getTitle(), Expected_Title);
		checkConsoleError();
	}

	@Then("^Logout from the application and verify the page$")
	public void logout_from_the_application_and_verify_the_page() throws Throwable {
		// sign out from the application
		try {
			Thread.sleep(2000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			sign_Out.click();
		} catch (NoSuchElementException e) {

		}

	}
}
