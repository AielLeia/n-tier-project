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
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_groupe_amis")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupeAmis {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ga_id")
  private Long id;

  @Column(name = "ga_nom")
  private String nom;

  @ManyToMany
  @JoinTable(
    name = "t_groupe_amis_compte",
    joinColumns = @JoinColumn(name = "gac_groupe_id", referencedColumnName = "ga_id"),
    inverseJoinColumns = @JoinColumn(name = "gac_compte_id", referencedColumnName = "c_id")
  )
  @ToString.Exclude
  private Set<Compte> comptes;

  @OneToMany(mappedBy = "groupeAmisDestination")
  @ToString.Exclude
  private Set<MessageGroupe> messageGroupes;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    GroupeAmis that = (GroupeAmis) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
