package tn.spring.spring.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entities.Clinique;
import tn.spring.spring.services.IClinique;

@RestController
public class CliniqueRestController {
	
	@Autowired
	IClinique cliniqueService;
	
	 @PostMapping("/addClinique")	
	 @ResponseBody
		public Clinique addProject(@RequestBody Clinique c) {
			return cliniqueService.addClinique(c);
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
	public Set<Project> getProjectsByUser(@PathVariable("id")int id){
		Set<Project> listP = projectService.getProjectsByUser(id);
		return listP;
	}
	 * 
	 */

}
