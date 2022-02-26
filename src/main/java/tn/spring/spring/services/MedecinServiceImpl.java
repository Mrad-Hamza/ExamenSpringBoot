package tn.spring.spring.services;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.spring.entities.Clinique;
import tn.spring.spring.entities.Medecin;
import tn.spring.spring.entities.RendezVous;
import tn.spring.spring.repositories.CliniqueRepository;
import tn.spring.spring.repositories.MedecinRepository;
import tn.spring.spring.repositories.RendezVousRepository;

@Service
public class MedecinServiceImpl implements IMedecin{

	@Autowired
	MedecinRepository medecinRepository;
	
	@Autowired
	CliniqueRepository cliniqueRepository;
	

	@Override
	public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
		Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
		Set<Medecin> medecins = clinique.getMedecins();
		medecins.add(medecin);
		clinique.setMedecins(medecins);
		cliniqueRepository.save(clinique);
		
		Set<Clinique> cliniques = medecin.getCliniques();
		//cliniques.add(clinique);
		medecin.setCliniques(cliniques);
		medecinRepository.save(medecin);
		return medecin;
	}


	@Override
	public int getNbrRendezVousMedecin(Long idMedecin) {
		Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
		
		return medecin.getRendezVous().size();
	}


	@Override
	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
		Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
		Set<RendezVous> rdv = medecin.getRendezVous();
		int revenu=0;
		for (RendezVous rendezVous : rdv) {
			if (rendezVous.getDateRDV().after(startDate)&&rendezVous.getDateRDV().before(endDate)) {
				revenu=revenu+medecin.getPrixConsultation();
			}
		}
		return revenu;
	}


	@Override
	public Medecin getMed(Long id) {
		return medecinRepository.findById(id).orElse(null);
	}
	
	
	
	/*
	 * @Scheduled(fixedRate = 30000)
	public void retrieveSprints() {
		int counter=1; 
		for(Sprint sp: sprintRepository.findAll()) {
			if(sp.getStartDate().before(new Date()))
				System.out.println("Sprint "+counter+":\n description: "+sp.getDescription()+", statDate: "+sp.getStartDate()+", project: "+sp.getProject().getTitle());
				counter +=1;
		}
	}
	 */
}
