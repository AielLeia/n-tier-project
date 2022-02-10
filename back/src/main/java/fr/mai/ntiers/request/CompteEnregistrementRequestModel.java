package fr.mai.ntiers.request;

import fr.mai.ntiers.validator.Identifiant;
import fr.mai.ntiers.validator.MotDePasse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteEnregistrementRequestModel {

  @Identifiant(
    messageBlank = "\"identifiant\" ne peut pas contenir une chaîne vide",
    messagePattern = "\"identifiant\" n'est pas valide"
  )
  private String identifiant;

  @MotDePasse(
    messagePattern = "\"motsDePasse\" doit contenir au moins une majuscule, une minuscule, un caractère spécial et un chiffre.",
    messageNotBlank = "\"motsDePasse\" ne peut pas être vide",
    messageSize = "\"motsDePasse\" doit être entre 8 et 128 caractères"
  )
  private String motsDePasse;

  private ProfilEnregistrementRequestModel profil;
}
