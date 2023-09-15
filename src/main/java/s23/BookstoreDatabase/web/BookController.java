package s23.BookstoreDatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import s23.BookstoreDatabase.domain.Book;
import s23.BookstoreDatabase.domain.BookRepository;
import s23.BookstoreDatabase.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@GetMapping("/index")
	@ResponseBody
	public String showMainPage() {
		return "Tämä on pääsivu";
	}

	@GetMapping(value = "/booklist")
	public String showBooks(Model model) {
		System.out.println("books " + repository.findAll());
		model.addAttribute("books", repository.findAll());

		return "booklist";
	}

	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Book book) { 
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book originalBook = repository.findById(id).orElse(null);
		model.addAttribute("book", originalBook);
		model.addAttribute("categories", crepository.findAll());
		return "editbook";

	}

	@PostMapping(value = "/update/{id}")
	public String updateBook(Book book) {
		repository.save(book);
		crepository.save(book);
		return "redirect:/booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}
}
