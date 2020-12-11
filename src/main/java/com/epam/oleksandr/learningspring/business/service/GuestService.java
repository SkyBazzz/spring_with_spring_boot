package com.epam.oleksandr.learningspring.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.oleksandr.learningspring.business.domain.Traveler;
import com.epam.oleksandr.learningspring.data.entity.Guest;
import com.epam.oleksandr.learningspring.data.repository.GuestRepository;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Traveler> getHotelGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Traveler> travelers = new ArrayList<>();

        guests.forEach(guest -> {
            Traveler traveler = new Traveler();
            traveler.setFirstName(guest.getFirstName());
            traveler.setLastName(guest.getLastName());
            traveler.setAddress(guest.getAddress());
            traveler.setCountry(guest.getCountry());
            traveler.setGuestId(guest.getGuestId());
            traveler.setEmailAddress(guest.getEmailAddress());
            traveler.setPhoneNumber(guest.getPhoneNumber());
            traveler.setState(guest.getState());
            travelers.add(traveler);
        });
        travelers.sort((o1, o2) -> {
            if (o1.getLastName().equals(o2.getLastName())) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            } else {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });


        return travelers;
    }
}
