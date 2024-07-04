package com.literalura.apilibros.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authorNames;
    private String authorBirthYears;
    private String authorDeathYears;
    private Integer downloadCount;
    private String languages;

    public BookDetails() {
    }

    public BookDetails(Long id, String title, String authorNames, String authorBirthYears, String authorDeathYears, Integer downloadCount, String languages) {
        this.id = id;
        this.title = title;
        this.authorNames = authorNames;
        this.authorBirthYears = authorBirthYears;
        this.authorDeathYears = authorDeathYears;
        this.downloadCount = downloadCount;
        this.languages = languages;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getAuthorBirthYears() {
        return authorBirthYears;
    }

    public void setAuthorBirthYears(String authorBirthYears) {
        this.authorBirthYears = authorBirthYears;
    }

    public String getAuthorDeathYears() {
        return authorDeathYears;
    }

    public void setAuthorDeathYears(String authorDeathYears) {
        this.authorDeathYears = authorDeathYears;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
