package la.kleer.training.codebreaker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("codebreaker", new CodeBreaker());
		request.getSession().removeAttribute("last_result");
		logger.info("Welcome home!");
		return "home";
	}
	
	@RequestMapping(value="/set-code", method=RequestMethod.GET)
	public String setCode(HttpServletRequest request, HttpServletResponse response) {
		
		String code = request.getParameter("code");
		String key = request.getParameter("key");
		
		if ((code!=null) && (key!=null))
		{
			CodeBreaker codeB = (CodeBreaker) request.getSession().getAttribute("codebreaker");
			codeB.setSecretCode(code, key );
			logger.info("Setting the Code: " + code );
		}
		
		return "home";
	}
	
	@RequestMapping(value="/play", method=RequestMethod.POST)
	public String play(HttpServletRequest request, HttpServletResponse response) {
		String guess = request.getParameter("guess");
		if (guess!=null)
		{
			CodeBreaker codeB = (CodeBreaker) request.getSession().getAttribute("codebreaker");
			String result = codeB.tryWith(guess);
			request.getSession().setAttribute("last_result", result);
			logger.info("Trying with Guess: " + guess );
		}
		
		return "home";
	}
}

