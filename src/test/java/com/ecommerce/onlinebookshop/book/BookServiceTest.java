package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.AuditDetails;
import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.model.entity.book.BookDescription;
import com.ecommerce.onlinebookshop.model.entity.book.BookMetaData;
import com.ecommerce.onlinebookshop.model.enums.BookFormatType;
import com.ecommerce.onlinebookshop.model.enums.BookType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock // create a fakerepository
    private BookRepository bookRepository;

    @InjectMocks // create  real Bookservice and inject the mock Bookreposiroty into it.
    private BookService bookService;

    @Test
    void getAllBooks() {

        /*
                new Book(null, "The 7 Habits of Highly Effective People", 18.95, 30, BookType.PERSONALDEVELOPMENT,
                        new BookMetaData("Stephen R. Covey", "9780743269513", "Free Press", LocalDate.of(1989, 8, 15), "English", BookFormatType.EBOOK),
                        new BookDescription("Powerful lessons in personal change.", "image6.jpg", 4.6),
                        new AuditDetails()
                ),
                new Book(null, "Charlie and the Chocolate Factory", 8.99, 50, BookType.KIDBOOK,
                        new BookMetaData("Roald Dahl", "9780142410318", "Penguin", LocalDate.of(1964, 1, 17), "English", BookFormatType.PAPER),
                        new BookDescription("A magical story of chocolate and adventure.", "image7.jpg", 4.8),
                        new AuditDetails()
                ),
                new Book(null, "The Origin of Species", 14.99, 5, BookType.SCIENCE,
                        new BookMetaData("Charles Darwin", "9781503253781", "John Murray", LocalDate.of(1859, 11, 24), "English", BookFormatType.EBOOK),
                        new BookDescription("Foundation of evolutionary biology.", "image8.jpg", 4.3),
                        new AuditDetails()
                ),
                new Book(null, "Sapiens", 17.99, 18, BookType.HISTORY,
                        new BookMetaData("Yuval Noah Harari", "9780062316097", "Harper", LocalDate.of(2011, 1, 1), "English", BookFormatType.PAPER),
                        new BookDescription("A brief history of humankind.", "image9.jpg", 4.9),
                        new AuditDetails()
                ),
                new Book(null, "The Alchemist", 11.99, 40, BookType.PERSONALDEVELOPMENT,
                        new BookMetaData("Paulo Coelho", "9780061122415", "HarperOne", LocalDate.of(1988, 4, 1), "English", BookFormatType.AUDIO),
                        new BookDescription("A philosophical story about following your dreams.", "image10.jpg", 4.5),
                        new AuditDetails()
                ),
                new Book(null, "Flatland", 9.49, 13, BookType.MATHEMATICS,
                        new BookMetaData("Edwin A. Abbott", "9780486272634", "Dover Publications", LocalDate.of(1884, 1, 1), "English", BookFormatType.EBOOK),
                        new BookDescription("A satirical novella exploring dimensions.", "image11.jpg", 4.1),
                        new AuditDetails()
                ),
                new Book(null, "Goodnight Moon", 6.99, 60, BookType.KIDBOOK,
                        new BookMetaData("Margaret Wise Brown", "9780064430173", "Harper & Row", LocalDate.of(1947, 9, 3), "English", BookFormatType.PAPER),
                        new BookDescription("A classic bedtime story for kids.", "image12.jpg", 4.7),
                        new AuditDetails()
                ),
                new Book(null, "The Prince", 10.95, 8, BookType.HISTORY,
                        new BookMetaData("Niccolò Machiavelli", "9780199535690", "Oxford Classics", LocalDate.of(1532, 1, 1), "English", BookFormatType.EBOOK),
                        new BookDescription("A political treatise on ruling and power.", "image13.jpg", 4.0),
                        new AuditDetails()
                ),
                new Book(null, "The Subtle Art of Not Giving a F*ck", 16.50, 23, BookType.PERSONALDEVELOPMENT,
                        new BookMetaData("Mark Manson", "9780062457714", "Harper", LocalDate.of(2016, 9, 13), "English", BookFormatType.PAPER),
                        new BookDescription("A counterintuitive approach to living a good life.", "image14.jpg", 4.3),
                        new AuditDetails()
                ),
                new Book(null, "The Little Prince", 7.99, 35, BookType.KIDBOOK,
                        new BookMetaData("Antoine de Saint-Exupéry", "9780156012195", "Reynal & Hitchcock", LocalDate.of(1943, 4, 6), "English", BookFormatType.PAPER),
                        new BookDescription("A poetic tale with philosophical themes.", "image15.jpg", 4.8),
                        new AuditDetails()
                ),
                new Book(null, "Gödel, Escher, Bach", 21.99, 6, BookType.MATHEMATICS,
                        new BookMetaData("Douglas Hofstadter", "9780465026562", "Basic Books", LocalDate.of(1979, 2, 5), "English", BookFormatType.EBOOK),
                        new BookDescription("A metaphorical fugue on minds and machines.", "image16.jpg", 4.6),
                        new AuditDetails()
                ),
                new Book(null, "Brave New World", 10.49, 14, BookType.NOVEL,
                        new BookMetaData("Aldous Huxley", "9780060850524", "Chatto & Windus", LocalDate.of(1932, 1, 1), "English", BookFormatType.PAPER),
                        new BookDescription("A dystopian vision of the future.", "image17.jpg", 4.2),
                        new AuditDetails()
                ),
                new Book(null, "Man’s Search for Meaning", 13.89, 18, BookType.PERSONALDEVELOPMENT,
                        new BookMetaData("Viktor E. Frankl", "9780807014295", "Beacon Press", LocalDate.of(1946, 1, 1), "English", BookFormatType.AUDIO),
                        new BookDescription("A psychologist’s memoir of life in Nazi death camps.", "image18.jpg", 4.9),
                        new AuditDetails()
                ),
                new Book(null, "The Diary of a Young Girl", 9.75, 22, BookType.HISTORY,
                        new BookMetaData("Anne Frank", "9780553296983", "Contact Publishing", LocalDate.of(1947, 6, 25), "English", BookFormatType.PAPER),
                        new BookDescription("Writings of Anne Frank during WWII.", "image19.jpg", 4.8),
                        new AuditDetails()
                ),
                new Book(null, "The Cat in the Hat", 6.49, 45, BookType.KIDBOOK,
                        new BookMetaData("Dr. Seuss", "9780394800011", "Random House", LocalDate.of(1957, 3, 12), "English", BookFormatType.PAPER),
                        new BookDescription("A mischievous cat brings fun and chaos.", "image20.jpg", 4.7),
                        new AuditDetails()
                )
        ); */

        when(bookRepository.findAll()).thenReturn(listBooks());
        List<Book> bookResult = bookService.getAllBooks();
        assertEquals(5,bookResult.size());
    }

    @Test
    void getBookById() {
        List<Book> books =  listBooks();
        when(bookRepository.findAll()).thenReturn(books);  // ✅ Mock is used

        Book book = new Book(1L, "A Brief History of Time", 15.99, 12, BookType.SCIENCE,
                new BookMetaData("Stephen Hawking", "9780553380163", "Bantam", LocalDate.of(1998, 9, 1), "English", BookFormatType.PAPER),
                new BookDescription("An overview of cosmology for non-specialist readers.", "image1.jpg", 4.5),
                new AuditDetails()
        );
        Book book1 = bookService.getAllBooks().get(0);
        assertNotNull(book1);
        assertEquals(book.getId(),book1.getId());
         // System.out.println("---> "+book.getId());


     }

    @Test
    void addBook() {
         Book book =  new Book(null, "The Cat in the Hat", 6.49, 45, BookType.KIDBOOK,
                new BookMetaData("Dr. Seuss", "9780394800011", "Random House", LocalDate.of(1957, 3, 12), "English", BookFormatType.PAPER),
                new BookDescription("A mischievous cat brings fun and chaos.", "image20.jpg", 4.7),
                new AuditDetails()
        );

        bookService.addBook(book);

       verify(bookRepository,times(1)).save(book);



    }

    @Test
    void deleteBookById() {

        List<Book> books = listBooks();
        Book book = books.get(0);
        bookService.deleteBookById(book.getId());
        verify(bookRepository,times(1)).deleteById(book.getId());


    }

    public List<Book> listBooks(){
        List<Book> books = List.of(
                new Book(1L, "A Brief History of Time", 15.99, 12, BookType.SCIENCE,
                        new BookMetaData("Stephen Hawking", "9780553380163", "Bantam", LocalDate.of(1998, 9, 1), "English", BookFormatType.PAPER),
                        new BookDescription("An overview of cosmology for non-specialist readers.", "image1.jpg", 4.5),
                        new AuditDetails()
                ),
                new Book(2L, "To Kill a Mockingbird", 10.99, 20, BookType.NOVEL,
                        new BookMetaData("Harper Lee", "9780061120084", "J.B. Lippincott & Co.", LocalDate.of(1960, 7, 11), "English", BookFormatType.PAPER),
                        new BookDescription("A novel about racial injustice in the Deep South.", "image2.jpg", 4.8),
                        new AuditDetails()
                ),
                new Book(3L, "The Selfish Gene", 12.99, 15, BookType.SCIENCE,
                        new BookMetaData("Richard Dawkins", "9780199291151", "Oxford University Press", LocalDate.of(1976, 3, 15), "English", BookFormatType.EBOOK),
                        new BookDescription("Explores evolutionary biology and gene-centered view.", "image3.jpg", 4.4),
                        new AuditDetails()
                ),
                new Book(4L, "1984", 9.99, 25, BookType.NOVEL,
                        new BookMetaData("George Orwell", "9780451524935", "Secker & Warburg", LocalDate.of(1949, 6, 8), "English", BookFormatType.AUDIO),
                        new BookDescription("A dystopian novel on surveillance and totalitarianism.", "image4.jpg", 4.7),
                        new AuditDetails()
                ),
                new Book(5L, "Mathematics for the Curious", 13.49, 10, BookType.MATHEMATICS,
                        new BookMetaData("Peter Higgins", "9780198604601", "Oxford University Press", LocalDate.of(2002, 10, 17), "English", BookFormatType.PAPER),
                        new BookDescription("Interesting math problems and concepts.", "image5.jpg", 4.2),
                        new AuditDetails()
                ));
        return books;
    }
}