package tn.spring.spring.services;

import java.util.Date;

import tn.spring.spring.entities.Medecin;

public interface IMedecin {
	public Medecin getMed(Long id);
	
	public Medecin addMedecinAndAssignToClinique(Medecin medecin,Long cliniqueId);
	
	public int getNbrRendezVousMedecin(Long idMedecin);
	
	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
