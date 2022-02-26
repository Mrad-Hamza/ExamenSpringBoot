package tn.spring.spring.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.spring.entities.Clinique;
import tn.spring.spring.repositories.CliniqueRepository;

@Service
public class CliniqueServiceImpl implements IClinique {
	
	@Autowired
	CliniqueRepository cliniqueRepository;

	@Override
	public Clinique addClinique(Clinique clinique) {
		// TODO Auto-generated method stub
		return cliniqueRepository.save(clinique);
	}
	
	/*
	 * 
	 * @Scheduled(fixedRate = 30000)
	public void retrieveSprints() {
		int counter=1; 
		for(Sprint sp: sprintRepository.findAll()) {
			if(sp.getStartDate().before(new Date()))
				System.out.println("Sprint "+counter+":\n description: "+sp.getDescription()+", statDate: "+sp.getStartDate()+", project: "+sp.getProject().getTitle());
				counter +=1;
		}
	}
	 */

}
