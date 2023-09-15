package s23.BookstoreDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.BookstoreDatabase.domain.Book;
import s23.BookstoreDatabase.domain.BookRepository;
import s23.BookstoreDatabase.domain.Category;
import s23.BookstoreDatabase.domain.CategoryRepository;


@SpringBootApplication
public class BookStoreApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			repository.save(new Book("Zorro", "Johnson, A.", "987654321", 2000, 20.0));
			repository.save(new Book("Katy Girl", "Kateson, M.", "123456789", 1996, 24.99));
			repository.save(new Book("Vitsikirja", "Ruonansuu, J.", "123456666", 2013, 26.99));
			
		};
	}

}

