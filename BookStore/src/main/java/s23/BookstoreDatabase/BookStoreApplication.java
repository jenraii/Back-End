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
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Comedy"));
			
			repository.save(new Book("Zorro", "Johnson, A.", "987654321", 2000, 20.0));
			repository.save(new Book("Katy Girl", "Kateson, M.", "123456789", 1996, 24.99));
			repository.save(new Book("Vitsikirja", "Ruonansuu, J.", "123456666", 2013, 26.99));
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}


