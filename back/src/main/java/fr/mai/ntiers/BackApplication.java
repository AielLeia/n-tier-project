package fr.mai.ntiers;

import fr.mai.ntiers.entity.Compte;
import fr.mai.ntiers.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BackApplication {

	@Autowired
	public static CompteRepository compteRepo;

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);

		Compte compte1=new Compte();
		compte1.setIdentifiant("e21807583");
		compte1.setMotsDePasseEncrypter("$2y$10$IImBjm/T8P.8rkmFBRbmHuhSigDtKU0FrF/z4SnZRSqCBP4sG4ayi");
		compteRepo.save(compte1);


		Compte compte2=new Compte();
		compte2.setIdentifiant("e21807584");
		compte2.setMotsDePasseEncrypter("$2y$10$IImBjm/T8P.8rkmFBRbmHuhSigDtKU0FrF/z4SnZRSqCBP4sG4ayi");
		compteRepo.save(compte2);

	}

	@Component
	public class NewClass {
		@Autowired
		public void setSomeThing(CompteRepository someThing) {
			BackApplication.compteRepo = someThing;
		}
	}
}
