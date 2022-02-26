package tn.spring.spring.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entities.RendezVous;
import tn.spring.spring.entities.Specialite;
import tn.spring.spring.services.IRendezVous;

@RestController
public class RendezVousRestController {

	@Autowired
	IRendezVous rendezVousService;
	
	@PostMapping("/addRDV/{idM}/{idP}")	
	@ResponseBody
	public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@PathVariable("idM") Long idMedecin,@PathVariable("idP") Long idPatient) {
		rendezVousService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
	}

	@GetMapping("/getrdv/{id}")
	@ResponseBody
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("id") Long idClinique,@RequestBody  Specialite specialite) {
		return rendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
	}

	/*
	 * 
	 * 
	 * @PostMapping("/addProject")	
	@ResponseBody
	public void addProject(@RequestBody Project p) {
		projectService.addProject(p);
	}
	
	@GetMapping("/getProjectsByUser/{id}")
	@ResponseBody
	public Set<Project> getProjectsByUser(@PathVariable("id")int id){
		Set<Project> listP = projectService.getProjectsByUser(id);
		return listP;
	}
	 */
}
