package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@Table(name = "article")
@RequiredArgsConstructor
public class Article extends AbstractEntity {
    @Column(name = "article_code")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unit_price_ht")
    private BigDecimal unitPriceHt;

    @Column(name = "tauxTVA")
    private BigDecimal tauxTva;

    @Column(name = "unit_price_TTC")
    private BigDecimal unitPriceTTC;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<SaleLine> saleLines;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<LineClientCommand> lineClientCommands;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<LineProviderCommand> lineProviderCommands;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<MovementStock> movementStocks;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Article article = (Article) o;
        return getId() != null && Objects.equals(getId(), article.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

