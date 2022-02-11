package fr.mai.ntiers.controller.contract;

import fr.mai.ntiers.request.CompteEnregistrementRequestModel;
import fr.mai.ntiers.response.CompteEnregistrementResponseModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/compte")
public interface CompteControllerContract {

  @PostMapping("/enregistrement")
  CompteEnregistrementResponseModel enregistrement(@RequestBody @Valid CompteEnregistrementRequestModel compteEnregistrementRequestModel);
}
