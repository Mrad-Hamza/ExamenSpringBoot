package tn.spring.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Patient {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPatient;
	
	private String nomPatient;
	
	private int telephone;
	
	private Date dateNaissance;
	
	@OneToMany(mappedBy="patient")
	private Set<RendezVous> rendezVous;
}
