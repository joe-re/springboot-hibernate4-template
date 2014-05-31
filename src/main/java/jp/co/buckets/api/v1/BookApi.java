package jp.co.buckets.api.v1;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import jp.co.buckets.dto.Book;
import jp.co.buckets.exception.AlreadyExistsDataException;
import jp.co.buckets.exception.NotFoundDataException;
import jp.co.buckets.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookApi {

    @Autowired
    BookService bookService;
    
    @RequestMapping(method = GET)
    @ResponseBody
    public List<Book> getAllBook() throws NotFoundDataException {
        return bookService.getAllBook();
    }

    @RequestMapping(value = "/{bookId}", method = GET)
    @ResponseBody
    public Book getBookById(@PathVariable("bookId") int bookId) throws NotFoundDataException {
        return bookService.getBook(bookId);
    }

    @RequestMapping(value = "/{bookId}", method = POST)
    @ResponseStatus(CREATED)
    public String createBook(
            @PathVariable("bookId") int bookId,
            @RequestParam(value = "title", required = true) String title) throws AlreadyExistsDataException {
        bookService.insertBook(bookId, title);
        return "created.";
    }

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public String handleNotFoundData(NotFoundDataException e) {
        return "book is not found.";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    @ResponseBody
    public String handleAlreadyExistsData(AlreadyExistsDataException e) {
        return "book is already exists.";
    }
}
