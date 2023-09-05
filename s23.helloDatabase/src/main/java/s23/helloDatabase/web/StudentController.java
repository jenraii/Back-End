package s23.helloDatabase.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import s23.helloDatabase.domain.Student;

@Controller
public class StudentController {

	@GetMapping("/hello1")
	public String showStudents(Model model) {
		System.out.println("students");
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Jenna", "Räihä"));
		students.add(new Student("Janne", "Autio"));
		students.add(new Student("Anna", "Luoma"));
		
		model.addAttribute("students", students);
		return "studentList";
	}

}