package s23.friendDatabase.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import s23.friendDatabase.domain.Friend;

@Controller
public class FriendController {

	@RequestMapping(value="/friend", method = RequestMethod.GET)
	public String showStudents(Model model) {
		System.out.println("friends");
		
		List<Friend> friends = new ArrayList<>();
		friends.add(new Friend("Jenna", "Räihä"));
		friends.add(new Friend("Janne", "Autio"));
		friends.add(new Friend("Anna", "Luoma"));
		
		model.addAttribute("friends", friends);
		return "friendList";
	}

	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    public String save(Friend friend){
        return "redirect:friend";
    }    
}