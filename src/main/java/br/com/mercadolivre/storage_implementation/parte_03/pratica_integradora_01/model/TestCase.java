package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column
    private String description;

    @Column
    private boolean tested;

    @Column
    private boolean passed;

    @Column
    private int number_of_tries;

    @Column
    private Date lastUpdate = new Date();
}
