package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column
    private String title;

    @Column
    private Double rating;

    @Column
    private Integer awards;

    @Column
    private Date releaseDate;

    @Column
    private Integer length;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    public Movie(String title, Double rating, Integer awards, Date releaseDate, Integer length, List<Actor> actors, Genre genre) {
        this.title = title;
        this.rating = rating;
        this.awards = awards;
        this.releaseDate = releaseDate;
        this.length = length;
        this.actors = actors;
        this.genre = genre;
    }
}
