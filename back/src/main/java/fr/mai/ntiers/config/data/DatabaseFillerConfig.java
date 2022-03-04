package fr.mai.ntiers.config.data;

import fr.mai.ntiers.entity.Commentaire;
import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.entity.Profil;
import fr.mai.ntiers.entity.Publication;
import fr.mai.ntiers.repository.CommentaireRepository;
import fr.mai.ntiers.repository.CompteRepository;
import fr.mai.ntiers.repository.ProfilRepository;
import fr.mai.ntiers.repository.PublicationRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class DatabaseFillerConfig {

  @Bean
  public CommandLineRunner fillDatabase(
    CompteRepository compteRepository,
    ProfilRepository profilRepository,
    CommentaireRepository commentaireRepository,
    PublicationRepository publicationRepository,
    BCryptPasswordEncoder bCryptPasswordEncoder
  ) {
    return args -> {
      // Profiles
      Profil ismaelProfil = Profil
        .builder()
        .prenom("Ismaël")
        .nom("MOHAMED BOUH")
        .email("ismael@etudiant.univ-brest.fr")
        .dateNaissance(LocalDate.of(1998, 9, 19))
        .build();
      Profil maximeProfil = Profil
        .builder()
        .dateNaissance(LocalDate.of(1999, 12, 10))
        .email("maxime@etudiant.univ-brest.fr")
        .nom("TROADEC")
        .prenom("Maxime")
        .build();
      Profil aliProfil = Profil
        .builder()
        .prenom("Ali")
        .nom("HADJ-SAID")
        .email("ali@etudiant.univ-brest.fr")
        .dateNaissance(LocalDate.of(1999, 12, 12))
        .build();

      // Comptes
      Compte ismaelCompte = Compte
        .builder()
        .profil(ismaelProfil)
        .motsDePasseEncrypter(bCryptPasswordEncoder.encode("test123456"))
        .identifiant("e21909113")
        .build();
      Compte maximeCompte = Compte
        .builder()
        .profil(maximeProfil)
        .motsDePasseEncrypter(bCryptPasswordEncoder.encode("test123456"))
        .identifiant("e21706737")
        .build();
      Compte aliCompte = Compte
        .builder()
        .profil(aliProfil)
        .motsDePasseEncrypter(bCryptPasswordEncoder.encode("test123456"))
        .identifiant("e21639689")
        .build();

      // Comptes/Profiles
      aliProfil.setCompte(aliCompte);
      maximeProfil.setCompte(maximeCompte);
      ismaelProfil.setCompte(ismaelCompte);

      // Publications
      Set<Publication> aliPublications = Set.of(
        Publication
          .builder()
          .texte("Bonjour, Le framework spring pour java est très utile pour mettre en place des applications web")
          .compte(aliCompte)
          .build()
      );
      Set<Publication> ismaelPublications = Set.of(
        Publication
          .builder()
          .texte("Bonjour, je suis nouveau à l'UBO")
          .compte(ismaelCompte)
          .build()
      );
      Set<Publication> maximePublications = Set.of(
        Publication
          .builder()
          .texte("Bonjour, le framework vue est très utile dès lors que vous voulez mettre en place une application front très modulable")
          .compte(maximeCompte)
          .build()
      );

      // Commentaires
      Set<Commentaire> ismaelCommentaires = Set.of(
        Commentaire
          .builder()
          .publication(aliPublications.stream().findAny().get())
          .compte(ismaelCompte)
          .texte("Je suis vraiment d'accord avec toi")
          .build()
      );
      Set<Commentaire> maximeCommentaires = Set.of(
        Commentaire
          .builder()
          .publication(aliPublications.stream().findAny().get())
          .compte(maximeCompte)
          .texte("Je suis vraiment d'accord avec toi")
          .build()
      );
      Set<Commentaire> commentaires = new HashSet<>();
      commentaires.addAll(maximeCommentaires);
      commentaires.addAll(ismaelCommentaires);
      aliPublications.stream().findFirst().get().setCommentaires(commentaires);
      Set<Commentaire> aliCommentaires = Set.of(
        Commentaire
          .builder()
          .publication(maximePublications.stream().findAny().get())
          .compte(aliCompte)
          .texte("Je suis vraiment d'accord avec toi, vue est framework manifique")
          .build()
      );
      maximePublications.stream().findFirst().get().setCommentaires(aliCommentaires);

      // Comptes/Publication
      aliCompte.setPublications(aliPublications);
      maximeCompte.setPublications(maximePublications);
      ismaelCompte.setPublications(ismaelPublications);

      // Sauvegarde
      compteRepository.saveAll(List.of(ismaelCompte, aliCompte, maximeCompte));

      publicationRepository.saveAll(maximePublications);
      publicationRepository.saveAll(ismaelPublications);
      publicationRepository.saveAll(aliPublications);

      commentaireRepository.saveAll(ismaelCommentaires);
      commentaireRepository.saveAll(maximeCommentaires);
      commentaireRepository.saveAll(aliCommentaires);

    };
  }
}
