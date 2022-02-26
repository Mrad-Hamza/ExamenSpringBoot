package tn.spring.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.spring.entities.Clinique;
import tn.spring.spring.entities.Medecin;
import tn.spring.spring.entities.Patient;
import tn.spring.spring.entities.RendezVous;
import tn.spring.spring.entities.Specialite;
import tn.spring.spring.repositories.CliniqueRepository;
import tn.spring.spring.repositories.MedecinRepository;
import tn.spring.spring.repositories.PatientRepository;
import tn.spring.spring.repositories.RendezVousRepository;

@Service
public class RendezVousServiceImpl implements IRendezVous{
	
	@Autowired
	RendezVousRepository rendezVousRepository;
	
	@Autowired 
	MedecinRepository medecinRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	CliniqueRepository cliniqueRepository;
	
	

	@Override
	public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
		Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
		Set<RendezVous> rdvM = medecin.getRendezVous();
		rdvM.add(rdv);
		medecin.setRendezVous(rdvM);
		medecinRepository.save(medecin);
		
		Patient patient = patientRepository.findById(idPatient).orElse(null);
		Set<RendezVous> rdvP = patient.getRendezVous();
		rdvP.add(rdv);
		patient.setRendezVous(rdvP);
		patientRepository.save(patient);
		
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
		rendezVousRepository.save(rdv);
	}



	@Override
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
		Clinique clinique = cliniqueRepository.findById(idClinique).orElse(null);
		Set<Medecin> medecins = clinique.getMedecins();
		for (Medecin medecin : medecins) {
			if (medecin.getSpecialite()!=specialite) {
				medecins.remove(medecin);
			}
		}
		List<RendezVous> rdv = null ;
		for (Medecin medecin : medecins) {
			rdv.addAll(medecin.getRendezVous());
		}
		return rdv;
	}
	@Scheduled(fixedRate = 30000)
	public void retrieveRendezVous() {
		
		for(RendezVous rdv : rendezVousRepository.findAll()) {
			if(rdv.getDateRDV().before(new Date()))
				System.out.println("La Liste des RendezVous :  "+rdv.getDateRDV()+": Medecin : "+rdv.getMedecin().getNomMedecin()+", Patient : "+rdv.getPatient().getNomPatient()+".");
		}
	}

}
