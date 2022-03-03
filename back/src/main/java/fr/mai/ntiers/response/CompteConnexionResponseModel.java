package fr.mai.ntiers.response;

import fr.mai.ntiers.dto.CompteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteConnexionResponseModel {

  private String token;

  private CompteDto compteDto;

}
