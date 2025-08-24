package com.healthlinkteam.healthlink.repository;

import com.healthlinkteam.healthlink.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query("SELECT p FROM Patient p WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Patient> searchByName(@Param("keyword") String keyword);

}