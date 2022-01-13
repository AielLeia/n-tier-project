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

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_message")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "m_id")
  private Long id;

  @Column(name = "m_texte")
  private String texte;

  @ManyToOne
  @JoinColumn(name = "m_source_id")
  @ToString.Exclude
  private Compte source;

  @ManyToOne
  @JoinColumn(name = "m_destination_id")
  @ToString.Exclude
  private Compte destination;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Message message = (Message) o;
    return id != null && Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
