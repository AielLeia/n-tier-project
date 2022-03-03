package fr.mai.ntiers.service;

import fr.mai.ntiers.dto.PublicationDto;

import java.util.Set;

public interface PublicationService {

  Set<PublicationDto> recupererPublicationParEtudiant(String identifiantEtudiant);

  PublicationDto enregistrerPublication(PublicationDto toPublicationDto);
}
