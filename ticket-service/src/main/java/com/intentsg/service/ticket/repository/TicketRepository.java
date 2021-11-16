package com.intentsg.service.ticket.repository;

import com.intentsg.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findByTicketId (Long id);
    List<Ticket> findByTitle(String title);

}























//    @Query("SELECT t FROM Ticket t WHERE t.title = :string OR t.creationDate = :string OR t.price = :string")
//    List<Ticket> findByAnyField(@Param("string") String anyField);
//
//    @Query("SELECT t FROM Ticket t WHERE t.title = :title")
//    List<Ticket> findByTitle(@Param("title") String enterTitle);
//
//    @Query("SELECT t FROM Ticket t WHERE t.price = :price")
//    List<Ticket> findByPrice(@Param("price") String enterPrice);
//
//    @Query("SELECT t FROM Ticket t WHERE t.creationDate = :creationDate")
//    List<Ticket> findByDate(@Param("creationDate") String enterDate);