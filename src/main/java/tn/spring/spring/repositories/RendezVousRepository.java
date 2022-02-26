package tn.spring.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entities.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}
