package fr.mai.ntiers.response;

import fr.mai.ntiers.dto.CommentaireDto;
import fr.mai.ntiers.dto.CompteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicationResponseModel {

  private Long id;

  private String image;

  private String texte;

  private Set<CommentaireDto> commentaires;

  private CompteDto compte;
}
