package fr.mai.ntiers.controller;

import fr.mai.ntiers.controller.contract.CompteControllerContract;
import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.mapper.CompteMapper;
import fr.mai.ntiers.request.CompteEnregistrementRequestModel;
import fr.mai.ntiers.response.CompteEnregistrementResponseModel;
import fr.mai.ntiers.response.CompteResponseModel;
import fr.mai.ntiers.service.CompteService;

import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CompteController implements CompteControllerContract {

  private final CompteMapper compteMapper;

  private final CompteService compteService;

  public CompteController(
    CompteMapper compteMapper,
    CompteService compteService
  ) {
    this.compteMapper = compteMapper;
    this.compteService = compteService;
  }

  @Override
  public Set<CompteResponseModel> utilisateurs() {
    return compteService
      .utilisateurs()
      .stream()
      .map(compteMapper::toCompteResponseModel)
      .collect(Collectors.toSet());
  }

  @Override
  public CompteEnregistrementResponseModel enregistrement(CompteEnregistrementRequestModel compteEnregistrementRequestModel) {
    CompteDto compteDto = compteMapper.toCompteDto(compteEnregistrementRequestModel);
    CompteDto result = compteService.enregisterCompte(compteDto);
    return compteMapper.toCompteEnregistrementResponseModel(result);
  }
}
