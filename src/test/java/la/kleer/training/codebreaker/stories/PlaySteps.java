package la.kleer.training.codebreaker.stories;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import la.kleer.training.codebreaker.pages.HomePage;
import la.kleer.training.codebreaker.pages.PageFactory;

public class PlaySteps 
{
	private final PageFactory pageFactory;
	private HomePage home;
	
	public PlaySteps(PageFactory pageFactory) 
	{
		this.pageFactory = pageFactory;
	}

	@Given("the secret code is \"$code\"")
	public void setSecretCode(String code) {
		home = pageFactory.home();
		home.open();
		home.setSecretCode(code);
	}
	
	@When("I try with \"$guess\"")
	public void tryWith(String guess)
	{
		home.tryWith(guess);
	}

	@Then("I should see \"$text\"")
	public void iShouldSeeTheFollowingText(String text){
		home.textIsVisible(text);
	}
}
