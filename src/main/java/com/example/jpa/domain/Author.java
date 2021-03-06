package com.example.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthor = new ArrayList<>();

    public void addBookAndAuthor(BookAndAuthor... bookAndAuthors) {
        Collections.addAll(this.bookAndAuthor, bookAndAuthors);
    }


}
