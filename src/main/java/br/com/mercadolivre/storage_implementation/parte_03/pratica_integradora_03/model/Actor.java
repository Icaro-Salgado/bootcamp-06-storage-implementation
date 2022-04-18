package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Double rating;

    @ManyToOne
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties(value = "actors")
    private List<Movie> movies;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Actor(String firstName, String lastName, Double rating, Movie favoriteMovie) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.favoriteMovie = favoriteMovie;
    }
}
