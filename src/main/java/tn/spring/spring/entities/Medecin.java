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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Medecin {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	
	@NonNull
	private String nomMedecin;
	
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	
	private int telephone,prixConsultation;
	
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	
	
	@ManyToMany(mappedBy="medecins")
	private Set<Clinique> cliniques;
	
	@OneToMany(mappedBy="medecin")
	private Set<RendezVous> rendezVous;
	
	
	

}
