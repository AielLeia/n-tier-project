package fr.mai.ntiers.mapper;

import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.request.CompteEnregistrementRequestModel;
import fr.mai.ntiers.response.CompteEnregistrementResponseModel;
import fr.mai.ntiers.response.CompteResponseModel;

import org.mapstruct.Mapper;

/**
 * Regroupe l'ensemble des méthodes permettant de convertir
 * un objet compte présent sous différents aspects en un aspect cible.
 *
 * Via la librairie mapstruct, une implémentation sera automatiquement
 * générée et le modèle d'injection de dépendance est adapté à spring.
 */
@Mapper(componentModel = "spring")
public interface CompteMapper {

  /**
   * Convertie via la librairie mapstruct, un objet de requête
   * modélisant un compte en un objet de transfert.
   *
   * @param compteEnregistrementRequestModel Objet de requête a convertir.
   * @return Objet de transfert converti
   */
  CompteDto toCompteDto(CompteEnregistrementRequestModel compteEnregistrementRequestModel);

  /**
   * Convertie via la librairie mapstruct, un objet issu de la base de donnée
   * en un objet de transfert.
   *
   * @param compte Objet issu de la base de donnée
   * @return Objet de transfert converti
   */
  CompteDto toCompteDto(Compte compte);

  /**
   * Convertie via la librairie mapstruct, un objet de transfert compte
   * en une entité pouvant être enregistré en base de données.
   *
   * @param compteDto Objet de transfert a convertir
   * @return Entité enregistrable en base de données.
   */
  Compte toCompteEntity(CompteDto compteDto);

  /**
   * Convertie via la librairie mapstruct, un objet de transfert compte
   * en un objet destiné à modéliser une réponse HTTP.
   *
   * @param compteDto Objet de transfert a convertie
   * @return Objet modélisant une réponse HTTP.
   */
  CompteEnregistrementResponseModel toCompteEnregistrementResponseModel(CompteDto compteDto);

  /**
   * Convertie via la librairie mapstruct, un objet de transfert compte
   * en un objet destiné à modéliser une réponse HTTP.
   *
   * @param compteDto Objet de transfert a convertie
   * @return Objet modélisant une réponse HTTP.
   */
  CompteResponseModel toCompteResponseModel(CompteDto compteDto);
}
