package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sales")
public class Sales extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "saleDate")
    private Instant saleDate;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy ="sale")
    @ToString.Exclude
    private List<SaleLine> saleLines;
}
