package fr.mai.ntiers.service.implemente;

import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.repository.CompteRepository;
import fr.mai.ntiers.service.CompteService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {

  private final CompteRepository compteRepository;

  public CompteServiceImpl(CompteRepository compteRepository) {
    this.compteRepository = compteRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String identifiantEtudiant) throws UsernameNotFoundException {
    return new User("1232456789", "$2y$10$2lsGiTtEHYKP7DgrmsCYMOGZysA.CLVBM5avHyN.4zyfa4u29.L0e", List.of());
  }

  @Override
  public CompteDto recupereCompteParIdentifiant(String identifiant) {
    return CompteDto
      .builder()
      .id(1L)
      .identifiant("123456789")
      .motsDePasseEncrypter("$2y$10$CCgvSBRyrHZ4FEuT6CmFju9N8Bo08EH2qFn1DH9rZsu07FWKMj/qm")
      .profil(null)
      .build();
  }
}
