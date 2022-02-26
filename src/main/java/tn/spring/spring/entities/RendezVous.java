package tn.spring.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class RendezVous {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRDV;
	
	@NonNull
	private String remarque;
	
	private Date dateRDV;
	
//	@OneToMany(cascade = CascadeType.ALL)
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Medecin medecin;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Patient patient;
	
	

	

}
