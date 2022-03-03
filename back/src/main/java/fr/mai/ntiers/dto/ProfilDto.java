package fr.mai.ntiers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfilDto {

  private Long id;

  private String nom;

  private String prenom;

  private String email;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dateNaissance;
}
