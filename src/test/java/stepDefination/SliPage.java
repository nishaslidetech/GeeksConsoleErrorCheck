package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import setupClass.BaseClass;

public class SliPage extends BaseClass {
	WebElement search_field;

	@Given("^user is on the home page now$")
	public void user_is_on_the_home_page_now() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		ClearBrowserCache1();
		Thread.sleep(3000);
		log.info("It's opening the website URL");

	}

	@Then("^Enter data in search field and cehck the console error$")
	public void enter_data_in_search_field_and_cehck_the_console_error() throws Throwable {
		try {
			Thread.sleep(3000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(3000);

			checkConsoleError();

			// click on "hr report" in left navigation

			WebElement hr_Budget = wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector(".sli_ac_suggestions >ul >li:nth-child(6)")));
			hr_Budget.click();
			Thread.sleep(3000);
			checkConsoleError();

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("Software");
			Thread.sleep(3000);
			checkConsoleError();
			search_field.clear();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Go to the sli listing page and check the console error$")
	public void go_to_the_sli_listing_page_and_check_the_console_error() throws Throwable {
		// div[@class = 'container listing-container sli_generic_container']//ul//li[4]
		driver.navigate().refresh();
		System.out.println("url = " + driver.getCurrentUrl() );
		Thread.sleep(4000);
		List<WebElement> selectPpt = driver.findElements(By.xpath("//div[@class = 'box-top sli_image']"));
		selectPpt.get(0).click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
		Thread.sleep(3000);
		
		System.out.println("url = " + driver.getCurrentUrl() );
	}

	@Then("^Click on pagination number and check the console error for two page only for sli pages$")
	public void Click_on_pagination_number_and_check_the_console_error_for_two_page_only_for_sli_pages()
		throws Throwable {
		List<WebElement> sizeofPagination = driver
				.findElements(By.xpath("//div[@class='product-info sli_generic_container']//ul//li"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			for (int i = 1; i < sizeofPagination.size();) {

				if (!driver
						.findElements(By.xpath(
								"//div[@class='product-info sli_generic_container']//a[@class = 'sli_next_page']"))
						.isEmpty()) {

					WebElement nextButton = driver.findElement(By
							.xpath("//div[@class='product-info sli_generic_container']//a[@class = 'sli_next_page']"));
					nextButton.click();

					Thread.sleep(3000);
					checkConsoleError();
					Thread.sleep(3000);

				} else

				{
					break;
				}

			}
		} else {
			System.out.println("No pagination exists");
		}
	}

}
