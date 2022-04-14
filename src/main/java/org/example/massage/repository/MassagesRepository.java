package org.example.massage.repository;

import org.example.massage.domain.Massages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassagesRepository extends JpaRepository<Massages, Long> {
}
