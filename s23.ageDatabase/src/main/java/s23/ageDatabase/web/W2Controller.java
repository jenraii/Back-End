package s23.ageDatabase.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class W2Controller {

	@RequestMapping("/hello2")
	public String showInfo(@RequestParam(name="name") String nimi, @RequestParam(name="age") int ika, Model model) {
		model.addAttribute("name", nimi);
		model.addAttribute("age", ika);
		
		return "W2hello";
	}

}