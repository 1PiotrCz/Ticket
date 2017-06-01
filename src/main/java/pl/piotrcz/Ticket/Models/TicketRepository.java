package pl.piotrcz.Ticket.Models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Piotr Czubkowski on 2017-06-01.
 */
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Optional<Ticket> findOne (int id);
    List<Ticket> findByAuthor(String author);
}
