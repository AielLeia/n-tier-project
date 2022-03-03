package fr.mai.ntiers.repository;

import fr.mai.ntiers.entity.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

  /**
   * Récupére toutes les publications d'un étudiant.
   *
   * @param identifiantEtudiant Identifiant de l'édution
   * @return Une liste de toutes ses publications
   */
  Set<Publication> findAllByCompteIdentifiant(String identifiantEtudiant);
}
