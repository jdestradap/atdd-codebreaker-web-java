package la.kleer.training.codebreaker.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class HomePage extends Page {

	public HomePage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}
	
	public void open() {
		open("/codebreaker/");
	}

	public void verifyPage() {
		textIsVisible("Hello world!");
	}

	public void setSecretCode(String code) {
		open("/codebreaker/set-code/?code="+code+"&key="+ getKeyFor(code) );
	}
	
	private String getKeyFor(String code)
	{
		StringBuffer key = new StringBuffer();
		
		for (int i=0;i<4;i++)
		{
			String diggit = code.substring(i, i+1);
			int number = Integer.parseInt(diggit);
			switch(number)
			{
				case 1:	key.append("A"); break;
				case 2:	key.append("B"); break;
				case 3:	key.append("C"); break;
				case 4:	key.append("D"); break;
				case 5:	key.append("E"); break;
				case 6:	key.append("F"); break;
			}
		}
		return key.toString();
	}

	public void tryWith(String guess) 
	{
		type("guess", guess);
		click("submit");
		waitForPageToLoad(3000);
	}
}
