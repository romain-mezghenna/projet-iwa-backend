package com.example.reservationservice.service;

import com.example.reservationservice.entity.Reservation;

import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationsByUser(Long idUser) {
        return reservationRepository.findByIdUser(idUser);
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
