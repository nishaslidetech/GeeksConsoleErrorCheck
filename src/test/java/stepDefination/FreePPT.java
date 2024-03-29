package stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setupClass.BaseClass;

public class FreePPT extends BaseClass {
	private WebElement select_ppt;

	private WebElement freeSlides;

	WebElement business_ppt;
	static String errorLog;

	@Given("^user is already on Home page$")
	public void user_is_already_on_Home_page() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		log.info("user is already on Home page");
		BaseClass.ClearBrowserCache();
	}

	@Then("click on Free slides and check console error")
	public void click_on_free_slides_and_check_console_error() throws InterruptedException, IOException {
		try {
			Thread.sleep(4000);
			freeSlides = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FREE SLIDES")));
			freeSlides.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error for free user$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error_for_free_user() throws Throwable {
		try {
			Thread.sleep(3000);
			List <WebElement> select_ppt = driver.findElements(By.xpath("//a[@class = 'free_product_dow']//img"));
			select_ppt.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the pagination and check the console error$")
	public void check_the_pagination_and_check_the_console_error() throws Throwable {

		// this code was for pagination
		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[@class = 'product-info free_product-info']//ul//li"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do
				if (!driver.findElements(By.xpath("//div[@class='product-info free_product-info']//a[@title='Next']//img")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(
									By.xpath("//div[@class='product-info free_product-info']//a[@title='Next']//img"));
					js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
					nextButton.click();

					Thread.sleep(3000);
					// print console error
					checkConsoleError();

				} else

				{
					break;
				}

			while (true);
		} else {
			System.out.println("No pagination exists");
		}
		// infinite scrolling implemented

		/*
		 * long intialLength = (long)
		 * js.executeScript("return document.body.scrollHeight"); while (true) {
		 * js.executeScript("window.scrollBy(0,10500)", ""); checkConsoleError(); if
		 * (!(driver.findElements(By.
		 * xpath("//em[normalize-space()='Loading - please wait...']")).isEmpty())) {
		 * try { WebElement loader = driver
		 * .findElement(By.xpath("//em[normalize-space()='Loading - please wait...']"));
		 * js.executeScript("arguments[0].scrollIntoView();", loader);
		 * Thread.sleep(5000); checkConsoleError(); } catch (NoSuchElementException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * long currentLength = (long)
		 * js.executeScript("return document.body.scrollHeight");
		 * System.out.println("currentLength = " + currentLength); if (intialLength ==
		 * currentLength) { System.out.println("intialLength 1 = " + currentLength);
		 * System.out.println("currentLength 1 = " + currentLength); break; }
		 * intialLength = currentLength;
		 * 
		 * }
		 */
	}

}
