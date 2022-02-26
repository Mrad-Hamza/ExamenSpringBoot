package tn.spring.spring.controllers;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entities.Medecin;
import tn.spring.spring.services.IMedecin;

@RestController
public class MedecinRestController {
	
	@Autowired 
	IMedecin medecinService;
	
	@PostMapping("/addMedecin/{id}")	
	@ResponseBody
	public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin,@PathVariable("id") Long cliniqueId) {
		return medecinService.addMedecinAndAssignToClinique(medecin, cliniqueId);
	}
	
	@GetMapping("/getMed/{id}")
	@ResponseBody
	public Medecin getMed(@PathVariable("id") Long idMedecin) {
		return medecinService.getMed(idMedecin);
	}
	
	@GetMapping("/getNbrRdvMedecin/{id}")
	@ResponseBody
	public int getNbrRendezVousMedecin(@PathVariable("id") Long idMedecin) {
		return medecinService.getNbrRendezVousMedecin(idMedecin);
	}
	
	@GetMapping("/getRevenuMedecin/{id}/{d1}/{d2}")
	@ResponseBody
	public int getRevenuMedecin(@PathVariable("id") Long idMedecin,@PathVariable("d1") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,@PathVariable("d2") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		return medecinService.getRevenuMedecin(idMedecin, startDate, endDate);
	}

	/*
	 * 
	 * @PostMapping("/addProject")	
	@ResponseBody
	public void addProject(@RequestBody Project p) {
		projectService.addProject(p);
	}
	
	@GetMapping("/getProjectsByUser/{id}")
	@ResponseBody
	public Set<Project> getProjectsByUser(@PathVariable("id") id){
		Set<Project> listP = projectService.getProjectsByUser(id);
		return listP;
	}
	 */

}
