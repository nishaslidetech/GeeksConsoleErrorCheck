package stepDefination;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setupClass.BaseClass;

public class NewAdditions extends BaseClass {
	@When("Go to Geeks Home page")
	public void Go_to_Geeks_Home_page() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
	}

	@Then("check console error for New Additions")
	public void check_console_error_for_new_additions() throws InterruptedException, IOException {
		try {
			WebElement newAdditions = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("NEW ADDITIONS")));
			js.executeScript("arguments[0].scrollIntoView();", newAdditions);
			newAdditions.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on any of PPt and check the console error")
	public void click_on_any_of_p_pt_and_check_the_console_error() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			List<WebElement> select_ppt = driver.findElements(By.cssSelector(".box-top >img"));
			select_ppt.get(1).click();
			checkConsoleError();
			driver.navigate().back();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("click on pagination number and check the console error for two page only")
	public void click_on_pagination_number_and_check_the_console_error_for_two_page_only()
			throws InterruptedException, IOException {
		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[@class = 'product-info']//ul//li"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			for (int j = 1; j < 6; j++) {
				if (!driver.findElements(By.xpath("//div[@class = 'product-info']//a[@title = 'Next']")).isEmpty()) {

					WebElement nextButton = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//div[@class = 'product-info']//a[@title = 'Next']")));
					// js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
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
	}

	@Then("check console error for visual Search")
	public void check_console_error_for_visual_search() throws InterruptedException, IOException {
		// VISUAL SEARCH
		try {
			WebElement visualSearch = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("VISUAL SEARCH")));
			js.executeScript("arguments[0].scrollIntoView();", visualSearch);
			visualSearch.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
