package com.financial.advisor_system.repositories;

import com.financial.advisor_system.entities.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
}