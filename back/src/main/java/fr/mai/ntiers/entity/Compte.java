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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Objects;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_compte")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
public class Compte {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "c_id")
  private Long id;

  @Column(name = "c_mots_de_passe_encrypter", nullable = false)
  private String motsDePasseEncrypter;

  @Column(name = "c_identifiant", nullable = false, unique = true)
  private String identifiant;

  @OneToOne(fetch = EAGER)
  @JoinColumn(name = "c_p_id", nullable = false)
  private Profil profil;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Compte compte = (Compte) o;
    return id != null && Objects.equals(id, compte.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
