package tn.spring.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
