package com.financial.advisor_system.repositories;

import com.financial.advisor_system.entities.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    // Spring automatically gives you methods like save(), findAll(), findById()
}