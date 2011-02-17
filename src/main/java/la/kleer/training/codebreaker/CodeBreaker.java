package la.kleer.training.codebreaker;

import java.util.Random;

public class CodeBreaker {

	private String secretCode;
	
	public CodeBreaker()
	{
		Random randomGenerator = new Random();
		StringBuffer secretCodeBuffer = new StringBuffer();
		
		secretCodeBuffer.append( 1 + randomGenerator.nextInt(6) );
		secretCodeBuffer.append( 1 + randomGenerator.nextInt(6) );
		secretCodeBuffer.append( 1 + randomGenerator.nextInt(6) );
		secretCodeBuffer.append( 1 + randomGenerator.nextInt(6) );
		
		this.secretCode = secretCodeBuffer.toString();
	}

	public String getSecretCode() {
		
		return this.secretCode; 
	}

	public void setSecretCode(String code, String key) 
	{
		boolean keyAccepted = true;
		
		for (int i=0;i<4 && keyAccepted;i++)
		{
			String keyLetter = "";
			String diggit = code.substring(i, i+1);
			int number = Integer.parseInt(diggit);
			switch(number)
			{
				case 1:	keyLetter = "A"; break;
				case 2:	keyLetter = "B"; break;
				case 3:	keyLetter = "C"; break;
				case 4:	keyLetter = "D"; break;
				case 5:	keyLetter = "E"; break;
				case 6:	keyLetter = "F"; break;
			}
			
			keyAccepted &= (keyLetter.equals( key.substring(i, i+1) ) );  
		}
		
		if (keyAccepted) this.secretCode = code;
		
	}

	public String tryWith(String guess) 
	{
		String exacResult = "";
		String numberResult = "";
		
		if (guess==this.secretCode)
			exacResult = "XXXX";
		else
		{
			for (int i=0;i<4;i++)
			{
				if (guess.charAt(i) == this.secretCode.charAt(i) )
				{
					exacResult += "X";
				}
				else if (this.secretCode.indexOf(guess.charAt(i))>=0)
				{
					numberResult += "_";
				}
			}
		}
		
		return exacResult+numberResult;
	}

}
