package fr.mai.ntiers.controller.contract;

import fr.mai.ntiers.request.CompteEnregistrementRequestModel;
import fr.mai.ntiers.response.CompteEnregistrementResponseModel;
import fr.mai.ntiers.response.CompteResponseModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.Set;

@RequestMapping("/compte")
public interface CompteControllerContract {

  @GetMapping
  Set<CompteResponseModel> utilisateurs();

  @PostMapping("/enregistrement")
  CompteEnregistrementResponseModel enregistrement(@RequestBody @Valid CompteEnregistrementRequestModel compteEnregistrementRequestModel);
}
