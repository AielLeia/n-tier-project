package fr.mai.ntiers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentaireDto {

  private Long id;

  private String texte;

  private CompteDto compte;
}
