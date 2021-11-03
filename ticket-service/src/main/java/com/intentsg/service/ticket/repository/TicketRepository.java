package com.intentsg.service.ticket.repository;

import com.intentsg.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.description = :string OR t.title = :string OR t.time = :string")
    List<Ticket> findByString(@Param("string") String text);
}
