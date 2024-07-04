package com.literalura.apilibros.Repository;

import com.literalura.apilibros.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Book, Long> {
}
