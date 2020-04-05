
package Steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utils.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps extends DriverFactory {
	@Given("^I access webdriveruniversity\\.com$")
	public void i_access_webdriveruniversity_com() throws Throwable {
		getDriver().get("http://www.webdriveruniversity.com");

	}

	@When("^I click on the contat us button$")
	public void i_click_on_the_contat_us_button() throws Throwable {
		getDriver().findElement(By.id("contact-us")).click();
	}

	@And("^I enter a firstname$")
	public void i_enter_a_firstname() throws Throwable {
		@SuppressWarnings("unused")
		String winHandlerBefore = getDriver().getWindowHandle();
	
		for(String winHandler: getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandler);
		}
		
		getDriver().findElement(By.name("first_name")).sendKeys("Marvin");
	    
	}

	@And("^I enter a lastname$")
	public void i_enter_a_lastname() throws Throwable {
		getDriver().findElement(By.name("last_name")).sendKeys("Calizo");
	    
	}

	@And("^I enter an email address$")
	public void i_enter_an_email_address() throws Throwable {
		getDriver().findElement(By.name("email")).sendKeys("marvssulit@gmail.com");
	}

	@And("^I enter comments$")
	public void i_enter_comments() throws Throwable {
		getDriver().findElement(By.name("message")).sendKeys("This is a Test");
	}

	@When("^I click the submit button$")
	public void i_click_the_submit_button() throws Throwable {
		getDriver().findElement(By.xpath(".//input[@type='submit']")).click();
	    
	}

	@Then("^The information should be successfully be submitted via contact us form$")
	public void the_information_should_be_successfully_be_submitted_via_contact_us_form() throws Throwable {
		Thread.sleep(3000);
		WebElement ThankYouMessage =  getDriver().findElement(By.xpath("//div[@id='contact_reply']"));
		Assert.assertEquals(true, ThankYouMessage.isDisplayed());
	    
	}
   
	@And("^I enter a invalid firstname$")
	public void i_enter_a_invalid_firstname() throws Throwable {
		@SuppressWarnings("unused")
		String winHandlerBefore = getDriver().getWindowHandle();
	
		for(String winHandler: getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandler);
		}
		Thread.sleep(4000);
		getDriver().findElement(By.name("first_name")).sendKeys("$#$%");
	}

	@And("^I enter a invalid lastname$")
	public void i_enter_a_invalid_lastname() throws Throwable {
		getDriver().findElement(By.name("last_name")).sendKeys("&^%%&*");
	}

	@And("^I enter an invalid email address$")
	public void i_enter_an_invalid_email_address() throws Throwable {
		getDriver().findElement(By.name("email")).sendKeys("sasassa.com");
	}

	@And("^I enter no comments$")
	public void i_enter_no_comments() throws Throwable {
		WebElement Comment = getDriver().findElement(By.name("message"));
		String textInsideComment = Comment.getAttribute("value");

		// Check whether input field is blank
		if(textInsideComment.isEmpty())
		{
		   System.out.println("Input field is empty");
		}
	}

	@Then("^The user should also be notified of the problem$")
	public void the_user_should_also_be_notified_of_the_problem() throws Throwable {
	   
	}

	@When("^I click on the reset button$")
	public void i_click_on_the_reset_button() throws Throwable {
		getDriver().findElement(By.xpath(".//input[@type='reset']")).click();
	}

	@Then("^The information which listed by the user on the contact us form should be removed$")
	public void the_information_which_listed_by_the_user_on_the_contact_us_form_should_be_removed() throws Throwable {
		WebElement Comment = getDriver().findElement(By.name("message"));
		String textInsideComment = Comment.getAttribute("value");

		// Check whether input field is blank
		if(textInsideComment.isEmpty())
		{
		   System.out.println("Input field is empty");
		}
	}
	
}

