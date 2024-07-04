package com.literalura.apilibros.Service;


import com.literalura.apilibros.Model.Book;
import com.literalura.apilibros.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        try {
            bookRepository.save(book);
            System.out.println("Libro guardado correctamente en la base de datos.");
        } catch (Exception e) {
            System.out.println("Error al guardar el libro en la base de datos: " + e.getMessage());
        }
    }
}
