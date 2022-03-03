package fr.mai.ntiers.request;

import fr.mai.ntiers.validator.Obligatoire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfilEnregistrementRequestModel {

  @Obligatoire(minLength = 2, maxLength = 30)
  private String nom;

  @Obligatoire(minLength = 2, maxLength = 30)
  private String prenom;

  @Email
  private String email;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dateNaissance;
}
