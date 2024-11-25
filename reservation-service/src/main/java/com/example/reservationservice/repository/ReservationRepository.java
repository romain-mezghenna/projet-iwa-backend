package com.example.reservationservice.repository;

import com.example.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByIdUser(Long idUser); // Méthode pour trouver les réservations par idUser
}
