package fr.mai.ntiers.service;

import fr.mai.ntiers.dto.CompteDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CompteService extends UserDetailsService {

  CompteDto recupereCompteParIdentifiant(String identifiant);
}
