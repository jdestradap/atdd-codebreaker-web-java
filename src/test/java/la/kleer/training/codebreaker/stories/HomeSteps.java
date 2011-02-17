package la.kleer.training.codebreaker.stories;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import la.kleer.training.codebreaker.pages.HomePage;
import la.kleer.training.codebreaker.pages.PageFactory;

public class HomeSteps 
{
	private final PageFactory pageFactory;
	private HomePage home;
	
	public HomeSteps(PageFactory pageFactory) 
	{
		this.pageFactory = pageFactory;
	}

	@Given("I open the web application")
	public void openWebApplication() {
		home = pageFactory.home();
		home.open();
	}

	@Then("I should see \"$text\"")
	public void iShouldSeeTheFollowingText(String text){
		home.textIsVisible(text);
	}
}
