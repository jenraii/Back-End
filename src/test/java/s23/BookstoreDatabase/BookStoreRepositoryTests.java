package s23.BookstoreDatabase;

import s23.BookstoreDatabase.domain.Book;
import s23.BookstoreDatabase.domain.BookRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class BookStoreRepositoryTests {
    private static final Logger logger = LoggerFactory.getLogger(BookStoreRepositoryTests.class);
    @Autowired
    BookRepository repository;
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testFindAllBooks() {
        List<Book> books = repository.findByTitle("Harry Potter");
        assertEquals(books.get(0).getTitle(), "Harry Potter");
        logger.info("Book count: {}, First book title: {}", books.size(), books.get(0).getTitle());
    }
    
    @Test
    public void shouldReturnThreeBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
}