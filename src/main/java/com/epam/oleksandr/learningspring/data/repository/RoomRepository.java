package com.epam.oleksandr.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.oleksandr.learningspring.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
