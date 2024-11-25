package com.example.reservationservice.controller;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Récupérer les réservations d'un utilisateur
    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long idUser) {
        List<Reservation> reservations = reservationService.getReservationsByUser(idUser);
        return ResponseEntity.ok(reservations);
    }

    // Ajouter une nouvelle réservation
    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.addReservation(reservation);
        return ResponseEntity.ok(newReservation);
    }

    // Supprimer une réservation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
