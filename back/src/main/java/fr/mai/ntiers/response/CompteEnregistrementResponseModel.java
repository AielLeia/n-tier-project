package fr.mai.ntiers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteEnregistrementResponseModel {

  private String identifiant;

  private String token;

  private ProfilEnregistrementResponseModel profil;
}
