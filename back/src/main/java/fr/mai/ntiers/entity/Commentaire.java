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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "t_commentaire")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commentaire {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "com_id")
  private Long id;

  @Column(name = "com_texte")
  private String texte;

  @ManyToOne
  @JoinColumn(name = "com_compte_id")
  private Compte compte;

  @ManyToOne
  @JoinColumn(name = "com_publication_id")
  private Publication publication;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Commentaire that = (Commentaire) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
