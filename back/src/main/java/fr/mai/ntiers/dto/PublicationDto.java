package fr.mai.ntiers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicationDto {

  private Long id;

  private String image;

  private String texte;

  private Set<CommentaireDto> commentaires;
}
