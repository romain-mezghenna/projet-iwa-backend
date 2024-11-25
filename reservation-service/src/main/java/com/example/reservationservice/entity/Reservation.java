package com.example.reservationservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation; // Correspond à idReservation

    private LocalDate dateDebut; // Correspond à date_debut
    private LocalDate dateFin; // Correspond à date_fin
    private String statut; // Correspond à statut
    private String messageVoyageur; // Correspond à message_voyageur

    @Column(name = "idUser")
    private Long idUser; // Correspond à idUser
    private Long idEmplacement;
}