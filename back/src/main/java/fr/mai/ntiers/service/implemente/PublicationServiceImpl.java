package fr.mai.ntiers.service.implemente;

import fr.mai.ntiers.dto.PublicationDto;
import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.entity.Publication;
import fr.mai.ntiers.mapper.PublicationMapper;
import fr.mai.ntiers.repository.CompteRepository;
import fr.mai.ntiers.repository.PublicationRepository;
import fr.mai.ntiers.service.PublicationService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Service
public class PublicationServiceImpl implements PublicationService {

  private final PublicationRepository publicationRepository;

  private final CompteRepository compteRepository;

  private final PublicationMapper publicationMapper;

  public PublicationServiceImpl(
    PublicationRepository publicationRepository,
    CompteRepository compteRepository,
    PublicationMapper publicationMapper
  ) {
    this.publicationRepository = publicationRepository;
    this.compteRepository = compteRepository;
    this.publicationMapper = publicationMapper;
  }

  @Override
  public Set<PublicationDto> recupererPublications() {
    List<Publication> publications = publicationRepository.findAll();
    return publications
      .stream()
      .map(publicationMapper::toPublicationDto)
      .collect(Collectors.toSet());
  }

  @Override
  public Set<PublicationDto> recupererPublicationParEtudiant(String identifiantEtudiant) {
    Set<Publication> publications = publicationRepository.findAllByCompteIdentifiant(identifiantEtudiant);
    return publications
      .stream()
      .map(publicationMapper::toPublicationDto)
      .collect(toSet());
  }

  @Override
  public PublicationDto enregistrerPublication(PublicationDto publicationDto) {
    Publication publication = publicationMapper.toPublicationEntity(publicationDto);
    String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Compte compte = compteRepository.findByIdentifiant(principal).orElseThrow();
    compte.getPublications().add(publication);
    publication.setCompte(compte);
    publicationRepository.save(publication);
    compteRepository.save(compte);
    return publicationMapper.toPublicationDto(publication);
  }
}
