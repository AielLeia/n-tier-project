package fr.mai.ntiers.controller.contract;

import fr.mai.ntiers.request.PublicationRequestModel;
import fr.mai.ntiers.response.PublicationResponseModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/publications")
public interface PublicationControllerContract {

  @GetMapping
  Set<PublicationResponseModel> publications();

  @GetMapping("/{id}")
  Set<PublicationResponseModel> publicationParUtilisateur(@PathVariable("id") String id);

  @PostMapping
  PublicationResponseModel enregisterPublicationUtilisateur(@RequestBody PublicationRequestModel publicationRequestModel);
}
