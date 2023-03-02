package stepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setupClass.BaseClass;

public class FooterLinks extends BaseClass {

	@When("Go to the Geeks Home page")
	public void Go_to_the_Geeks_Home_page() throws Throwable {

		driver.get(AppURL);
		ClearBrowserCache();
		log.info("It's opening the website URL");
		Thread.sleep(5000);
	}

	@Then("click on about us link and check the console errors")
	public void click_on_about_us_link_and_check_the_console_errors() throws InterruptedException, IOException {
		try {
			WebElement aboutUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("About Us")));
			js.executeScript("arguments[0].scrollIntoView();", aboutUs);
			aboutUs.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on contact us link and check the console errors")
	public void click_on_contact_us_link_and_check_the_console_errors() throws InterruptedException, IOException {
		try {
			WebElement contactUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact us']")));
			js.executeScript("arguments[0].scrollIntoView();", contactUs);
			contactUs.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on Terms & conditions and check the console errors")
	public void click_on_terms_conditions_and_check_the_console_errors() throws InterruptedException, IOException {
		try {
			WebElement termConditions = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact us']")));
			js.executeScript("arguments[0].scrollIntoView();", termConditions);
			termConditions.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on coupon code link and check the console errors")
	public void click_on_coupon_code_link_and_check_the_console_errors() throws InterruptedException, IOException {
		try {
			WebElement coponCode = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Coupon Codes']")));
			js.executeScript("arguments[0].scrollIntoView();", coponCode);
			coponCode.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on FAQ link and check the console errors")
	public void click_on_faq_link_and_check_the_console_errors() throws InterruptedException, IOException {
		try {
			WebElement FAQ = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='FAQ']")));
			js.executeScript("arguments[0].scrollIntoView();", FAQ);
			FAQ.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on our design services link and check the console errors")
	public void click_on_our_design_services_link_and_check_the_console_errors()
			throws InterruptedException, IOException {
		try {
			WebElement designAndServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link'][normalize-space()='Design Services']")));
			js.executeScript("arguments[0].scrollIntoView();", designAndServices);
			designAndServices.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on Research services link and check the console errors")
	public void click_on_research_services_link_and_check_the_console_errors()
			throws InterruptedException, IOException {
		try {
			WebElement researchServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link'][normalize-space()='Research Services']")));
			js.executeScript("arguments[0].scrollIntoView();", researchServices);
			researchServices.click();
			checkConsoleError();
			Thread.sleep(3000);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
