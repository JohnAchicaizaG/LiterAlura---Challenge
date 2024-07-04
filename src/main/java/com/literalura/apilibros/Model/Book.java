package com.literalura.apilibros.Model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID autoincremental único para la base de datos
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;
    private int downloadCount;
    @ElementCollection
    private List<String> languages;
}
