package fr.mai.ntiers.service;

import fr.mai.ntiers.dto.CompteDto;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface CompteService extends UserDetailsService {

  CompteDto recupereCompteParIdentifiant(String identifiant);

  CompteDto enregisterCompte(CompteDto compteDto);

  Set<CompteDto> utilisateurs();
}
