package com.example.ccalendarbackend.Repository;


import com.example.ccalendarbackend.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.iduser = :userId")
    List<Event> findEventsByUserId(String userId);


}
