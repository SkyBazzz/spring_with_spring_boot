package com.epam.oleksandr.learningspring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.oleksandr.learningspring.business.domain.RoomReservation;
import com.epam.oleksandr.learningspring.business.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationWebServiceController {
    private ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
        Date date = DateUtils.createDateFromString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
