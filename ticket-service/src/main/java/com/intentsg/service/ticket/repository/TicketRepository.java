package com.intentsg.service.ticket.repository;

import com.intentsg.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT c FROM Ticket c WHERE c.title = :title")
    List<Ticket> findByTitle(@Param("title") String enterTitle);

    @Query("SELECT c FROM Ticket c WHERE c.title = :string OR c.creationYear = :string OR c.price = :string")
    List<Ticket> findByAnyField(@Param("string") String anyField);

    @Query("SELECT c FROM Ticket c WHERE c.price = :price")
    List<Ticket> findByPrice(@Param("price") String enterPrice);

    @Query("SELECT c FROM Ticket c WHERE c.creationYear = :creationYear")
    List<Ticket> findByYear(@Param("creationYear") String enterYear);

}
