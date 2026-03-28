package br.com.depaula.book_api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.depaula.book_api.model.Book;
import br.com.depaula.book_api.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public Iterable<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book findBookById(Long id) {
        Optional<Book> book = repository.findById(id);
        return book.get();
    }

    public void updateBookById(Long id, Book book) {
        Optional<Book> storedBook = repository.findById(id);
        if (storedBook.isPresent()) {
            storedBook.get().setTitle(book.getTitle());
            storedBook.get().setAuthor(book.getAuthor());
            repository.save(storedBook.get());
        }
    }

    public void deleteBookById(Long id) {
        Optional<Book> storedBook = repository.findById(id);
        if (storedBook.isPresent())
            repository.deleteById(id);
    }
}