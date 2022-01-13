package fr.mai.ntiers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteDto {


  private Long id;

  private String motsDePasseEncrypter;

  private String identifiant;

  private ProfilDto profil;
}
