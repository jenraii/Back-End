package s23.welcomeDatabase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/index")
	@ResponseBody
	public String showMainPage(){
		return "This is the main page.";
	}
	
	@RequestMapping("/contact")
	@ResponseBody
	public String showContactPage() {
		return "This is the contact page.";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHelloToSomebody(@RequestParam(name="location") String location,
		@RequestParam(name="name") String name) {
		return "Welcome to the " + location + " " + name;
	}
}



