package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Ticket;
import com.cg.entity.Orders;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
	
	@Query("SELECT t FROM Ticket t WHERE t.order = :order")
	Ticket getByOrder(@Param("order") Orders order);
	
	@Query("SELECT t FROM Ticket t WHERE t.status = 'Unresolved'")
	List<Ticket> listUnresolvedTickets();
	
	@Query("SELECT t FROM Ticket t WHERE t.status = 'Resolved'")
	List<Ticket> listResolvedTickets();
	
	@Modifying
	@Query("UPDATE Ticket t SET t.status = 'Resolved' WHERE t.ticketNumber = :ticketNumber")
	int markAsResolved(@Param("ticketNumber") int ticketNumber);
	
	
	@Query("SELECT COUNT(t) FROM Ticket t WHERE t.status = 'Resolved'")
	int countResolvedQueries();
	
	@Query("SELECT COUNT(t) FROM Ticket t WHERE t.status = 'Unresolved'")
	int countUnresolvedQueries();
	
	@Query("SELECT t FROM Ticket t WHERE t.location = :location")
	List<Ticket> getByLocation(@Param("location") String location);
}
