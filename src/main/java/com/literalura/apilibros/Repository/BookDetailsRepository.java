package com.literalura.apilibros.Repository;

import com.literalura.apilibros.Model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDetailsRepository extends JpaRepository<BookDetails, Long> {
    @Query("SELECT DISTINCT b.authorNames FROM BookDetails b WHERE b.authorNames IS NOT NULL AND b.authorNames <> ''")
    List<String> findDistinctNonEmptyAuthorNames();


    @Query("SELECT DISTINCT b.title FROM BookDetails b WHERE b.title IS NOT NULL AND b.title <> ''")
    List<String> findDistinctNonEmptyTitles();

    @Query("SELECT DISTINCT b.authorNames FROM BookDetails b WHERE b.authorDeathYears = 'N/A'")
    List<String> findDistinctAuthorsWithNoDeathYear();

    @Query("SELECT b.title FROM BookDetails b WHERE b.languages = :language")
    List<String> findTitlesByLanguage(@Param("language") String language);

    @Query("SELECT DISTINCT b.title, b.downloadCount FROM BookDetails b WHERE b.downloadCount IS NOT NULL AND b.title IS NOT NULL AND b.title <> '' ORDER BY b.downloadCount DESC")
    List<String> findDistinctTitlesAndDownloadCountByDownloadCountDesc();
}