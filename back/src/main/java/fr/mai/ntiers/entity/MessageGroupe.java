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
@Table(name = "t_message_groupe")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageGroupe {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "mg_id")
  private Long id;

  @Column(name = "mg_texte")
  private String texte;

  @ManyToOne
  @JoinColumn(name = "mg_groupe_destination_id")
  @ToString.Exclude
  private GroupeAmis groupeAmisDestination;

  @ManyToOne
  @JoinColumn(name = "mg_compte_source_id")
  private Compte compteSource;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    MessageGroupe that = (MessageGroupe) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
