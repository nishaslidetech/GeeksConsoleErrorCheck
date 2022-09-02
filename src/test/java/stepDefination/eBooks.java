package stepDefination;

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

		WebElement selecteBook = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
		selecteBook.click();
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

			WebElement selectValue = driver.findElement(By.id("sortBooks"));
			sortBy = new Select(selectValue);

			sortBy.selectByVisibleText("New & Popular");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			// again select dropdown list
			Thread.sleep(3000);
			dropDown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-sortBooks-container']")));
			dropDown.click();
			Thread.sleep(3000);

			selectValue = driver.findElement(By.id("sortBooks"));
			sortBy = new Select(selectValue);
			sortBy.selectByVisibleText("Name");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			WebElement buyNow = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/a[1]")));
			buyNow.click();
			Thread.sleep(3000);
			checkConsoleError();
			// driver.navigate().back();

		} catch (WebDriverException e) {
		}

	}

	@Given("^Go to the home page$")
	public void go_to_the_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^Enter paid valid credentials$")
	public void enter_paid_valid_credentials() throws Throwable {
		try {
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
			email.sendKeys("nisha.dhiman@slidetech.in");

			WebElement password_field = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			password_field.sendKeys("Qwerty");
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
			login_btn.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on eBooks on the top navigation bar$")
	public void click_on_eBooks_on_the_top_navigation_bar() throws Throwable {
		Thread.sleep(5000);
		
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("EBOOKS")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		WebElement selecteBook = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
		selecteBook.click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
	}

	@Then("^Select option from sort By and check the console error$")
	public void Select_option_from_sort_By_and_check_the_console_error() throws Throwable {
		try {

			Thread.sleep(3000);
			dropDown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-sortBooks-container']")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement selectValue = driver.findElement(By.id("sortBooks"));
			sortBy = new Select(selectValue);

			sortBy.selectByVisibleText("New & Popular");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			// again select dropdown list
			Thread.sleep(3000);
			dropDown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-sortBooks-container']")));
			dropDown.click();
			Thread.sleep(3000);

			selectValue = driver.findElement(By.id("sortBooks"));
			sortBy = new Select(selectValue);
			sortBy.selectByVisibleText("Name");
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			WebElement buyNow = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/a[1]")));
			buyNow.click();
			Thread.sleep(3000);
			checkConsoleError();
			// driver.navigate().back();

		} catch (WebDriverException e) {
		}
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
