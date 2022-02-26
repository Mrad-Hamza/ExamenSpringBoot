package tn.spring.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clinique {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClinique;
	
	@NonNull
	private String nomClinique,adresse;

	private int telephone;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Medecin> medecins;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="project")
	//	@ManyToMany(mappedBy="projects", cascade = CascadeType.ALL)
}
