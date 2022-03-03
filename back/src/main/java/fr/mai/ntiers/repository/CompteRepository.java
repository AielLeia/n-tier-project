package fr.mai.ntiers.repository;

import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.entity.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

  /**
   * Charger une donnée depuis la base de donnée avec l'identifiant
   * de l'étudiant.
   *
   * @param identifiantEtudiant Identifiant de l'étudiant
   * @return Un optional de compte
   */
  Optional<Compte> findByIdentifiant(String identifiantEtudiant);
}
