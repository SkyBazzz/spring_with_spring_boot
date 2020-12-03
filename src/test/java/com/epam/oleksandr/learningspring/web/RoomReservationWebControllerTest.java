package com.epam.oleksandr.learningspring.web;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.oleksandr.learningspring.business.domain.RoomReservation;
import com.epam.oleksandr.learningspring.business.service.ReservationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {
        String dataString = "2020-01-01";
        Date date = DateUtils.createDateFromString(dataString);
        List<RoomReservation> roomReservations = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setLastName("Unit");
        roomReservation.setFirstName("Junit");
        roomReservation.setDate(date);
        roomReservation.setGuestId(1);
        roomReservation.setRoomId(100);
        roomReservation.setRoomName("Junit Room");
        roomReservation.setRoomNumber("J1");
        roomReservations.add(roomReservation);

        given(reservationService.getRoomReservationForDate(date)).willReturn(roomReservations);

        this.mockMvc.perform(get("/reservations?date=2020-01-01"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("Unit, Junit")));


    }
}

