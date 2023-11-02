package s23.BookstoreDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.BookstoreDatabase.domain.AppUser;
import s23.BookstoreDatabase.domain.AppUserRepository;
import s23.BookstoreDatabase.domain.Book;
import s23.BookstoreDatabase.domain.BookRepository;
import s23.BookstoreDatabase.domain.Category;
import s23.BookstoreDatabase.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Educational"));
			
			brepository.save(new Book("Vitsikirja", "Ruonansuu, J.", "1234567", 2003, 24.00, crepository.findByName("Comedy").get(0)));
			brepository.save(new Book("Aapinen", "Meikäläinen, M.", "9876543", 1998, 30.00, crepository.findByName("Educational").get(0)));
			brepository.save(new Book("Harry Potter", "Rowling, J.K.", "7634982", 2000, 45.00, crepository.findByName("Fantasy").get(0)));
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

