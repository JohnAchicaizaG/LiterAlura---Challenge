package com.literalura.apilibros.menu.Service;

import com.literalura.apilibros.menu.Dto.Book;
import com.literalura.apilibros.menu.Dto.BookResponse;
import com.literalura.apilibros.Model.BookDetails;
import com.literalura.apilibros.Repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final RestTemplate restTemplate;
    private final BookDetailsRepository bookDetailsRepository;

    @Autowired
    public MenuService(RestTemplate restTemplate, BookDetailsRepository bookDetailsRepository) {
        this.restTemplate = restTemplate;
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public void searchBookByTitle(String title) {
        String url = "https://gutendex.com/books/?search=" + title;
        try {
            BookResponse response = restTemplate.getForObject(url, BookResponse.class);
            if (response != null && response.getResults() != null) {
                List<BookDetails> bookDetailsToSave = response.getResults().stream()
                        .map(this::convertToBookDetails)
                        .collect(Collectors.toList());

                // Guardar los libros en la base de datos
                bookDetailsRepository.saveAll(bookDetailsToSave);

                // Imprimir información de los libros guardados
                bookDetailsToSave.forEach(bookDetails -> {
                    System.out.println("Libro guardado en la base de datos: " + bookDetails.getTitle());
                });
            } else {
                System.out.println("No se encontraron resultados para el título: " + title);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }

    private BookDetails convertToBookDetails(Book dto) {
        // Convertir la lista de autores a una cadena de nombres, años de nacimiento y años de muerte
        String authorNames = dto.getAuthors().stream()
                .map(author -> author.getName())
                .collect(Collectors.joining(", "));

        String authorBirthYears = dto.getAuthors().stream()
                .map(author -> author.getBirthYear() != null ? author.getBirthYear().toString() : "N/A")
                .collect(Collectors.joining(", "));

        String authorDeathYears = dto.getAuthors().stream()
                .map(author -> author.getDeathYear() != null ? author.getDeathYear().toString() : "N/A")
                .collect(Collectors.joining(", "));

        // Crear y devolver un nuevo objeto BookDetails
        return new BookDetails(
                null, // Deja que JPA asigne el ID automáticamente
                dto.getTitle(),
                authorNames,
                authorBirthYears,
                authorDeathYears,
                dto.getDownloadCount(),
                dto.getLanguages().toString() // Convertir la lista de idiomas a una cadena
        );
    }

    public void listRegisteredBooks() {
        System.out.println("Lista de libros registrados");
        List<String> authors = bookDetailsRepository.findDistinctNonEmptyTitles();

        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            authors.forEach(System.out::println);
        }
    }

    public void listRegisteredAuthors() {
        System.out.println("Lista de autores registrados");

        List<String> authors = bookDetailsRepository.findDistinctNonEmptyAuthorNames();

        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            authors.forEach(System.out::println);
        }
    }

    public void listLivingAuthorsInYear() {
        System.out.println("Lista de autores vivos en un año determinado");

        List<String> authors = bookDetailsRepository.findDistinctAuthorsWithNoDeathYear();

        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            authors.forEach(System.out::println);
        }

    }

    public void listBooksByLanguage(String language) {
        System.out.println("Lista de libros por idioma");

        List<String> books = bookDetailsRepository.findTitlesByLanguage(language);

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    public void top10DownloadedBooks() {
        System.out.println("Top 10 libros más descargados");

        List<String> books = bookDetailsRepository.findDistinctTitlesAndDownloadCountByDownloadCountDesc();

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    public void showStatistics() {
        System.out.println("Estadísticas");
        // Lógica para mostrar estadísticas
    }
}
