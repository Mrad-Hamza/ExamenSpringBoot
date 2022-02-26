package tn.spring.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entities.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long>{

}
