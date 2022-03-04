package fr.mai.ntiers.service.implemente;

import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.mapper.CompteMapper;
import fr.mai.ntiers.repository.CompteRepository;
import fr.mai.ntiers.service.CompteService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompteServiceImpl implements CompteService {

  private final CompteRepository compteRepository;

  private final CompteMapper compteMapper;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public CompteServiceImpl(
    CompteRepository compteRepository,
    CompteMapper compteMapper,
    BCryptPasswordEncoder bCryptPasswordEncoder
  ) {
    this.compteRepository = compteRepository;
    this.compteMapper = compteMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String identifiantEtudiant) throws UsernameNotFoundException {
    Compte compte = compteRepository.findByIdentifiant(identifiantEtudiant).orElseThrow(() -> new UsernameNotFoundException(identifiantEtudiant));
    return new User(compte.getIdentifiant(), compte.getMotsDePasseEncrypter(), List.of());
  }

  @Override
  public CompteDto recupereCompteParIdentifiant(String identifiant) {
    return compteMapper.toCompteDto(compteRepository.findByIdentifiant(identifiant).orElseThrow(RuntimeException::new));
  }

  @Override
  public CompteDto enregisterCompte(CompteDto compteDto) {
    compteDto.setMotsDePasseEncrypter(bCryptPasswordEncoder.encode(compteDto.getMotsDePasse()));
    Compte compteEntity = compteMapper.toCompteEntity(compteDto);
    compteRepository.save(compteEntity);
    return compteMapper.toCompteDto(compteEntity);
  }

  @Override
  public Set<CompteDto> utilisateurs() {
    return compteRepository
      .findAll()
      .stream()
      .map(compteMapper::toCompteDto)
      .collect(Collectors.toSet());
  }
}
