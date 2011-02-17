package la.kleer.training.codebreaker;

import static org.junit.Assert.*;

import org.junit.Test;


public class CodeBreakerTest {
	
	@Test
	public void testItShouldCreateAFourLettersCode()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		String code = codebreaker.getSecretCode();
		
		assertEquals( 4, code.length() );
		
	}
	
	@Test
	public void testItShouldCreateARandomCode()
	{
		CodeBreaker codebreaker1 = new CodeBreaker();
		String code1 = codebreaker1.getSecretCode();
		CodeBreaker codebreaker2 = new CodeBreaker();
		String code2 = codebreaker2.getSecretCode();
		CodeBreaker codebreaker3 = new CodeBreaker();
		String code3 = codebreaker3.getSecretCode();
		CodeBreaker codebreaker4 = new CodeBreaker();
		String code4 = codebreaker4.getSecretCode();
		
		assertFalse( code1.equals(code2) && code1.equals(code3) && code1.equals(code4) );
		
	}

	@Test
	public void testItShouldAllowToGetTheCodeOverWrittenWithTheCorrectKey()
	{
		CodeBreaker codebreaker1 = new CodeBreaker();
		CodeBreaker codebreaker2 = new CodeBreaker();
		
		codebreaker1.setSecretCode("1234", "ABCD");
		codebreaker2.setSecretCode("6543", "FEDC");
		
		assertEquals( "1234", codebreaker1.getSecretCode() );
		assertEquals( "6543", codebreaker2.getSecretCode() );
	}
	
	@Test
	public void testItShouldNotAllowToGetTheCodeOverWrittenWithTheWrongtKey()
	{
		CodeBreaker codebreaker1 = new CodeBreaker();
		CodeBreaker codebreaker2 = new CodeBreaker();
		
		codebreaker1.setSecretCode("1234", "FEDC");
		codebreaker2.setSecretCode("6543", "ABCD");
		
		assertFalse( "1234".equals( codebreaker1.getSecretCode() ) );
		assertFalse( "6543".equals( codebreaker2.getSecretCode() ) );
	}
	
	@Test
	public void testItShouldReturnEmptyForATotalFailure()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("1234", "ABCD");
		
		String result = codebreaker.tryWith("5555");
		
		assertEquals( "", result );
	}
	
	@Test
	public void testItShouldReturnXXXXForATotalGuess1234()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("1234", "ABCD");
		
		String result = codebreaker.tryWith("1234");
		
		assertEquals( "XXXX", result );
	}
	
	@Test
	public void testItShouldReturnXXXXForATotalGuess3456()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3456");
		
		assertEquals( "XXXX", result );
	}
	
	@Test
	public void testItShouldReturnXForASingleExactGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3111");
		
		assertEquals( "X", result );
	}
	
	@Test
	public void testItShouldReturnXXForADoubleExactGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3411");
		
		assertEquals( "XX", result );
	}
	
	@Test
	public void testItShouldReturnXXXForATripleExactGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3451");
		
		assertEquals( "XXX", result );
	}
	
	@Test
	public void testItShouldReturn_ForASingleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("1113");
		
		assertEquals( "_", result );
	}
	
	@Test
	public void testItShouldReturn__ForADoubleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("1143");
		
		assertEquals( "__", result );
	}
	
	@Test
	public void testItShouldReturn___ForATripleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("1543");
		
		assertEquals( "___", result );
	}
	
	@Test
	public void testItShouldReturn____ForACuadrupleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("6543");
		
		assertEquals( "____", result );
	}
	
	@Test
	public void testItShouldReturnX_ForASingleExactGuessAndASingleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3114");
		
		assertEquals( "X_", result );
	}
	
	@Test
	public void testItShouldReturnXX_ForADoubleeExactGuessAndASingleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3415");
		
		assertEquals( "XX_", result );
	}
	
	@Test
	public void testItShouldReturnX__ForASingleExactGuessAndADoubleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3145");
		
		assertEquals( "X__", result );
	}
	
	@Test
	public void testItShouldReturnX___ForASingleExactGuessAndATrilpleNumberGuess()
	{
		CodeBreaker codebreaker = new CodeBreaker();
		codebreaker.setSecretCode("3456", "CDEF");
		
		String result = codebreaker.tryWith("3645");
		
		assertEquals( "X___", result );
	}
}
