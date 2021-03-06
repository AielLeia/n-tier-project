package fr.mai.ntiers.controller;

import fr.mai.ntiers.controller.contract.PublicationControllerContract;
import fr.mai.ntiers.dto.PublicationDto;
import fr.mai.ntiers.mapper.PublicationMapper;
import fr.mai.ntiers.request.PublicationRequestModel;
import fr.mai.ntiers.response.PublicationResponseModel;
import fr.mai.ntiers.service.PublicationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RestController
@Slf4j
public class PublicationController implements PublicationControllerContract {
  private final PublicationService publicationService;

  private final PublicationMapper publicationMapper;

  public PublicationController(
    PublicationService publicationService,
    PublicationMapper publicationMapper
  ) {
    this.publicationService = publicationService;
    this.publicationMapper = publicationMapper;
  }

  @Override
  public Set<PublicationResponseModel> publications() {
    return publicationService
      .recupererPublications()
      .stream()
      .map(publicationMapper::toPublicationResponseModel)
      .collect(toSet());
  }

  @Override
  public Set<PublicationResponseModel> publicationParUtilisateur(String id) {
    log.info(id);
    Set<PublicationDto> publicationDtos = publicationService.recupererPublicationParEtudiant(id);
    log.info(String.valueOf(publicationDtos));
    return publicationDtos
      .stream()
      .map(publicationMapper::toPublicationResponseModel)
      .collect(toSet());
  }

  @Override
  public PublicationResponseModel enregisterPublicationUtilisateur(PublicationRequestModel publicationRequestModel) {
    PublicationDto publicationDto = publicationService.enregistrerPublication(publicationMapper.toPublicationDto(publicationRequestModel));
    return publicationMapper.toPublicationResponseModel(publicationDto);
  }
}
