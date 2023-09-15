package s23.BookstoreDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Book, Long>{
	
	
}