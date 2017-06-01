package pl.piotrcz.Ticket.Models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Piotr Czubkowski on 2017-06-01.
 */
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
