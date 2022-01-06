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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_compte")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

  @ManyToMany
  @JoinTable(
    name = "t_amis",
    joinColumns = @JoinColumn(name = "a_compte_id", referencedColumnName = "c_id"),
    inverseJoinColumns = @JoinColumn(name = "a_ami_id", referencedColumnName = "c_id")
  )
  @ToString.Exclude
  private Set<Compte> amis;

  @ManyToMany(mappedBy = "amis")
  @ToString.Exclude
  private Set<Compte> amisDe;

  @OneToMany(mappedBy = "destination")
  @ToString.Exclude
  private Set<Message> messagesRecus;

  @OneToMany(mappedBy = "source")
  @ToString.Exclude
  private Set<Message> messagesEnvoyes;

  @ManyToMany(mappedBy = "comptes")
  @ToString.Exclude
  private Set<GroupeAmis> groupeAmis;

  @OneToMany(mappedBy = "compteSource")
  @ToString.Exclude
  private Set<MessageGroupe> messageGroupes;

  @OneToMany(mappedBy = "compte")
  @ToString.Exclude
  private Set<Publication> publications;

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
