package fr.mai.ntiers.repository;

import fr.mai.ntiers.entity.Profil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
}
