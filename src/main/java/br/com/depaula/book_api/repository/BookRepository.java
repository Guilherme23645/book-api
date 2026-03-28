package br.com.depaula.book_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.depaula.book_api.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}