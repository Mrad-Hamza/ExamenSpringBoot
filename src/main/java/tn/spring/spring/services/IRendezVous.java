package tn.spring.spring.services;

import java.util.List;

import tn.spring.spring.entities.RendezVous;
import tn.spring.spring.entities.Specialite;

public interface IRendezVous {
	public void addRDVAndAssignMedAndPatient(RendezVous rdv,Long idMedecin,Long idPatient);
	
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique,Specialite specialite);
}
