package fr.mai.ntiers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_profil")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
public class Profil {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "p_id")
  private Long id;

  @Column(name = "p_nom", nullable = false)
  private String nom;

  @Column(name = "p_prenom", nullable = false)
  private String prenom;

  @Column(name = "p_photos", nullable = false)
  private String photos;

  @OneToOne(mappedBy = "profil")
  private Compte compte;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Profil profil = (Profil) o;
    return id != null && Objects.equals(id, profil.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
