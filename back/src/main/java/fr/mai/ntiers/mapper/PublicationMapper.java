package fr.mai.ntiers.mapper;

import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.dto.PublicationDto;
import fr.mai.ntiers.entity.Publication;
import fr.mai.ntiers.request.PublicationRequestModel;
import fr.mai.ntiers.response.PublicationResponseModel;

import org.mapstruct.Mapper;

/**
 * Regroupe l'ensemble des méthodes permettant de convertir
 * un objet publication présent sous différents aspects en un aspect cible.
 *
 * Via la librairie mapstruct, une implémentation sera automatiquement
 * générée et le modèle d'injection de dépendance est adapté à spring.
 */
@Mapper(componentModel = "spring")
public interface PublicationMapper {

  /**
   * Convertie via la librairie mapstruct, un objet issu de la base de donnée
   * en un objet de transfert.
   *
   * @param publication Objet issu de la base de donnée
   * @return Objet de transfert converti
   */
  PublicationDto toPublicationDto(Publication publication);

  /**
   * Convertie via la librairie mapstruct, un objet issu d'une requête HTTP'
   * en un objet de transfert.
   *
   * @param publication Objet issu d'une requête HTTP
   * @return Objet de transfert converti
   */
  PublicationDto toPublicationDto(PublicationRequestModel publication);

  /**
   * Convertie via la librairie mapstruct, un objet de transfert publication
   * en un objet destiné à modéliser une réponse HTTP.
   *
   * @param publicationDto Objet de transfert a convertie
   * @return Objet modélisant une réponse HTTP.
   */
  PublicationResponseModel toPublicationResponseModel(PublicationDto publicationDto);

  /**
   * Convertie via la librairie mapstruct, un objet de transfert publication
   * en un objet destiné être enrégistrer en base de données.
   *
   * @param publicationDto Objet de transfert a convertie
   * @return Objet entity.
   */
  Publication toPublicationEntity(PublicationDto publicationDto);
}
