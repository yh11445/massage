package org.example.massage.repository;

import org.example.massage.domain.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
	List<Reservations> findByUserId(Long userId);
}
