package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class MostDownload extends BaseClass {
	WebElement popular_Ppts;
	static String errorLog;
	WebElement viewPerPage;
	WebElement selectDropdown;
	WebElement filterByCategory;

	@Given("^user is already on home page$")
	public void user_is_already_on_home_page() throws Throwable {
		log.info("user is already on Home page");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on Popular ppts text and check console error$")
	public void click_on_Popular_ppts_text_and_check_console_error() throws Throwable {
		// click on Popular PPTs without login
		try {
			popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
			popular_Ppts.click();
			checkConsoleError();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error() throws Throwable {

		try {
			Thread.sleep(2000);
			WebElement select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			checkConsoleError();
			driver.navigate().back();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the pagination and check the console errorfor two pages only$")
	public void click_on_the_pagination_and_check_the_console_errorfor_two_pages_only() throws Throwable {

		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[2]/div[1]/div[1]/form[1]/ul/li/a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			for (int j = 1; j < 6; j++) {
				if (!driver.findElements(By.xpath("//div[2]//div[1]//div[1]//form[1]//ul[1]//li[12]//a[1]//img"))
						.isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[2]//div[1]//div[1]//form[1]//ul[1]//li[12]//a[1]//img"));
					js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
					nextButton.click();

					Thread.sleep(3000);
					// print console error
					checkConsoleError();

				} else

				{
					break;
				}
			}
		} else {
			System.out.println("No pagination exists");
		}

		/*
		 * // implemented infinite scrolling
		 * 
		 * long intialLength = (long)
		 * js.executeScript("return document.body.scrollHeight"); while (true) {
		 * js.executeScript("window.scrollBy(0,10500)", ""); checkConsoleError(); if
		 * (!(driver.findElements(By.
		 * xpath("//em[normalize-space()='Loading - please wait...']")).isEmpty())) {
		 * try { WebElement loader = driver
		 * .findElement(By.xpath("//em[normalize-space()='Loading - please wait...']"));
		 * js.executeScript("arguments[0].scrollIntoView();", loader);
		 * Thread.sleep(5000); checkConsoleError(); } catch (NoSuchElementException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } } if
		 * (!(driver.findElements(By.xpath("//button[@type='submit']")).isEmpty())) {
		 * try { WebElement loadMorePPT =
		 * driver.findElement(By.xpath("//button[@type='submit']"));
		 * js.executeScript("arguments[0].scrollIntoView();", loadMorePPT);
		 * loadMorePPT.click(); Thread.sleep(5000); checkConsoleError(); } catch
		 * (NoSuchElementException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * long currentLength = (long)
		 * js.executeScript("return document.body.scrollHeight"); //
		 * System.out.println("currentLength = " + currentLength); if (intialLength ==
		 * currentLength) { // System.out.println("intialLength 1 = " + currentLength);
		 * // System.out.println("currentLength 1 = " + currentLength); break; }
		 * intialLength = currentLength;
		 * 
		 * }
		 */
	}

	@Then("^click on the show page and check the console error$")
	public void click_on_the_show_page_and_check_the_console_error() throws Throwable {

		Thread.sleep(4000);

		WebElement select100 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='product-info']//a[contains(text(),'100')]")));
		select100.click();

		// print console error
		checkConsoleError();

		WebElement select200 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='product-info']//a[contains(text(),'200')]")));
		select200.click();

		Thread.sleep(2000); // print console error
		checkConsoleError();

	}

}
