package fr.mai.ntiers.response;

import fr.mai.ntiers.dto.ProfilDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteResponseModel {

  private Long id;

  private String motsDePasseEncrypter;

  private String motsDePasse;

  private String identifiant;

  private ProfilDto profil;
}
