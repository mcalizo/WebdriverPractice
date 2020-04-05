package Steps;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import Utils.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends DriverFactory {
	@Given("^user navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
	    getDriver().get(url); 
	}

	@When("^user clicks on the login portal button$")
	public void user_clicks_on_the_login_portal_button() throws Throwable {
		getDriver().findElement(By.id("login-portal")).click();
	}

	@And("^user enters the \"([^\"]*)\" username$")
	public void user_enters_the_username(String username) throws Throwable {
				
		for(String winHandler : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandler);
		}
		Thread.sleep(4000);
		getDriver().findElement(By.id("text")).sendKeys(username);
	}

	@And("^user enters the \"([^\"]*)\" password$")
	public void user_enters_the_password(String password) throws Throwable {
		getDriver().findElement(By.id("password")).sendKeys(password);
	}

	@When("^user clicks the login button$")
	public void user_clicks_the_login_button() throws Throwable {
		getDriver().findElement(By.id("login-button")).click();
	}

	@Then("^the user should be presented with the following alert \"([^\"]*)\"$")
	public void the_user_should_be_presented_with_the_following_alert(String message) throws Throwable {
	    Alert alert = getDriver().switchTo().alert();
	    assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""), message.toLowerCase().replaceAll("\\s", ""));
	    alert.accept();
	}
}
