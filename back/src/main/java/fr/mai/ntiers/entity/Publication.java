package fr.mai.ntiers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "t_publication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Publication {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "p_id")
  private Long id;

  @Column(name = "p_image")
  private String image;

  @Column(name = "p_texte")
  @Lob()
  private String texte;

  @ManyToOne
  @JoinColumn(name = "p_compte_id")
  private Compte compte;

  @OneToMany(mappedBy = "publication")
  @ToString.Exclude
  private Set<Commentaire> commentaires;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Publication that = (Publication) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
