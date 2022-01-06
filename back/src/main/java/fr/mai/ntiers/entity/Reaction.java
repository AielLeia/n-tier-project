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
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_reaction")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reaction {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "rea_id")
  private Long id;

  @Enumerated(value = ORDINAL)
  @Column(name = "rea_type_reaction")
  private TypeReaction typeReaction;

  @OneToOne
  @JoinColumn(name = "rea_publication_id", referencedColumnName = "p_id")
  private Publication publication;

  @OneToMany
  @JoinColumn(name = "rea_compte_id", referencedColumnName = "c_id")
  @ToString.Exclude
  private Set<Compte> compte;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Reaction reaction = (Reaction) o;
    return id != null && Objects.equals(id, reaction.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
