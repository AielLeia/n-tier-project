package fr.mai.ntiers.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteConnexionRequestModel {

  private String identifiant;

  private String motsDePasse;
}
